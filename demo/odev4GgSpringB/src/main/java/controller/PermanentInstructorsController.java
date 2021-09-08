package controller;
import dto.PermanentInstructorDTO;
import model.PermanentInstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.PermanentInstructorService;

import java.util.List;

@RestController
@RequestMapping("/api/permanents")
public class PermanentInstructorsController {

    PermanentInstructorService permanentInstructorService;

    @Autowired
    public PermanentInstructorsController(PermanentInstructorService permanentInstructorService) {
        this.permanentInstructorService = permanentInstructorService;
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<PermanentInstructor>> findAll(){
        return new ResponseEntity<>(permanentInstructorService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<PermanentInstructor> findPermanentInstructorById(@PathVariable int id){
        return  new ResponseEntity(permanentInstructorService.findById(id),HttpStatus.OK);
    }
    @PostMapping("/savePermanentInstructor")
    public PermanentInstructor savePermanentInstructor(PermanentInstructorDTO permanentInstructorDTO){
        return permanentInstructorService.save(permanentInstructorDTO);
    }
    @GetMapping("/deletePermanentInstructor")
    public  void deletePermanentInstructor(int id){
        permanentInstructorService.deleteById(id);
    }
    @GetMapping("/findFirst3ByFixedSalaryGreaterThan")
    public ResponseEntity<List<PermanentInstructor>> findFirst3ByFixedSalaryGreaterThan(){
        return new ResponseEntity<>(permanentInstructorService.findFirst3ByFixedSalaryGreaterThan(),HttpStatus.OK);
    }

    @PutMapping("/updatePermanentInstructor")
    public void updatePermanentInstructor(PermanentInstructor permanentInstructor){
        permanentInstructorService.update(permanentInstructor);
    }
}
