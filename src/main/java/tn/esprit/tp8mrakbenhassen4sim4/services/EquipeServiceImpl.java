package tn.esprit.tp8mrakbenhassen4sim4.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tp8mrakbenhassen4sim4.entity.Equipe;
import tn.esprit.tp8mrakbenhassen4sim4.repository.EquipeRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class EquipeServiceImpl implements IEquipeService {
    EquipeRepository equipeRepository;
    @Override
    public List<Equipe> retrieveAllEquipe() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe retrieveEquipe(Long equipeId) {
        return equipeRepository.findById(equipeId).get();
    }

    @Override
    public Equipe addEquipe(Equipe p) {
        return equipeRepository.save(p);
    }

    @Override
    public void removeEquipe(Long equipeId) {
       equipeRepository.deleteById(equipeId);
    }

    @Override
    public Equipe modifyEquipe(Equipe equipe) {
        return equipeRepository.save(equipe);
    }
}
