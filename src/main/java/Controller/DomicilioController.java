package Controller;

import Entity.Domicilio;
import Service.IDomicilioService;
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
public class DomicilioController {
    
    @Autowired
    private IDomicilioService interDomicilio;
    
     @GetMapping ("/domicilio/traer")
    public List<Domicilio> getPersonas(){
        return  interDomicilio.getDomicilio();
    }

    @PostMapping ("/domicilio/crear")
    public String createDomicilio(@RequestBody Domicilio perso){

        interDomicilio.saveDomicilio(perso);
        return  "El Domicilio fue creada";
    }

    @DeleteMapping ("/domicilio/borrar/{id}")
    public String deleteDomicilio (@PathVariable long id){
        interDomicilio.deleteDomicilio(id);
        return "El Domicilio fue eliminada";
    }


    @PutMapping("domicilio/editar/{id}")
    public Domicilio editDomicilio (@PathVariable Long id,
                                @RequestParam ("calle") String nuevaCalle,
                                @RequestParam ("numero") String nuevoNumero,
                                @RequestParam ("piso") String nuevoPiso,
                                @RequestParam ("depertamento") String nuevoDepartamento,
                                @RequestParam ("ciudad") String nuevaCiudad,
                                @RequestParam ("provicnia") String nuevaProvincia){
        Domicilio domi = interDomicilio.findDomicilio(id);

        domi.setCalle(nuevaCalle);
        domi.setNumero(nuevoNumero);
        domi.setPiso(nuevoPiso);
        domi.setDepartamento(nuevoDepartamento);
        domi.setCiudad(nuevaCiudad);
        domi.setProvincia(nuevaProvincia);

        interDomicilio.saveDomicilio(domi);

        return domi;
    }
}
