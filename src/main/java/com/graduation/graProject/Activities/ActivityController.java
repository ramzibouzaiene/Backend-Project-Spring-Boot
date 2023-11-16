package com.graduation.graProject.Activities;

import jakarta.annotation.security.PermitAll;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activities")
public class ActivityController {
    private final ActivityService actService;

    public ActivityController(ActivityService actService) {
        this.actService = actService;
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.FOUND)
    @PermitAll
    public List<ActivityEntity> getAllActivities(){
        return actService.getAllActivities();
    }

    @GetMapping("/{activityID}")
    @PermitAll
    @ResponseStatus(HttpStatus.FOUND)
    public ActivityEntity getByid(@PathVariable Long activityID){
        return actService.getById(activityID);
    }

    @PostMapping("/create")
    @PermitAll
    @ResponseStatus(HttpStatus.CREATED)
    public ActivityEntity createNewActivity(@RequestBody ActivityEntity act){
        return actService.createActivity(act);
    }

    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ActivityEntity updateExistingActivity(@PathVariable Long id, ActivityEntity act){
        return actService.updateActivity(id, act);
    }

    @DeleteMapping("/detele/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean deteleActivity(@PathVariable Long id){
        return actService.deleteActivity(id);
    }
}
