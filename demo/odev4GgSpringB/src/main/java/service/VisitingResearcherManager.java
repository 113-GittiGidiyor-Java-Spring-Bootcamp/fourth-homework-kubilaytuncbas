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


    @Override
    public List<VisitingResearcher> findAll() {
        return (List<VisitingResearcher>) visitingResearcherDao.findAll();
    }

    @Override
    public VisitingResearcher findById(int id) {
        return visitingResearcherDao.findById(id).get();
    }

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

    @Override
    public void deleteById(int id) {
        visitingResearcherDao.deleteById(id);
    }

    @Override
    public void update(VisitingResearcher visitingResearcher) {
        visitingResearcherDao.save(visitingResearcher);
    }

    @Override
    public List<VisitingResearcher> findFirst3ByHourlySalaryGreaterThan() {
        return visitingResearcherDao.findFirst3ByHourlySalaryGreaterThan();
    }

    @Override
    public List<VisitingResearcher> findFirst3ByHourlySalaryOrderByHourlySalaryDesc() {
        return visitingResearcherDao.findFirst3ByHourlySalaryOrderByHourlySalaryDesc();
    }

    @Override
    public List<VisitingResearcher> findAllByName(String name) {
        return visitingResearcherDao.findAllByName(name);
    }

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
