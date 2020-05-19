package com.example.testfitnessskit.data;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.testfitnessskit.pojo.Lesson;
import com.example.testfitnessskit.pojo.TeacherV2;

@Entity (tableName = "lessonDB")
public class LessonDB extends Lesson {
    @PrimaryKey (autoGenerate = true)
    private int uniqid;
//
//    public LessonDB(String name, String description, String place, String teacher, String startTime, String endTime, int weekDay, String appointmentId, String serviceId, boolean pay, boolean appointment, TeacherV2 teacherV2, String color, int availability) {
//        super(name,description,);


    public LessonDB(String name, String description, String place, String teacher, String startTime, String endTime, int weekDay, String appointmentId, String serviceId, boolean pay, boolean appointment, TeacherV2 teacherV2, String color, int availability, int uniqid) {
        super(name, description, place, teacher, startTime, endTime, weekDay, appointmentId, serviceId, pay, appointment, teacherV2, color, availability);
        this.uniqid = uniqid;
    }
}

