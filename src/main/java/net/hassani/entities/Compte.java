package net.hassani.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "COMPTES")
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString @Builder
@NamedQueries({
        @NamedQuery(name = "getCompteWithMaxSolde", query = "SELECT c FROM Compte c WHERE c.solde = (SELECT MAX(c1.solde) FROM Compte c1)"),
})
public class Compte {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double solde;
    @Temporal(TemporalType.TIMESTAMP)
    private String dateCreation;
    @Enumerated(EnumType.STRING)
    @Column(length = 15)
    private TypeCompte type;
}
