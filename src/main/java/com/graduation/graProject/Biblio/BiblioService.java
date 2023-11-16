package com.graduation.graProject.Biblio;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BiblioService {
    private final BiblioRepository biblioRepository;

    public BiblioService(BiblioRepository biblioRepository) {
        this.biblioRepository = biblioRepository;
    }

    public List<BiblioEntity> getAllBiblios(){
        return biblioRepository.findAll();
    }

    public BiblioEntity getById(Long id){
        return biblioRepository.findById(id).get();
    }
    public BiblioEntity createBiblio(BiblioEntity bib){
        return biblioRepository.save(bib);
    }

    public BiblioEntity updateBiblio(BiblioEntity bib, Long id){
        if(biblioRepository.existsById(id)){
            bib.setId(id);
            biblioRepository.save(bib);
        }
        return null;
    }

    public boolean deleteBiblio(Long id){
        if (biblioRepository.existsById(id)){
            biblioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
