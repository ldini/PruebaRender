package Service;

import Entity.TipoEducacion;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ITipoEducacionService {
    
    public List<TipoEducacion> getTipoEducacion();

    public void saveTipoEducacion (TipoEducacion perso);

    public void deleteTipoEducacion (Long id);

    public TipoEducacion findTipoEducacion (Long id);
}
