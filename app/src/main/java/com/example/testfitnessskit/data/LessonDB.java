package com.example.testfitnessskit.data;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.testfitnessskit.pojo.Lesson;
import com.example.testfitnessskit.pojo.TeacherV2;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "lessonDB")
public class LessonDB {

    @PrimaryKey(autoGenerate = true)
    private int uniqId;
    private String name;
    private String description;
    private String place;
    private String teacher;
    private String startTime;
    private String endTime;
    private int weekDay;

    public int getUniqId() {
        return uniqId;
    }

    public void setUniqId(int uniqId) {
        this.uniqId = uniqId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getWeekDay() {
        return weekDay;
    }

    public void setWeekDay(int weekDay) {
        this.weekDay = weekDay;
    }

    public LessonDB(int uniqId, String name, String description, String place, String teacher, String startTime, String endTime, int weekDay) {
        this.uniqId = uniqId;
        this.name = name;
        this.description = description;
        this.place = place;
        this.teacher = teacher;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weekDay = weekDay;
    }
        @Ignore
        public LessonDB(String name, String description, String place, String teacher, String startTime, String endTime, int weekDay) {
            this.name = name;
            this.description = description;
            this.place = place;
            this.teacher = teacher;
            this.startTime = startTime;
            this.endTime = endTime;
            this.weekDay = weekDay;
    }
}

