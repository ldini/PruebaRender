package Service;

import Entity.TipoEducacion;
import Repository.TipoEducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoEducacionService implements ITipoEducacionService{

    @Autowired
    private TipoEducacionRepository EduRepo;
    
    @Override
    public List<TipoEducacion> getTipoEducacion() {
        List<TipoEducacion> listaEdu = EduRepo.findAll();
        return listaEdu;
    }

    @Override
    public void saveTipoEducacion(TipoEducacion perso) {
        EduRepo.save(perso);
    }

    @Override
    public void deleteTipoEducacion(Long id) {
        EduRepo.deleteById(id);
    }

    @Override
    public TipoEducacion findTipoEducacion(Long id) {
        TipoEducacion tipo = EduRepo.findById(id).orElse(null);
        return tipo;
    }
    
    
}
