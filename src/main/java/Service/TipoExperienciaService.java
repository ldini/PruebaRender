package Service;

import Entity.TipoExperiencia;
import Repository.TipoExperienciaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoExperienciaService implements ITipoExperienciaService{

    @Autowired
    private TipoExperienciaRepository tipoRepo;
    
    @Override
    public List<TipoExperiencia> getTipoExperiencia() {
        List<TipoExperiencia> listaTipo = tipoRepo.findAll();
        return listaTipo;
    }

    @Override
    public void saveTipoExperiencia(TipoExperiencia perso) {
        tipoRepo.save(perso);
    }

    @Override
    public void deleteTipoExperiencia(Long id) {
        tipoRepo.deleteById(id);
        }

    @Override
    public TipoExperiencia findTipoExperiencia(Long id) {
        TipoExperiencia tipo = tipoRepo.findById(id).orElse(null);
        return tipo;
    }
    
}
