package Controller;

import Entity.TipoEducacion;
import Service.ITipoEducacionService;
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
public class TipoEducacionController {
    
    @Autowired
    private ITipoEducacionService interTipoEducacion;

    @GetMapping ("/tipoEducacion/traer")
    public List<TipoEducacion> getTipoEducacion(){
        return  interTipoEducacion.getTipoEducacion();
    }

    @PostMapping ("/tipoEducacion/crear")
    public String createTipoEducacion(@RequestBody TipoEducacion perso){

        interTipoEducacion.saveTipoEducacion(perso);
        return  "El Tipo de Educacion fue creada";
    }

    @DeleteMapping ("/tipoEducacion/borrar/{id}")
    public String deleteTipoEducacion (@PathVariable long id){
        interTipoEducacion.deleteTipoEducacion(id);
        return "El Tipo de Educacion fue eliminada";
    }


    @PutMapping("tipoEducacion/editar/{id}")
    public TipoEducacion editTipoEducacion (@PathVariable Long id,
                                @RequestParam ("nombre") String nuevoNombre)                                {
        TipoEducacion tipo = interTipoEducacion.findTipoEducacion(id);

        tipo.setNombre(nuevoNombre);

        interTipoEducacion.saveTipoEducacion(tipo);

        return tipo;
    }
}
