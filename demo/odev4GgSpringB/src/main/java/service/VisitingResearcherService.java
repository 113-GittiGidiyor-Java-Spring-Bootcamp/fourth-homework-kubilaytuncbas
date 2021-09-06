package service;
import model.VisitingResearcher;

import java.util.List;

public interface VisitingResearcherService {

    List<VisitingResearcher> findAll();
    VisitingResearcher findById(int id);
    VisitingResearcher save(VisitingResearcher visitingResearcher);
    void deleteById(int id);
    void update(VisitingResearcher visitingResearcher);
    List<VisitingResearcher> findFirst3ByHourlySalaryGreaterThan();
    List<VisitingResearcher> findFirst3ByHourlySalaryOrderByHourlySalaryDesc();
    List<VisitingResearcher> findAllByName(String name);
}
