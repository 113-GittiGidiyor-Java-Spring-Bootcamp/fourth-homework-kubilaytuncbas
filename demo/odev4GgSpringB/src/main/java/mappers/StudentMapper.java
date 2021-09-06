package mappers;

import dto.StudentDTO;
import model.Student;
import org.mapstruct.Mapper;

@Mapper
public interface StudentMapper {

    Student mapFromStudentDTOtoStudent(StudentDTO studentDTO);
    StudentDTO mapFromStudenttoStudentDTO(Student student);
}
