package tn.esprit.gestion.Entite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Classe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codeClasse;
    private String titre;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;

    @OneToMany(mappedBy = "classe")
    private List<CoursClassroom> coursClassrooms;
}
