package service;


import dto.CourseDTO;
import model.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAll();
    Course findById(int id);
    Course save(CourseDTO courseDTO);
    void deleteById(int id);
    void update(Course course);
    List<Course> findByCourseName(String name);
    void deleteByCourseName(String name);
    List<Course> findAllByCourseCode(String courseCode);
}
