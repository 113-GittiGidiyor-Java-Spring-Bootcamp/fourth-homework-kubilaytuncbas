package service;

import dto.StudentDTO;
import exceptions.StudentAgeNotValidException;
import lombok.RequiredArgsConstructor;
import mappers.StudentMapper;
import model.Student;
import org.springframework.stereotype.Service;
import repository.StudentDao;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentManager implements StudentService{

    private final StudentDao studentDao;
    private final StudentMapper studentMapper;

    /**
     *
     * @return
     */
 @Override
    public List<Student> findAll() {
        return (List<Student>) studentDao.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
 @Override
    public Student findById(int id) {
        return studentDao.findById(id).get();
    }

    /**
     *
     * @param studentDTO
     * @return
     */
 @Override
    public Student save(StudentDTO studentDTO) {
        if (!studentAgeVerify(studentDTO)){
            throw new StudentAgeNotValidException("Öğrenci yaşı 18 den küçük 40 yaştan büyük olamaz!!");
        }else{
            Student student=studentMapper.mapFromStudentDTOtoStudent(studentDTO);
            return studentDao.save(student);
        }

    }

    /**
     *
     * @param id
     */
 @Override
    public void deleteById(int id) {
        studentDao.deleteById(id);
    }

    /**
     *
     * @param student
     */
 @Override
    public void update(Student student) {
        studentDao.save(student);
    }

    /**
     *
     * @return
     */
 @Override
    public List<Student> getStudentsWithGroupByGender() {
        return studentDao.getStudentsWithGroupByGender();
    }

    /**
     *
     * @param name
     */
 @Override
    public void deleteStudentByName(String name) {

    }

    public boolean studentAgeVerify(StudentDTO student){
        if (18<(LocalDate.now().getYear()-student.getBirthDate().getYear()) && ((LocalDate.now().getYear()-student.getBirthDate().getYear())<40) == true ){
            return  true;
        }else
        {return false;}
    }
}
