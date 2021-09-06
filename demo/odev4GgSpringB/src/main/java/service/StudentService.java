package service;
import dto.StudentDTO;
import model.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();
    Student findById(int id);
    Student save(StudentDTO studentDTO);
    void deleteById(int id);
    void update(Student student);
    List<Student> getStudentsWithGroupByGender();
    void deleteStudentByName(String name);
}
