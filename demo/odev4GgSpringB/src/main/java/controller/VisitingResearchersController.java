package controller;

import dto.VisitingResearcherDTO;
import model.VisitingResearcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.VisitingResearcherService;

import java.util.List;

@RestController
@RequestMapping("/api/visiting")
public class VisitingResearchersController {

    VisitingResearcherService visitingResearcherService;

    @Autowired
    public VisitingResearchersController(VisitingResearcherService visitingResearcherService) {
        this.visitingResearcherService = visitingResearcherService;
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<VisitingResearcher>> findAll(){
        return new ResponseEntity<>(visitingResearcherService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/findById/{id}")
    public ResponseEntity<VisitingResearcher> findVisitingResearcherById(@PathVariable int id){

        return new ResponseEntity<>(visitingResearcherService.findById(id),HttpStatus.OK);
    }
    @PostMapping("/saveVisitingResearcher")
    public VisitingResearcher saveVisitingResearcher(VisitingResearcherDTO visitingResearcherDTO){
        return visitingResearcherService.save(visitingResearcherDTO);
    }
    @PostMapping("/deleteVisitingResearcher")
    public  void deleteVisitingResearcher(int id){
        visitingResearcherService.deleteById(id);
    }
    @PutMapping("/updateVisitingResearcher")
    public void updateVisitingResearcher(VisitingResearcher visitingResearcher){
        visitingResearcherService.update(visitingResearcher);
    }


}
