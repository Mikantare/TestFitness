package com.example.testfitnessskit.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.testfitnessskit.pojo.Lesson;

import java.util.List;

@Dao
public interface LessonDao {

    @Query("SELECT * FROM lessonDB")
    LiveData <List <LessonDB>> getAllLesson();

    @Query("DELETE FROM lessonDB")
    void deleteAllLessonsDB();

    @Insert
    void insertLesson(LessonDB lessonDBList);

}
