package Service;

import Entity.TipoExperiencia;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ITipoExperienciaService {
    
    public List<TipoExperiencia> getTipoExperiencia();

    public void saveTipoExperiencia (TipoExperiencia perso);

    public void deleteTipoExperiencia (Long id);

    public TipoExperiencia findTipoExperiencia (Long id);
}
