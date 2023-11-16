package com.graduation.graProject.Experiences;

import com.graduation.graProject.Claims.ClaimEntity;
import com.graduation.graProject.Claims.ClaimRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {
    private final ExperienceRepository experienceRepository;

    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public List<ExperienceEntity> getAllExperiences(){
        return experienceRepository.findAll();
    }

    public ExperienceEntity getById(Long id){
        return experienceRepository.findById(id).get();
    }

    public ExperienceEntity createExperience(ExperienceEntity experience){
        return experienceRepository.save(experience);
    }

    public ExperienceEntity updateExperience(ExperienceEntity experience, Long id){
        if(experienceRepository.existsById(id)){
            experience.setId(id);
            experienceRepository.save(experience);
        }
        return null;
    }

    public boolean deleteExperience(Long id){
        if (experienceRepository.existsById(id)){
            experienceRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
