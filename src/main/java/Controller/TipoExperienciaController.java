package Controller;

import Entity.TipoExperiencia;
import Service.ITipoExperienciaService;
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
public class TipoExperienciaController {
    
    @Autowired
    private ITipoExperienciaService interTipoExperiencia;

    @GetMapping ("/tipoExperiencia/traer")
    public List<TipoExperiencia> getTipoExperiencia(){
        return  interTipoExperiencia.getTipoExperiencia();
    }

    @PostMapping ("/tipoExperiencia/crear")
    public String createTipoExperiencia(@RequestBody TipoExperiencia perso){

        interTipoExperiencia.saveTipoExperiencia(perso);
        return  "El tipo de Experiencia fue creada";
    }

    @DeleteMapping ("/tipoExperiencia/borrar/{id}")
    public String deleteTipoExperiencia (@PathVariable long id){
        interTipoExperiencia.deleteTipoExperiencia(id);
        return "El tipo de Experiencia fue eliminada";
    }


    @PutMapping("tipoExperiencia/editar/{id}")
    public TipoExperiencia editTipoExperiencia (@PathVariable Long id,
                                @RequestParam ("nombre") String nuevoNombre){
        TipoExperiencia tipo = interTipoExperiencia.findTipoExperiencia(id);

        tipo.setNombre(nuevoNombre);
        
        interTipoExperiencia.saveTipoExperiencia(tipo);

        return tipo;
    }
}
