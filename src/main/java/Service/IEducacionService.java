package Service;

import Entity.Educacion;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IEducacionService {
    
    public List<Educacion> getEducacion();

    public void saveEducacion (Educacion perso);

    public void deleteEducacion (Long id);

    public Educacion findEducacion (Long id);
}
