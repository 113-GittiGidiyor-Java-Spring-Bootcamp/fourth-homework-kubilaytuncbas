package dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitingResearcherDTO {

    @ApiModelProperty(hidden = true)
    private int id;
    private String phoneNumber;
    private int hourlySalary;
}
