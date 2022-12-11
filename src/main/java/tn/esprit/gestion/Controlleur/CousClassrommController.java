package tn.esprit.gestion.Controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestion.Entite.CoursClassroom;
import tn.esprit.gestion.Entite.Niveau;
import tn.esprit.gestion.Entite.Specialite;
import tn.esprit.gestion.Service.CoursClassroomService;

@RestController
@RequestMapping("/coursclassroom")
public class CousClassrommController {
    @Autowired
    CoursClassroomService coursClassroomService ;

    @PostMapping("/addcoursclassroom/{codeClasse}")
    public CoursClassroom ajouterClassroom(@RequestBody CoursClassroom cc ,@PathVariable Integer codeClasse){
        return coursClassroomService.ajouterCoursClassroom(cc,codeClasse);
    }
    @PostMapping("/desaffecterCours/{idCours}")
    public void DesafecterCoursclassroom(@PathVariable Integer idCours){
        coursClassroomService.desaffecterCoursClassroomClasse(idCours) ;
    }
    @PostMapping("/archiver")
    public void Archiver(){
        coursClassroomService.archiverCoursClassrooms();
    }
    @GetMapping("/nbrHeures/{sp}/{nv}")
    public Integer nbrHeures(@PathVariable Specialite sp , @PathVariable Niveau nv){
        return coursClassroomService.nbHeuresParSpecEtNiv(sp, nv);
    }
}
