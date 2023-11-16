package com.graduation.graProject.Claims;

import com.graduation.graProject.Biblio.BiblioEntity;
import jakarta.annotation.security.PermitAll;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/claims")
public class ClaimController {
    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @GetMapping("/all")
    public List<ClaimEntity> getAllBib(){
        return claimService.getAllClaims();
    }

    @GetMapping("/{claimId}")
    @PermitAll
    public ClaimEntity getById(@PathVariable Long claimId){
        return claimService.getById(claimId);
    }

    @PostMapping("/create")
    @PermitAll
    public ClaimEntity createClaim(@RequestBody ClaimEntity claim){
        return claimService.createNewClaim(claim);
    }

    @PutMapping("/update/{claimId}")
    @PermitAll
    public ClaimEntity updateClaim(@RequestBody ClaimEntity claim, @PathVariable Long claimId){
        return claimService.updateClaim(claim, claimId);
    }

    @DeleteMapping("/{claimId}")
    public boolean deleteClaim(@PathVariable Long claimId){
        return claimService.deleteClaim(claimId);
    }
}
