package com.graduation.graProject.Activities;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    private final ActivityRepository actRepo;

    public ActivityService(ActivityRepository actRepo) {
        this.actRepo = actRepo;
    }

    public List<ActivityEntity> getAllActivities(){
        return actRepo.findAll();
    }

    public ActivityEntity getById(Long id){
        return actRepo.findById(id).orElse(null);
    }

    public ActivityEntity createActivity(ActivityEntity act){
        return actRepo.save(act);
    }

    public ActivityEntity updateActivity(Long id, ActivityEntity act){
        if(actRepo.existsById(id)){
            act.setId(id);
            return actRepo.save(act);
        }
        return null;
    }

    public boolean deleteActivity(Long id){
        if(actRepo.existsById(id)){
            actRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
