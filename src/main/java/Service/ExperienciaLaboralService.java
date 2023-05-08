package Service;

import Repository.ExperienciaLaboralRepository;
import Entity.ExperienciaLaboral;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaLaboralService implements IExperienciaLaboralService{

    @Autowired 
    private ExperienciaLaboralRepository ExpeRepo; 
    
    @Override
    public List<Entity.ExperienciaLaboral> getExperienciaLaboral() {
        List<ExperienciaLaboral> listaExpe = ExpeRepo.findAll();
        return listaExpe;
    }

    @Override
    public void saveExperienciaLaboral(ExperienciaLaboral perso) {
        ExpeRepo.save(perso);
    }

    @Override
    public void deleteExperienciaLaboral(Long id) {
        ExpeRepo.deleteById(id);
    }

    @Override
    public Entity.ExperienciaLaboral findExperienciaLaboral(Long id) {
        ExperienciaLaboral expe = ExpeRepo.findById(id).orElse(null);
        return expe;
                
    }

}
