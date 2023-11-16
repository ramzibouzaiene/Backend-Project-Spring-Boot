package com.graduation.graProject.Skills;

import com.graduation.graProject.Offers.OfferEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {
    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public List<SkillEntity> getAllSkills(){
        return skillRepository.findAll();
    }

    public SkillEntity getById(Long id){
        return skillRepository.findById(id).get();
    }

    public SkillEntity createSkill(SkillEntity skill){
        return skillRepository.save(skill);
    }

    public SkillEntity updateSkill(SkillEntity skill, Long id){
        if(skillRepository.existsById(id)){
            skill.setId(id);
            skillRepository.save(skill);
        }
        return null;
    }

    public boolean deleteSkill(Long id){
        if (skillRepository.existsById(id)){
            skillRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
