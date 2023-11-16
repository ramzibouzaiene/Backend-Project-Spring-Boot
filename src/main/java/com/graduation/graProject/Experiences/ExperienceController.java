package com.graduation.graProject.Experiences;

import com.graduation.graProject.Claims.ClaimEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/experiences")
public class ExperienceController {
    private final ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @GetMapping("/all")
    public List<ExperienceEntity> getAllExperiences(){
        return experienceService.getAllExperiences();
    }

    @GetMapping("/{experienceId}")
    public ExperienceEntity getById(@PathVariable Long experienceId){
        return experienceService.getById(experienceId);
    }

    @PostMapping("/create")
    public ExperienceEntity createExperience(@RequestBody ExperienceEntity experience){
        return experienceService.createExperience(experience);
    }

    @PutMapping("/update/{experienceId}")
    public ExperienceEntity updateClaim(@RequestBody ExperienceEntity experience, @PathVariable Long experienceId){
        return experienceService.updateExperience(experience, experienceId);
    }

    @DeleteMapping("/{experienceId}")
    public boolean deleteClaim(@PathVariable Long experienceId){
        return experienceService.deleteExperience(experienceId);
    }
}
