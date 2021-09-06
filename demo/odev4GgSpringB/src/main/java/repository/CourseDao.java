package repository;


import model.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseDao extends CrudRepository<Course,Integer> {

    List<Course> findByCourseName(String name);
    void deleteByCourseName(String name);
    List<Course> findAllByCourseCode(String courseCode);
}
