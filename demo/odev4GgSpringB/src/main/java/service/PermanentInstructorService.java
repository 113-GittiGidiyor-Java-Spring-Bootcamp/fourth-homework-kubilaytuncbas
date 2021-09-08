package service;

import dto.PermanentInstructorDTO;
import model.PermanentInstructor;
import model.VisitingResearcher;

import java.util.List;

public interface PermanentInstructorService {

    List<PermanentInstructor> findAll();
    PermanentInstructor findById(int id);
    PermanentInstructor save(PermanentInstructorDTO permanentInstructorDTO);
    void deleteById(int id);
    void update(PermanentInstructor permanentInstructor);
    List<PermanentInstructor> findFirst3ByFixedSalaryGreaterThan();
    List<PermanentInstructor> findFirst3ByFixedSalaryOrderByFixedSalaryDesc();
    List<PermanentInstructor> findAllByName(String name);
    List<PermanentInstructor> findAllByPhoneNumber(String email);

}
