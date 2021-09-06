package exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationAppErrorResponse {

    private int status;
    private String message;
    private long timeStamp;
}
