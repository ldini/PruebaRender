package Service;

import Entity.Educacion;
import Repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{

    @Autowired EducacionRepository Edurepo;
    
    @Override
    public List<Educacion> getEducacion() {
        List<Educacion> listaEducacion = Edurepo.findAll();
        return listaEducacion;
    }

    @Override
    public void saveEducacion(Educacion perso) {
        Edurepo.save(perso);
    }

    @Override
    public void deleteEducacion(Long id) {
        Edurepo.deleteById(id);
    }

    @Override
    public Educacion findEducacion(Long id) {
        Educacion edu = Edurepo.findById(id).orElse(null);
        return edu;
    }
    
}
