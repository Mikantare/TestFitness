package com.example.testfitnessskit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.testfitnessskit.API.ApiFactory;
import com.example.testfitnessskit.API.ApiServis;
import com.example.testfitnessskit.adapter.LessonAdapter;
import com.example.testfitnessskit.data.LessonDB;
import com.example.testfitnessskit.data.MainViewModel;
import com.example.testfitnessskit.pojo.Lesson;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerViewLessons;
    private LessonAdapter adapter;
    private Lesson lesson;
    private MainViewModel viewModel;
    private LessonDB lessonDB;


    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewLessons = findViewById(R.id.recyclerViewLessons);
        adapter = new LessonAdapter();
        adapter.setLessons(new ArrayList<LessonDB>());
        recyclerViewLessons.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewLessons.setAdapter(adapter);
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        ApiFactory apiFactory = ApiFactory.getInstance();
        final ApiServis apiServis = apiFactory.getApiServis();
        apiServis.getLessons()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Lesson>>() {
                    @Override
                    public void accept(List<Lesson> lessons) throws Exception {
                        viewModel.deleteAll();
                        for (Lesson lesson: lessons){
                            lessonDB = new LessonDB(lesson.getName(),lesson.getDescription(),lesson.getPlace(),lesson.getTeacher(),lesson.getStartTime(),lesson.getEndTime(),lesson.getWeekDay());
                            viewModel.insertLessonToDB(lessonDB);
                        }
                        downLoadFromDB();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.i("Ошибка", throwable.getMessage());
                        downLoadFromDB();
                        Toast.makeText(MainActivity.this, "Загрузка из памяти, проверьте подключение к интернету", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void downLoadFromDB () {
        final LiveData<List<LessonDB>> lessonsFromDB = viewModel.getLessons();
        lessonsFromDB.observe(MainActivity.this, new Observer <List <LessonDB>>() {
            @Override
            public void onChanged(List <LessonDB> lessonDBS) {
                adapter.setLessons(lessonDBS);
            }
        });
    }


}
