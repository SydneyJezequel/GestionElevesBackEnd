package com.example.gestioneleves.repository;

import com.example.gestioneleves.model.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EleveRepository extends JpaRepository<Eleve, Long> {

    void deleteEleveById(Long id);

    Optional<Eleve> findEleveById(Long id);

    Eleve findEleveByNom(String nom);

}
