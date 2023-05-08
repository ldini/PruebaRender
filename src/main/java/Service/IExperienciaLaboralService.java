package Service;

import Entity.ExperienciaLaboral;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IExperienciaLaboralService {
    
    public List<ExperienciaLaboral> getExperienciaLaboral();

    public void saveExperienciaLaboral (ExperienciaLaboral perso);

    public void deleteExperienciaLaboral (Long id);

    public ExperienciaLaboral findExperienciaLaboral (Long id);
}
