package tn.esprit.gestion.Entite;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CoursClassroom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCours ;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private String nom;
    private Integer nbHeures;
    private Boolean archive;

    @JsonIgnore
    @ManyToOne
    private Classe classe;
}
