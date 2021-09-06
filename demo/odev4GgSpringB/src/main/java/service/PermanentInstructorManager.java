package service;

import dto.PermanentInstructorDTO;
import lombok.RequiredArgsConstructor;
import mappers.PermanentInstructorMapper;
import model.PermanentInstructor;
import org.springframework.stereotype.Service;
import repository.PermanentInstructorDao;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermanentInstructorManager implements PermanentInstructorService {

    private final PermanentInstructorDao permanentInstructorDao;
    private final PermanentInstructorMapper permanentInstructorMapper;



    @Override
    public List<PermanentInstructor> findAll() {
        return (List<PermanentInstructor>) permanentInstructorDao.findAll();
    }

    @Override
    public PermanentInstructor findById(int id) {
        return permanentInstructorDao.findById(id).get();
    }

    @Override
    public PermanentInstructor save(PermanentInstructorDTO permanentInstructorDTO) {
        PermanentInstructor permanentInstructor=permanentInstructorMapper.mapFromPermanentInstructorDTOtoPermanentInstructor(permanentInstructorDTO);
        return permanentInstructorDao.save(permanentInstructor);
    }

    @Override
    public void deleteById(int id) {
        permanentInstructorDao.deleteById(id);
    }

    @Override
    public void update(PermanentInstructor permanentInstructor) {
        permanentInstructorDao.save(permanentInstructor);
    }

    @Override
    public List<PermanentInstructor> findFirst3ByFixedSalaryGreaterThan() {
        return permanentInstructorDao.findFirst3ByFixedSalaryGreaterThan();
    }

    @Override
    public List<PermanentInstructor> findFirst3ByFixedSalaryOrderByFixedSalaryDesc() {
        return permanentInstructorDao.findFirst3ByFixedSalaryOrderByFixedSalaryDesc();
    }
}
