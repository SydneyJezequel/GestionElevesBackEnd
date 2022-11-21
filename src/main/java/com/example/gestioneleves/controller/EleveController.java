package com.example.gestioneleves.controller;

import com.example.gestioneleves.model.Eleve;
import com.example.gestioneleves.service.EleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EleveController {


    /**
     * Attributs :
     */
    private final EleveService eleveService;


    /**
     * Constructeur :
     */
    @Autowired
    public EleveController(EleveService eleveService) {
        this.eleveService = eleveService;
    }


    /**
     * Méthodes :
     */
    @GetMapping("/eleve/all")
    public ResponseEntity<List<Eleve>> getAllClasses()
    {
        List<Eleve> eleves = eleveService.findAllEleves();
        return new ResponseEntity<>(eleves, HttpStatus.OK);
    }

    @GetMapping("/eleve/{id}")
    public ResponseEntity<Eleve> getEleveById(@PathVariable("id") Long id)
    {
        Eleve eleve = eleveService.findEleveById(id);
        return new ResponseEntity<>(eleve, HttpStatus.OK);
    }

    @PostMapping("/eleve/add")
    public ResponseEntity<Eleve> addClasse(@RequestBody Eleve eleve)
    {
        Eleve eleveAdded = eleveService.addEleve(eleve);
        return new ResponseEntity<>(eleveAdded, HttpStatus.CREATED);
    }

    @PutMapping("/eleve/update")
    public ResponseEntity<Eleve> updateEleve(@RequestBody Eleve eleve)
    {
        Eleve updateEleve = eleveService.updateEleve(eleve);
        System.out.println(eleve.getNom());
        System.out.println(eleve.getPrenom());
        System.out.println(eleve.getEmail());
        return new ResponseEntity<>(updateEleve, HttpStatus.OK);
    }

    @DeleteMapping("/eleve/delete/{id}")
    public ResponseEntity<?> deleteEleve(@PathVariable("id") Long id)
    {
        eleveService.deleteEleve(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
