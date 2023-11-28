package main.com.universitysystem.dao;

import main.com.universitysystem.model.Course;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseDAO {
    private Map<String, Course> courses;

    public CourseDAO() {
        courses = new HashMap<>();
        courses.put("C101", new Course("C101", "Introduction to Programming", Arrays.asList("Mon 10:00", "Wed 10:00")));
        courses.put("C102", new Course("C102", "Advanced Java", Arrays.asList("Tue 11:00", "Thu 11:00")));
        // Add more courses as needed
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(courses.values());
    }
}
