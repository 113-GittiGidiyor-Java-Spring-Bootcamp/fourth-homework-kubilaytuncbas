package dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PermanentInstructorDTO {

    @ApiModelProperty(hidden = true)
    private int id;
    private String phoneNumber;
    private int fixedSalary;
}
