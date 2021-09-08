package service;

import dto.PermanentInstructorDTO;
import exceptions.InstructorIsAlreadyExistException;
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


    /**
     *
     * @return
     */
 @Override
    public List<PermanentInstructor> findAll() {
        return (List<PermanentInstructor>) permanentInstructorDao.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
 @Override
    public PermanentInstructor findById(int id) {
        return permanentInstructorDao.findById(id).get();
    }

    /**
     *
     * @param permanentInstructorDTO
     * @return
     */
 @Override
    public PermanentInstructor save(PermanentInstructorDTO permanentInstructorDTO) {
        if (!checkExistPhoneNumber(permanentInstructorDTO.getPhoneNumber())){
             throw new InstructorIsAlreadyExistException("Aynı cep telefonu numarasıyla birden fazla kayıt yapılamaz!");
        }else{
            PermanentInstructor permanentInstructor=permanentInstructorMapper.mapFromPermanentInstructorDTOtoPermanentInstructor(permanentInstructorDTO);
            return permanentInstructorDao.save(permanentInstructor);
        }

    }

    /**
     *
     * @param id
     */
 @Override
    public void deleteById(int id) {
        permanentInstructorDao.deleteById(id);
    }

    /**
     *
     * @param permanentInstructor
     */
 @Override
    public void update(PermanentInstructor permanentInstructor) {
        permanentInstructorDao.save(permanentInstructor);
    }

    /**
     *
     * @return
     */
 @Override
    public List<PermanentInstructor> findFirst3ByFixedSalaryGreaterThan() {
        return permanentInstructorDao.findFirst3ByFixedSalaryGreaterThan();
    }

    /**
     *
     * @return
     */
 @Override
    public List<PermanentInstructor> findFirst3ByFixedSalaryOrderByFixedSalaryDesc() {
        return permanentInstructorDao.findFirst3ByFixedSalaryOrderByFixedSalaryDesc();
    }

    /**
     *
     * @param name
     * @return
     */
 @Override
    public List<PermanentInstructor> findAllByName(String name) {
        return permanentInstructorDao.findAllByName(name);
    }

    /**
     *
     * @param phoneNumber
     * @return
     */
 @Override
    public List<PermanentInstructor> findAllByPhoneNumber(String phoneNumber) {
        return permanentInstructorDao.findAllByPhoneNumber(phoneNumber);
    }
    private boolean checkExistPhoneNumber(String phoneNumber){
        if (findAllByPhoneNumber(phoneNumber)==null){
            return true;
        }else
        return false;
    }
}
