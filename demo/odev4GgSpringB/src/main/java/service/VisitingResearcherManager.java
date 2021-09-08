package service;

import dto.VisitingResearcherDTO;
import exceptions.InstructorIsAlreadyExistException;
import lombok.RequiredArgsConstructor;
import mappers.VisitingResearcherMapper;
import model.VisitingResearcher;
import org.springframework.stereotype.Service;
import repository.VisitingResearcherDao;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VisitingResearcherManager implements VisitingResearcherService{
    private final VisitingResearcherDao visitingResearcherDao;
    private final VisitingResearcherMapper visitingResearcherMapper;

    /**
     *
     * @return
     */
 @Override
    public List<VisitingResearcher> findAll() {
        return (List<VisitingResearcher>) visitingResearcherDao.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
 @Override
    public VisitingResearcher findById(int id) {
        return visitingResearcherDao.findById(id).get();
    }

    /**
     *
     * @param visitingResearcherDTO
     * @return
     */
 @Override
    public VisitingResearcher save(VisitingResearcherDTO visitingResearcherDTO) {
        if (!checkExistPhoneNumber(visitingResearcherDTO.getPhoneNumber())){
            throw new InstructorIsAlreadyExistException("Aynı cep telefonu numarasıyla birden fazla kayıt yapılamaz!");
        }
        else{
            VisitingResearcher visitingResearcher=visitingResearcherMapper.mapFromVisitingResearcherDTOtoVisitingResearcher(visitingResearcherDTO);
            return visitingResearcherDao.save(visitingResearcher);
        }


    }

    /**
     *
     * @param id
     */
 @Override
    public void deleteById(int id) {
        visitingResearcherDao.deleteById(id);
    }

    /**
     *
     * @param visitingResearcher
     */
 @Override
    public void update(VisitingResearcher visitingResearcher) {
        visitingResearcherDao.save(visitingResearcher);
    }

    /**
     *
     * @return
     */
 @Override
    public List<VisitingResearcher> findFirst3ByHourlySalaryGreaterThan() {
        return visitingResearcherDao.findFirst3ByHourlySalaryGreaterThan();
    }

    /**
     *
     * @return
     */
 @Override
    public List<VisitingResearcher> findFirst3ByHourlySalaryOrderByHourlySalaryDesc() {
        return visitingResearcherDao.findFirst3ByHourlySalaryOrderByHourlySalaryDesc();
    }

    /**
     *
     * @return
     */
 @Override
    public List<VisitingResearcher> findAllByName() {
        return visitingResearcherDao.findAllByName();
    }

    /**
     *
     * @param email
     * @return
     */
 @Override
    public List<VisitingResearcher> findAllByEmail(String email) {
        return visitingResearcherDao.findAllByEmail(email);
    }
    private boolean checkExistPhoneNumber(String phoneNumber){
        if (findAllByEmail(phoneNumber)==null){
            return true;
        }else
            return false;
    }
}
