package me.yaoandy107.ntut_timetable.model;

import java.util.ArrayList;

/**
 * Created by blackmaple on 2017/5/4.
 */

public class StudentCourse {
    private ArrayList<CourseInfo> courseList = null;

    public ArrayList<CourseInfo> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<CourseInfo> courseList) {
        this.courseList = courseList;
    }


}