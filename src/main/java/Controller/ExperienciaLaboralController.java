package Controller;

import Entity.ExperienciaLaboral;
import Service.IExperienciaLaboralService;
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
public class ExperienciaLaboralController {
    
        @Autowired
    private IExperienciaLaboralService interExperienciaLaboral;

    @GetMapping ("/experienciaLaboral/traer")
    public List<ExperienciaLaboral> getPersonas(){
        return  interExperienciaLaboral.getExperienciaLaboral();
    }

    @PostMapping ("/experienciaLaboral/crear")
    public String createStudent(@RequestBody ExperienciaLaboral perso){

        interExperienciaLaboral.saveExperienciaLaboral(perso);
        return  "La ExperienciaLaboral fue creada";
    }

    @DeleteMapping ("/experienciaLaboral/borrar/{id}")
    public String deleteExperienciaLaboral (@PathVariable long id){
        interExperienciaLaboral.deleteExperienciaLaboral(id);
        return "La ExperienciaLaboral fue eliminada";
    }


    @PutMapping("experienciaLaboral/editar/{id}")
    public ExperienciaLaboral editExperienciaLaboral (@PathVariable Long id,
                                @RequestParam ("nombreEmpresa") String nuevoNombre,
                                @RequestParam ("actual") boolean nuevoActual,
                                @RequestParam ("inicio") String nuevoInicio,
                                @RequestParam ("fin") String nuevoFin,
                                @RequestParam ("descripcion") String nuevaDescripcion
    ){
        ExperienciaLaboral expe = interExperienciaLaboral.findExperienciaLaboral(id);

        expe.setNombreEmpresa(nuevoNombre);
        expe.setActual(nuevoActual);
        expe.setInicio(nuevoInicio);
        expe.setFin(nuevoFin);
        expe.setDescripcion(nuevaDescripcion);

        interExperienciaLaboral.saveExperienciaLaboral(expe);

        return expe;
    }
}
