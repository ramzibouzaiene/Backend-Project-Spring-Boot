package com.graduation.graProject.Trainings;

import jakarta.annotation.security.PermitAll;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainings")
public class TrainingController {
    private final TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @GetMapping("/all")
    @PermitAll
    public List<TrainingEntity> getAllTrainings(){
        return trainingService.getAllTrainings();
    }

    @GetMapping("/{trainingId}")
    public TrainingEntity getById(@PathVariable Long trainingId){
        return trainingService.getById(trainingId);
    }

    @PostMapping("/create")
    public TrainingEntity createTraining(@RequestBody TrainingEntity training){
        return trainingService.createTraining(training);
    }

    @PutMapping("/update/{trainingId}")
    public TrainingEntity updateTraining(@RequestBody TrainingEntity training, @PathVariable Long trainingId){
        return trainingService.updateTraining(training, trainingId);
    }

    @DeleteMapping("/{trainingId}")
    public boolean deleteTraining(@PathVariable Long trainingId){
        return trainingService.deleteTraining(trainingId);
    }
}
