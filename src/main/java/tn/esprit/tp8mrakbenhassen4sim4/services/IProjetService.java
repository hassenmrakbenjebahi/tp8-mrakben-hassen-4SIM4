package tn.esprit.tp8mrakbenhassen4sim4.services;

import tn.esprit.tp8mrakbenhassen4sim4.entity.Projet;

import java.util.List;

public interface IProjetService {
    public List<Projet> retrieveAllProject();
    public Projet retrieveProject(Long projetId);
    public Projet addProject(Projet c);
    public void removeProject(Long projetId);
    public Projet modifyProject(Projet projet);
    public Projet addProjetAndProjetDetailAndAssign(Projet projet);
    public void assignProjetDetailToProjet(Long projetId, Long projetDetailId);
    public void assignProjetToEquipe(Long projetId, Long equipeId);
    public Projet addProjetAndAssignProjetToProjetDetail(Projet projet, Long projetDetailId);
    public Projet DesaffecterProjetDetailFromProjet(Long projetId);
    public void desaffecterProjetFromEquipe(Long projetId, Long equipeId);
}
