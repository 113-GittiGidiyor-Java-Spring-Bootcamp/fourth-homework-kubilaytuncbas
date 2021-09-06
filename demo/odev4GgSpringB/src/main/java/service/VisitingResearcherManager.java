package service;

import model.VisitingResearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.VisitingResearcherDao;

import java.util.List;

@Service
public class VisitingResearcherManager implements VisitingResearcherService{
    VisitingResearcherDao visitingResearcherDao;
    @Autowired
    public VisitingResearcherManager(VisitingResearcherDao visitingResearcherDao) {
        this.visitingResearcherDao = visitingResearcherDao;
    }

    @Override
    public List<VisitingResearcher> findAll() {
        return (List<VisitingResearcher>) visitingResearcherDao.findAll();
    }

    @Override
    public VisitingResearcher findById(int id) {
        return visitingResearcherDao.findById(id).get();
    }

    @Override
    public VisitingResearcher save(VisitingResearcher visitingResearcher) {
        return visitingResearcherDao.save(visitingResearcher);

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
}
