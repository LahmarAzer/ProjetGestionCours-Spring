package tn.esprit.gestion.Service;

import org.springframework.stereotype.Service;
import tn.esprit.gestion.Entite.Classe;
import tn.esprit.gestion.Entite.CoursClassroom;
import tn.esprit.gestion.Entite.Niveau;
import tn.esprit.gestion.Entite.Specialite;

public interface CoursClassroomService {
    public CoursClassroom ajouterCoursClassroom (CoursClassroom cc, Integer codeClasse);
    public void desaffecterCoursClassroomClasse(Integer idCours);
    public void archiverCoursClassrooms();
    public Integer nbHeuresParSpecEtNiv(Specialite sp, Niveau nv);
}
