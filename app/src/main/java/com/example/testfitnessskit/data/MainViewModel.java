package com.example.testfitnessskit.data;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private static LessonDataBase dataBase;
    private LiveData<List<LessonDB>> lessons;

    public MainViewModel(@NonNull Application application) {
        super(application);
        dataBase = LessonDataBase.getInstance(getApplication());
        lessons = dataBase.lessonDao().getAllLesson();
    }

    public void insertLessonToDB(List<LessonDB> lessonDB) {
        new InsertTaskLessonToDB().execute(lessonDB);
    }


    public static class InsertTaskLessonToDB extends AsyncTask<List<LessonDB>, Void, Void> {
        @Override
        protected Void doInBackground(List<LessonDB>... lessonDBS) {
            if (lessonDBS != null || lessonDBS.length > 0) {
                try {
                    dataBase.lessonDao().insertLesson(lessonDBS[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

    public LiveData<List<LessonDB>> getLessonToDayOfWeek(int weekDay) {
        new GetLessonTaskToDayOfWeek().execute(weekDay);
        return null;
    }

    public static class GetLessonTaskToDayOfWeek extends AsyncTask<Integer, Void, LessonDB> {
        @Override
        protected LessonDB doInBackground(Integer... integers) {
            if (integers != null || integers.length > 0) {
                try {
                    dataBase.lessonDao().getLessonDayOfWeek(integers[0]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return null;
        }
    }

    public LiveData<List<LessonDB>> deleteAll() {
        new DeleteAllTask().execute();
        return null;
    }

    public static class DeleteAllTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            dataBase.lessonDao().deleteAllLessonsDB();
            return null;
        }
    }
}
