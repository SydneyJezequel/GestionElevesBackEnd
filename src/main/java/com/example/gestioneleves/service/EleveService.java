package com.example.gestioneleves.service;

import com.example.gestioneleves.exception.HandlerException;
import com.example.gestioneleves.model.Eleve;
import com.example.gestioneleves.repository.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;


@Service
public class EleveService {


    /**
     * Attributs :
     */
    private final EleveRepository eleveRepository;


    /**
     * Constructeur :
     */
    @Autowired
    public EleveService(EleveRepository eleveRepository) {
        this.eleveRepository= eleveRepository;
    }


    /**
     * Méthodes :
     */
    public List<Eleve> findAllEleves() {
        return eleveRepository.findAll();
    }

    public Eleve findEleveById(Long id)
    {
        return eleveRepository.findEleveById(id)
                .orElseThrow(()-> new HandlerException("Eleve by id"+ id +"was not found."));
    }

    public Eleve addEleve(Eleve eleve)
    {
        return eleveRepository.save(eleve);
    }

    public Eleve updateEleve(Eleve eleve)
    {
        System.out.println(eleve.getNom());
        System.out.println(eleve.getPrenom());
        System.out.println(eleve.getEmail());
        return eleveRepository.save(eleve);
    }

    @Transactional
    public void deleteEleve(Long id)
    {
        eleveRepository.deleteEleveById(id);
    }


}
