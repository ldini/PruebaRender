package Service;

import Entity.Usuario;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IUsuarioService {
    
    public List<Usuario> getUsuario();

    public void saveUsuario (Usuario perso);

    public void deleteUsuario (Long id);

    public Usuario findUsuario (Long id);
}
