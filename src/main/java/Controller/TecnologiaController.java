package Controller;

import Entity.Tecnologia;
import Service.ITecnologiaService;
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
public class TecnologiaController {
    
     @Autowired
    private ITecnologiaService intertecnologia;

    @GetMapping ("/tecnologia/traer")
    public List<Tecnologia> getTecnologia(){
        return  intertecnologia.getTecnologia();
    }

    @PostMapping ("/tecnologia/crear")
    public String createTecnologia(@RequestBody Tecnologia perso){

        intertecnologia.saveTecnologia(perso);
        return  "La Tecnologia fue creada";
    }

    @DeleteMapping ("/tecnologia/borrar/{id}")
    public String deleteTecnologia (@PathVariable long id){
        intertecnologia.deleteTecnologia(id);
        return "La persona fue eliminada";
    }


    @PutMapping("tecnologia/editar/{id}")
    public Tecnologia editTecnologia (@PathVariable Long id,
                                @RequestParam ("nombre") String nuevoNombre,
                                @RequestParam ("nivel") String nuevoNIvel
                                ){
        Tecnologia tec = intertecnologia.findTecnologia(id);

        tec.setNombre(nuevoNombre);
        tec.setNivel(nuevoNIvel);

        intertecnologia.saveTecnologia(tec);

        return tec;
    }
}
