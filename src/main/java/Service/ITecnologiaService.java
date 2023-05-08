package Service;

import Entity.Tecnologia;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ITecnologiaService {
    
    public List<Tecnologia> getTecnologia();
   
    public void saveTecnologia (Tecnologia perso);

    public void deleteTecnologia (Long id);

    public Tecnologia findTecnologia (Long id);
}
