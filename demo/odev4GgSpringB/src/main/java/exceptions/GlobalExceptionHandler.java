package exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({StudentAgeNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<EducationAppErrorResponse> handleException(StudentAgeNotValidException exc){
        EducationAppErrorResponse response=prepareErrorResponse(HttpStatus.BAD_REQUEST,exc.getMessage());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
    private EducationAppErrorResponse prepareErrorResponse(HttpStatus httpStatus,String message){
        EducationAppErrorResponse response=new EducationAppErrorResponse();
        response.setStatus(httpStatus.value());
        response.setMessage(message);
        response.setTimeStamp(System.currentTimeMillis());
        return  response;
    }
    @ExceptionHandler({InstructorIsAlreadyExistException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<EducationAppErrorResponse> handleException(InstructorIsAlreadyExistException exc){
        EducationAppErrorResponse response=prepareErrorResponse(HttpStatus.BAD_REQUEST,exc.getMessage());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({CourseIsAlreadyExistException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<EducationAppErrorResponse> handleException(CourseIsAlreadyExistException exc){
        EducationAppErrorResponse response=prepareErrorResponse(HttpStatus.BAD_REQUEST, exc.getMessage());
        return  new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({StudentNumberForOneCourseExceededException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<EducationAppErrorResponse> handleException(StudentNumberForOneCourseExceededException exc){
        EducationAppErrorResponse response=prepareErrorResponse(HttpStatus.BAD_REQUEST,exc.getMessage());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
