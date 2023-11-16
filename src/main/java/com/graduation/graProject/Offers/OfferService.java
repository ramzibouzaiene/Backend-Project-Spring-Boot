package com.graduation.graProject.Offers;

import com.graduation.graProject.Experiences.ExperienceEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {
    private final OfferRepository offerRepository;

    public OfferService(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    public List<OfferEntity> getAllOffers(){
        return offerRepository.findAll();
    }

    public OfferEntity getById(Long id){
        return offerRepository.findById(id).get();
    }

    public OfferEntity createNewOffer(OfferEntity offer){
        return offerRepository.save(offer);
    }

    public OfferEntity updateOffer(OfferEntity offer, Long id){
        if(offerRepository.existsById(id)){
            offer.setId(id);
            offerRepository.save(offer);
        }
        return null;
    }

    public boolean deleteOffer(Long id){
        if (offerRepository.existsById(id)){
            offerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
