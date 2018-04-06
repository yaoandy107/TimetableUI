package me.yaoandy107.example;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import me.yaoandy107.ntut_timetable.CourseTableLayout;
import me.yaoandy107.ntut_timetable.model.CourseInfo;
import me.yaoandy107.ntut_timetable.model.StudentCourse;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        CourseTableLayout courseTable = findViewById(R.id.courseTable);
        StudentCourse studentCourse = new StudentCourse();
        ArrayList<CourseInfo> courseInfoList = new ArrayList<>();

        // 創建課程 - 範例 1
        CustomCourseInfo customCourseInfo = new CustomCourseInfo();
        customCourseInfo.setName("1號課程");
        customCourseInfo.setCourseTime("1 2", "", "2", "3", "4", "", "");
        customCourseInfo.setLoaction("Taiwan");
        courseInfoList.add(customCourseInfo);

        // 創建課程 - 範例 2
        CustomCourseInfo customCourseInfo1 = new CustomCourseInfo();
        customCourseInfo1.setName("2號課程");
        customCourseInfo1.setCourseTime(new String[]{"4", "5", "3", "6 7 8", "", "", ""});
        customCourseInfo1.setLoaction("Taiwan");
        courseInfoList.add(customCourseInfo1);

        // 設置課表
        studentCourse.setCourseList(courseInfoList);
        courseTable.setStudentCourse(studentCourse);
        courseTable.setTableInitializeListener(new CourseTableLayout.TableInitializeListener() {
            @Override
            public void onTableInitialized(CourseTableLayout course_table) {
                Toast.makeText(MainActivity.this, "課表初始化完成", Toast.LENGTH_SHORT).show();
            }
        });
        courseTable.setOnCourseClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomCourseInfo item = (CustomCourseInfo) view.getTag();
                showInfoDialog(view.getId(), item.getName(), item);
            }
        });
    }

    private void showInfoDialog(int id, String courseName, CustomCourseInfo course) {
        String message = String.format(Locale.TAIWAN, "%s%s\n%s%s\n%s%s",
                "課號：", course.getId(),
                "地點：", course.getLoaction(),
                "授課老師：", course.getTeacher());
        AlertDialog.Builder courseDialogBuilder = new AlertDialog.Builder(this)
                .setTitle(courseName)
                .setMessage(message)
                .setPositiveButton("詳細內容", null);
        courseDialogBuilder.show();
    }
}
