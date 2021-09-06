package mappers;

import dto.VisitingResearcherDTO;
import model.VisitingResearcher;
import org.mapstruct.Mapper;

@Mapper
public interface VisitingResearcherMapper {

    VisitingResearcher mapFromVisitingResearcherDTOtoVisitingResearcher(VisitingResearcherDTO visitingResearcherDTO);

    VisitingResearcherDTO mapFromVisitingResearchertoVisitingResearcherDTO(VisitingResearcher visitingResearcher);
}
