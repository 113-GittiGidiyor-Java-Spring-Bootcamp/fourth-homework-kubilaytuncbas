package repository;


import model.PermanentInstructor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PermanentInstructorDao extends CrudRepository<PermanentInstructor,Integer> {

    List<PermanentInstructor> findFirst3ByFixedSalaryGreaterThan();
    List<PermanentInstructor> findFirst3ByFixedSalaryOrderByFixedSalaryDesc();

    List<PermanentInstructor> findAllByName(String name);
    List<PermanentInstructor> findAllByPhoneNumber(String phoneNumber);

}
