package com.example.testfitnessskit.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {LessonDB.class}, version = 1, exportSchema = false)
public abstract class LessonDataBase extends RoomDatabase {

    private static LessonDataBase dataBase;
    private static final String DB_NAME = "lessons.db";
    private static final Object LOCK = new Object();

    public static LessonDataBase getInstance(Context context) {
        synchronized (LOCK) {
            if (dataBase == null){
                dataBase = Room.databaseBuilder(context, LessonDataBase.class, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .build();
            }
        }
        return dataBase;
    }

    public abstract LessonDao lessonDao();

}
