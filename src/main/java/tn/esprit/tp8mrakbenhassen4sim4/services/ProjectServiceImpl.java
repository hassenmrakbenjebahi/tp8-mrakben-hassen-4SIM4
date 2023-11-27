package tn.esprit.tp8mrakbenhassen4sim4.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp8mrakbenhassen4sim4.entity.Equipe;
import tn.esprit.tp8mrakbenhassen4sim4.entity.Projet;
import tn.esprit.tp8mrakbenhassen4sim4.entity.ProjetDetail;
import tn.esprit.tp8mrakbenhassen4sim4.repository.EquipeRepository;
import tn.esprit.tp8mrakbenhassen4sim4.repository.ProjetDetailRepository;
import tn.esprit.tp8mrakbenhassen4sim4.repository.ProjetRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class ProjectServiceImpl implements IProjetService{
     ProjetRepository projetRepository;
     ProjetDetailRepository projetDetailRepository;
     EquipeRepository equipeRepository;
    @Override
    public List<Projet> retrieveAllProject() {
        return projetRepository.findAll();
    }

    @Override
    public Projet retrieveProject(Long projetId) {
        return projetRepository.findById(projetId).get();
    }

    @Override
    public Projet addProject(Projet c) {
        return projetRepository.save(c);
    }

    @Override
    public void removeProject(Long projetId) {
       projetRepository.deleteById(projetId);
    }

    @Override
    public Projet modifyProject(Projet projet) {
        return projetRepository.save(projet);
    }

    @Override
    public Projet addProjetAndProjetDetailAndAssign(Projet projet) {
            return projetRepository.save(projet);
    }

    @Override
    public void assignProjetDetailToProjet(Long projetId, Long projetDetailId) {
        Projet projet = projetRepository.findById(projetId).get();
        ProjetDetail projetDetail = projetDetailRepository.findById(projetDetailId).get();
        // on set le fils dans le parent :
        projet.setProjet_detail(projetDetail);
        projetRepository.save(projet);
    }

    @Override
    public void assignProjetToEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepository.findById(projetId).get();
        Equipe equipe = equipeRepository.findById(equipeId).get();
        // on set le fils dans le parent :
        equipe.getProjets().add(projet);
        equipeRepository.save(equipe);
    }

    @Override
    public Projet addProjetAndAssignProjetToProjetDetail(Projet projet, Long projetDetailId) {
        ProjetDetail projetDetail = projetDetailRepository.findById(projetDetailId).get();
        // on set le fils dans le parent :
        projet.setProjet_detail(projetDetail);
        return projetRepository.save(projet);
    }

    @Override
    public Projet DesaffecterProjetDetailFromProjet(Long projetId) {
        Projet projet = projetRepository.findById(projetId).get();
        projet.setProjet_detail(null);
        return projetRepository.save(projet);
    }

    @Override
    public void desaffecterProjetFromEquipe(Long projetId, Long equipeId) {
        Projet projet = projetRepository.findById(projetId).get();
        Equipe equipe = equipeRepository.findById(equipeId).get();
        // on enlève le fils du parent :
        equipe.getProjets().remove(projet);
        equipeRepository.save(equipe);
    }
}
