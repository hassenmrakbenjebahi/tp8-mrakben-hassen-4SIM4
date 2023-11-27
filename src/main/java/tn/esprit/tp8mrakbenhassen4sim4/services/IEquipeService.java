package tn.esprit.tp8mrakbenhassen4sim4.services;

import tn.esprit.tp8mrakbenhassen4sim4.entity.Equipe;
import tn.esprit.tp8mrakbenhassen4sim4.entity.Projet;

import java.util.List;

public interface IEquipeService {
    public List<Equipe> retrieveAllEquipe();
    public Equipe retrieveEquipe(Long equipeId);
    public Equipe addEquipe(Equipe p);
    public void removeEquipe(Long equipeId);
    public Equipe modifyEquipe(Equipe equipe);
}
