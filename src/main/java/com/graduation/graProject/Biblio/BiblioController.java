package com.graduation.graProject.Biblio;

import jakarta.annotation.security.PermitAll;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblio")
public class BiblioController {
    private final BiblioService biblioService;

    public BiblioController(BiblioService biblioService) {
        this.biblioService = biblioService;
    }

    @GetMapping("/all")
    @PermitAll
    public List<BiblioEntity> getAllBib(){
        return biblioService.getAllBiblios();
    }

    @GetMapping("/{bibId}")
    @PermitAll
    public BiblioEntity getById(@PathVariable Long id){
        return biblioService.getById(id);
    }

    @PostMapping("/create")
    @PermitAll
    public BiblioEntity createBiblio(@RequestBody BiblioEntity bib){
        return biblioService.createBiblio(bib);
    }

    @PutMapping("/update/{bibId}")
    @PermitAll
    public BiblioEntity updateBiblio(@RequestBody BiblioEntity bib, @PathVariable Long bibId){
        return biblioService.updateBiblio(bib, bibId);
    }

    @DeleteMapping("/{bibId}")
    public boolean deleteBiblio(@PathVariable Long bibId){
        return biblioService.deleteBiblio(bibId);
    }
}
