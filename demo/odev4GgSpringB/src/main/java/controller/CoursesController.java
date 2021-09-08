package controller;
import dto.CourseDTO;
import model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {

    CourseService courseService;

    @Autowired
    public CoursesController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/findcourses")
    public ResponseEntity<List<Course>> findAll(){
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/saveCourse")
    public Course saveCourse(@RequestBody CourseDTO courseDTO){
        return courseService.save(courseDTO);
    }
    @PutMapping("/updateCourse")
    public void updateCourse(@RequestBody Course course){
        courseService.update(course);
    }
    @DeleteMapping("/delete")
    public void deleteCourse(@RequestBody int id){
        courseService.deleteById(id);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable int id ){
        return new ResponseEntity(courseService.findById(id),HttpStatus.OK);
    }
    @DeleteMapping("/deleteByCourseName")
    public void  deleteByCourseName(@RequestBody String name){
        courseService.deleteByCourseName(name);
    }

}
