package dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    @ApiModelProperty(hidden = true)
    private int id;
    private String courseName;
    private String courseCode;
    private int creditScore;
    @ApiModelProperty(hidden = true)
    private Instant createdDate = Instant.now();
    @ApiModelProperty(hidden = true)
    private Instant lastModifiedDate = Instant.now();
}
