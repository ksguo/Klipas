package main.com.universitysystem.service;

import main.com.universitysystem.dao.CourseDAO;
import main.com.universitysystem.model.Course;
import java.util.List;

public class CourseService {
    private CourseDAO courseDAO;

    public CourseService(CourseDAO courseDAO) {
        this.courseDAO = courseDAO;
    }

    public List<Course> getAllCourses() {
        return courseDAO.getAllCourses();
    }
    // Additional methods for course registration can be added here
}

