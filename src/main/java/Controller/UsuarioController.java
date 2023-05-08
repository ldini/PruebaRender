package Controller;

import Entity.Usuario;
import Service.IUsuarioService;
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
public class UsuarioController {
    
    @Autowired
    private IUsuarioService interUsuario;

    @GetMapping ("/personas/traer")
    public List<Usuario> getUsuario(){
        return  interUsuario.getUsuario();
    }

    @PostMapping ("/personas/crear")
    public String createUsuario(@RequestBody Usuario perso){

        interUsuario.saveUsuario(perso);
        return  "El Usuario fue creado";
    }

    @DeleteMapping ("/personas/borrar/{id}")
    public String deleteUsuario (@PathVariable long id){
        interUsuario.deleteUsuario(id);
        return "El Usuario fue eliminado";
    }


    @PutMapping("personas/editar/{id}")
    public Usuario editUsuario (@PathVariable Long id,
                                @RequestParam ("activo") String nuevoActivo
                                ){
        Usuario usu = interUsuario.findUsuario(id);

        usu.setActivo(true);

        interUsuario.saveUsuario(usu);

        return usu;
    }
}
