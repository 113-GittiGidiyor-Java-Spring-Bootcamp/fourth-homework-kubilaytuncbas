package repository;
import model.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentDao extends CrudRepository<Student,Integer> {

    @Query("select s.Gender,count(s.Gender) from Student s Group by s.Gender")
    List<Student> getStudentsWithGroupByGender();

    void deleteStudentByName(String name);


}
