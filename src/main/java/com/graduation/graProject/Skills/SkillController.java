package com.graduation.graProject.Skills;

import com.graduation.graProject.Offers.OfferEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skills")
public class SkillController {
    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @GetMapping("/all")
    public List<SkillEntity> getAllSkills(){
        return skillService.getAllSkills();
    }

    @GetMapping("/{skillId}")
    public SkillEntity getById(@PathVariable Long skillId){
        return skillService.getById(skillId);
    }

    @PostMapping("/create")
    public SkillEntity createSkill(@RequestBody SkillEntity skill){
        return skillService.createSkill(skill);
    }

    @PutMapping("/update/{skillId}")
    public SkillEntity updateClaim(@RequestBody SkillEntity skill, @PathVariable Long skillId){
        return skillService.updateSkill(skill, skillId);
    }

    @DeleteMapping("/{skillId}")
    public boolean deleteClaim(@PathVariable Long skillId){
        return skillService.deleteSkill(skillId);
    }
}
