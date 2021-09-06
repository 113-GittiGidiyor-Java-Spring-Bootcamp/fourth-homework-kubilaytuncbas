package service;

import dto.CourseDTO;
import lombok.RequiredArgsConstructor;
import mappers.CourseMapper;
import model.Course;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.CourseDao;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CourseManager implements CourseService {

    private final CourseDao courseDao;

    private final CourseMapper courseMapper;

    @Override
    public List<Course> findAll() {
        return (List<Course>) courseDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Course findById(int id) {
        return courseDao.findById(id).get();
    }

    @Override
    public Course save(CourseDTO courseDTO) {
        Course course=courseMapper.mapFromCourseDTOtoCourse(courseDTO);
        return courseDao.save(course);

    }

    @Override
    public void deleteById(int id) {
        courseDao.deleteById(id);
    }

    @Override
    public void update(Course course) {
        courseDao.save(course);
    }
}
