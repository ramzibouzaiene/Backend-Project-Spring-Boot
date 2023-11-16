package com.graduation.graProject.Offers;

import com.graduation.graProject.Experiences.ExperienceEntity;
import jakarta.annotation.security.PermitAll;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {
    private final OfferService offerService;

    public OfferController(OfferService offerService) {
        this.offerService = offerService;
    }
    @GetMapping("/all")
    @PermitAll
    public List<OfferEntity> getAllOffers(){
        return offerService.getAllOffers();
    }

    @GetMapping("/{offerId}")
    public OfferEntity getById(@PathVariable Long offerId){
        return offerService.getById(offerId);
    }

    @PostMapping("/create")
    public OfferEntity createOffer(@RequestBody OfferEntity offer){
        return offerService.createNewOffer(offer);
    }

    @PutMapping("/update/{offerId}")
    public OfferEntity updateClaim(@RequestBody OfferEntity offer, @PathVariable Long offerId){
        return offerService.updateOffer(offer, offerId);
    }

    @DeleteMapping("/{offerId}")
    public boolean deleteClaim(@PathVariable Long offerId){
        return offerService.deleteOffer(offerId);
    }
}
