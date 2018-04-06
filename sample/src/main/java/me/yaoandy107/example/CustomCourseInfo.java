package me.yaoandy107.example;

import me.yaoandy107.ntut_timetable.model.CourseInfo;

/**
 * Created by yaoweichen on 2018/3/8.
 */

public class CustomCourseInfo extends CourseInfo {
    private String loaction;
    private String id;
    private String teacher;

    public String getLoaction() {
        return loaction;
    }

    public void setLoaction(String loaction) {
        this.loaction = loaction;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
}
