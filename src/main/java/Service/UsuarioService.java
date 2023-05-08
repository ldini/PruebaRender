package Service;

import Entity.Usuario;
import Repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService{

    @Autowired
    private UsuarioRepository usuRepo;
    
    @Override
    public List<Usuario> getUsuario() {
        List<Usuario> listaUsu = usuRepo.findAll();
        return listaUsu;
    }

    @Override
    public void saveUsuario(Usuario perso) {
        usuRepo.save(perso);
    }

    @Override
    public void deleteUsuario(Long id) {
        usuRepo.deleteById(id);
    }

    @Override
    public Usuario findUsuario(Long id) {
        Usuario usu = usuRepo.findById(id).orElse(null);
        return usu;
    }
    
}
