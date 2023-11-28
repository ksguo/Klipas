package main.com.universitysystem.model;
import java.util.List;
public class Course {

    private String courseId;
    private String courseName;
    private List<String> schedule; // List of class times
    // Other course properties like credits, instructor, etc.

    // Constructor
    public Course(String courseId, String courseName, List<String> schedule) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.schedule = schedule;
    }


    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<String> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<String> schedule) {
        this.schedule = schedule;
    }
}
