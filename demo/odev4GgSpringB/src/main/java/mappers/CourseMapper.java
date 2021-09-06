package mappers;
import dto.CourseDTO;
import model.Course;
import org.mapstruct.Mapper;

@Mapper
public interface CourseMapper {
    Course mapFromCourseDTOtoCourse(CourseDTO dto);
    CourseDTO mapFromCoursetoCourseDTO(Course course);
}
