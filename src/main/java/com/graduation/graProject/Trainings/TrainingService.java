package com.graduation.graProject.Trainings;

import com.graduation.graProject.Skills.SkillEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingService {
    private final TrainingRepository trainingRepository;

    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public List<TrainingEntity> getAllTrainings(){
        return trainingRepository.findAll();
    }

    public TrainingEntity getById(Long id){
        return trainingRepository.findById(id).get();
    }

    public TrainingEntity createTraining(TrainingEntity training){
        return trainingRepository.save(training);
    }

    public TrainingEntity updateTraining(TrainingEntity training, Long id){
        if(trainingRepository.existsById(id)){
            training.setId(id);
            trainingRepository.save(training);
        }
        return null;
    }

    public boolean deleteTraining(Long id){
        if (trainingRepository.existsById(id)){
            trainingRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
