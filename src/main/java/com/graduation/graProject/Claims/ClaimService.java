package com.graduation.graProject.Claims;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimService {
    private final ClaimRepository claimRepository;

    public ClaimService(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    public List<ClaimEntity> getAllClaims(){
        return claimRepository.findAll();
    }

    public ClaimEntity getById(Long id){
        return claimRepository.findById(id).get();
    }

    public ClaimEntity createNewClaim(ClaimEntity claim){
        return claimRepository.save(claim);
    }

    public ClaimEntity updateClaim(ClaimEntity claim, Long id){
        if(claimRepository.existsById(id)){
            claim.setId(id);
            claimRepository.save(claim);
        }
        return null;
    }

    public boolean deleteClaim(Long id){
        if (claimRepository.existsById(id)){
            claimRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
