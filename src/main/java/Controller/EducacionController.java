package Controller;

import Entity.Educacion;
import Service.IEducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EducacionController {
    
    @Autowired
    private IEducacionService interEducacion;

    @GetMapping ("/educacion/traer")
    public List<Educacion> getPersonas(){
        return  interEducacion.getEducacion();
    }

    @PostMapping ("/educacion/crear")
    public String createStudent(@RequestBody Educacion perso){

        interEducacion.saveEducacion(perso);
        return  "La Educacion fue creada";
    }

    @DeleteMapping ("/educacion/borrar/{id}")
    public String deletePersona (@PathVariable long id){
        interEducacion.deleteEducacion(id);
        return "La Educacion fue eliminada";
    }


    @PutMapping("educacion/editar/{id}")
    public Educacion editEducacion (@PathVariable Long id,
                                @RequestParam ("tipo") String nuevoTipo,
                                @RequestParam ("institucion") String nuevaInstitucion,
                                @RequestParam ("titulo") String nuevoTitulo,
                                @RequestParam ("carrera") String nuevaCarrera,
                                @RequestParam ("inicio") String nuevoInicio,
                                @RequestParam ("fin") String nuevoFin,
                                @RequestParam ("enCurso") boolean nuevoEncurso ){
        Educacion edu = interEducacion.findEducacion(id);

        edu.setTipo(nuevoTipo);
        edu.setInstitucion(nuevaInstitucion);
        edu.setTitulo(nuevoTitulo);
        edu.setCarrera(nuevaCarrera);
        edu.setInicio(nuevoInicio);
        edu.setFin(nuevoFin);
        edu.setEnCurso(nuevoEncurso);

        interEducacion.saveEducacion(edu);

        return edu;
    }
}
