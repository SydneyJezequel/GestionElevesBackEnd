package ecole.gestionClasses.service;
import ecole.gestionClasses.exception.HandlerException;
import ecole.gestionClasses.model.Classe;
import ecole.gestionClasses.repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class ClasseService {


    /**
     * Attributs :
     */
    private final ClasseRepository classeRepository;


    /**
     * Constructeur :
     */
    @Autowired
    public ClasseService(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }


    /**
     * Méthodes :
     */
    public List<Classe> findAllClasses() {
        return classeRepository.findAll();
    }

    public Classe findClasseById(Long id)
    {
        return classeRepository.findClasseById(id)
                .orElseThrow(()-> new HandlerException("Classe by id"+ id +"was not found."));
    }

    public Classe addClasse(Classe classe)
    {
        return classeRepository.save(classe);
    }

    public Classe updateClasse(Classe classe)
    {
        System.out.println("Service - classe à modifier:");
        System.out.println(classe.getNom());
        System.out.println(classe.getId());
        return classeRepository.save(classe);
    }

    @Transactional
    public void deleteClasse(Long id)
    {
        classeRepository.deleteClasseById(id);
    }


}
