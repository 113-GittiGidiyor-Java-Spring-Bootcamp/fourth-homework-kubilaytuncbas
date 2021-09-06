package mappers;

import dto.PermanentInstructorDTO;
import model.PermanentInstructor;
import org.mapstruct.Mapper;

@Mapper
public interface PermanentInstructorMapper {

    PermanentInstructor mapFromPermanentInstructorDTOtoPermanentInstructor(PermanentInstructorDTO permanentInstructorDTO);
    PermanentInstructorDTO mapFromPermanentInstructortoPermanentInstructorDTO(PermanentInstructor permanentInstructor);
}
