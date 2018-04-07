# TimetableUI
[![](https://jitpack.io/v/yaoandy107/TimetableUI.svg)](https://jitpack.io/#yaoandy107/TimetableUI)
[![GitHub license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)

A UI library of timetable by NPC from National Taipei University of Technology.



## Screenshots
![](https://i.imgur.com/UFJXuVp.png)


## Download
TimetableUI is available on [**jitpack.io**](https://jitpack.io/). See the full information [here](https://jitpack.io/#yaoandy107/TimetableUI/).

**Gradle dependency:**

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

```groovy
dependencies {
    compile 'com.github.yaoandy107:TimetableUI:v1.0.0'
}
```

## Usage
### Basic
Once imported into your project, you just need to put it into your layout like:

```xml
<me.yaoandy107.ntut_timetable.CourseTableLayout  
   android:id="@+id/courseTable"  
   android:layout_width="match_parent"  
   android:layout_height="match_parent" />
```

And then you can start to add some courses like this.
```java
public class MainActivity extends AppCompatActivity {  
    @Override  
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_main);  

        CourseTableLayout courseTable = findViewById(R.id.courseTable);  
        StudentCourse studentCourse = new StudentCourse();  
        ArrayList<CourseInfo> courseInfoList = new ArrayList<>();  

        // Add course1 - sample1  
        CourseInfo courseInfo1 = new CourseInfo();  
        courseInfo1.setName("Course 1");  
        courseInfo1.setCourseTime("1 2", "", "4", "", "", "", "");  
        courseInfoList.add(courseInfo1);  

        // Add course2 - sample2 
        CourseInfo courseInfo2 = new CourseInfo(); 
        courseInfo2.setName("Course 2");  
        courseInfo2.setCourseTime(new String[]{"4", "5", "3", "6 7 8", "", "", ""});  
        courseInfoList.add(courseInfo2);  

        // Set timetable
        studentCourse.setCourseList(courseInfoList);  
        courseTable.setStudentCourse(studentCourse);  
    }  
}
```
#### setCourseTime
Set the course time in order of Monday to Sunday.
For example, `courseInfo1` is at the first and second period on Monday, also the fourth on Wednesday.

### Add OnClickListner for course block
If you want to add OnClickListner for course block
```java
courseTable.setOnCourseClickListener(new View.OnClickListener() {  
    @Override  
    public void onClick(View view) {  
        CourseInfo item = (CustomCourseInfo) view.getTag();  
        showInfoDialog(view.getId(), item.getName(), item);  
    }  
});

```

### Add Initialize Listener
If you want to execute code when layout finished initial.
```java
courseTable.setTableInitializeListener(new CourseTableLayout.TableInitializeListener() {  
    @Override  
    public void onTableInitialized(CourseTableLayout course_table) {  
        Toast.makeText(MainActivity.this, "Finish intialized", Toast.LENGTH_SHORT).show();  
    }  
});

```
### Customize Course Info
By default, CourseInfo have two basis parameters which are name and times, so you don't have to implement by yourself.

If you want to have more info in CourseInfo, you can extends CourseInfo in our library and add some parameter yourself.
```java
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

```
## Contributing to the project
### Issues
Feel free to submit issues requests.

### Contributing
We follow the "fork-and-pull" Git workflow, be free to contribute for this project.
1.  **Fork** the repo on GitHub
2.  **Clone** the project to your own machine
3.  **Commit** changes to your own branch
4.  **Push** your work back up to your fork
5.  Submit a **Pull request** so that we can review your changes

NOTE: Be sure to merge the latest from "upstream" before making a pull request!


## License
```
Copyright (c) 2018 Wei Chen Yao (https://yaoandy107.github.io/).

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
