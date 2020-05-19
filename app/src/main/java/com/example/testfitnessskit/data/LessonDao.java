package com.example.testfitnessskit.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface LessonDao {

    @Query("SELECT * FROM lessonDB")
    LiveData<List<LessonDB>> getAllLesson();

    @Query("DELETE FROM lessonDB")
    void deleteAllLessonsDB();

    @Insert
    void insertLesson(List<LessonDB> lessonDBList);

    @Query("SELECT * FROM lessonDB ORDER BY weekDay")
    LiveData<List<LessonDB>> getLessonDayOfWeek(int weekDay);
}
