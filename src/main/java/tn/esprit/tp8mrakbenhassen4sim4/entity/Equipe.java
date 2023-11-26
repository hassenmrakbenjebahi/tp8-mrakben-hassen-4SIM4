package tn.esprit.tp8mrakbenhassen4sim4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Equipe {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nom;
    @Enumerated(EnumType.STRING)
    private Domaine domaine;
    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Projet> projets;
}
