package repository;

import model.VisitingResearcher;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface VisitingResearcherDao extends CrudRepository<VisitingResearcher,Integer> {
    List<VisitingResearcher> findFirst3ByHourlySalaryGreaterThan();
    List<VisitingResearcher> findFirst3ByHourlySalaryOrderByHourlySalaryDesc();

    List<VisitingResearcher> findAllByName();
    List<VisitingResearcher> findAllByEmail(String email);
}
