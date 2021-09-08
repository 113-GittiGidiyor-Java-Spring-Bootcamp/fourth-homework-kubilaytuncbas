package service;

import dto.CourseDTO;
import exceptions.CourseIsAlreadyExistException;
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

    /**
     *
     * @return
     */
     @Override
    public List<Course> findAll() {
        return (List<Course>) courseDao.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
     @Override
    @Transactional(readOnly = true)
    public Course findById(int id) {
        return courseDao.findById(id).get();
    }

    /**
     *
     * @param courseDTO
     * @return
     */
     @Override
    public Course save(CourseDTO courseDTO) {
        if (!courseIsAlreadyExist(courseDTO.getCourseCode())){
            throw new CourseIsAlreadyExistException("Aynı ders kodu farklı bir derste kullanılmaktadır!");
        }else{
            Course course=courseMapper.mapFromCourseDTOtoCourse(courseDTO);
            return courseDao.save(course);
        }


    }

    /**
     *
     * @param id
     */
    @Override
    public void deleteById(int id) {
        courseDao.deleteById(id);
    }

    /**
     *
     * @param course
     */
 @Override
    public void update(Course course) {
        courseDao.save(course);
    }

    /**
     *
     * @param name
     * @return
     */
 @Override
    public List<Course> findByCourseName(String name) {
        return courseDao.findByCourseName(name);
    }

    /**
     *
     * @param name
     */
 @Override
    public void deleteByCourseName(String name) {
        courseDao.deleteByCourseName(name);
    }

    /**
     *
     * @param courseCode
     * @return
     */
 @Override
    public List<Course> findAllByCourseCode(String courseCode) {
        return courseDao.findAllByCourseCode(courseCode);
    }
    private boolean courseIsAlreadyExist(String courseCode){
        if (findAllByCourseCode(courseCode)==null){
            return true;
        }else
        return false;
    }
}
