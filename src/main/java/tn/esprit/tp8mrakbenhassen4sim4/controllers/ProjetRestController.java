package tn.esprit.tp8mrakbenhassen4sim4.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tp8mrakbenhassen4sim4.entity.Projet;
import tn.esprit.tp8mrakbenhassen4sim4.services.IProjetService;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/projet")
public class ProjetRestController {

    IProjetService projetService;
    @PostMapping("/ajouter-projet-et-projet-detail")
    public Projet addProjet(@RequestBody Projet p){
        Projet  projet= projetService.addProjetAndProjetDetailAndAssign(p);
        return projet;
    }
    //http://localhost:8089/tp8/projet/affecter-projet-a-projet-details/1/1
    @PutMapping("/affecter-projet-a-projet-details/{projet-id}/{projet-details-id}")
    public void affecgterProjetAProjetDetail(@PathVariable("projet-id") Long proejtId,
                                             @PathVariable("projet-details-id") Long proejtDetailsId) {
        projetService.assignProjetDetailToProjet(proejtId, proejtDetailsId);
    }



    //http://localhost:8089/tp8/projet/affecter-projet-equipe/1/1
    @PutMapping("/affecter-projet-equipe/{projet-id}/{equipe-id}")
    public void affecgterEquipeAProjet(@PathVariable("projet-id") Long proejtId,
                                             @PathVariable("equipe-id") Long equipeId) {
        projetService.assignProjetToEquipe(proejtId,equipeId);
    }

    //http://localhost:8089/tp8/projet/creer-projet-et-affecter-projet-detail-a-projet/1
    @PostMapping("/creer-projet-et-affecter-projet-detail-a-projet/{projet-detail-id}")
    public Projet addProjetAvecDetail(@RequestBody Projet p,@PathVariable("projet-detail-id") Long projetdetailid){
        Projet  projet= projetService.addProjetAndAssignProjetToProjetDetail(p,projetdetailid);
        return projet;
    }

    //http://localhost:8089/tp8/projet/desaffecter-projet-detail/1
    @PutMapping("/desaffecter-projet-detail/{projet-id}")
    public void desaffecter_projet_detail(@PathVariable("projet-id") Long projetId) {
        projetService.DesaffecterProjetDetailFromProjet(projetId);

    }


    //http://localhost:8089/tp8/projet/desaffecter-projet-de-equipe/1/1
    @PutMapping("/desaffecter-projet-detail/{projet-id}/{equipe-id}")
    public void desaffecter_projet_de_equipe(@PathVariable("projet-id") Long projetid,@PathVariable("equipe-id") Long equipeid){
        projetService.desaffecterProjetFromEquipe(projetid,equipeid);
    }


}
