package Service;

import Entity.Tecnologia;
import Repository.TecnologiaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TecnologiaService implements ITecnologiaService {

    @Autowired
    private TecnologiaRepository TecnoRepo;
    
    @Override
    public List<Tecnologia> getTecnologia() {
        List<Tecnologia> listaTecno = TecnoRepo.findAll();
        return listaTecno;
    }

    @Override
    public void saveTecnologia(Tecnologia perso) {
        TecnoRepo.save(perso);
    }

    @Override
    public void deleteTecnologia(Long id) {
        TecnoRepo.deleteById(id);
    }

    @Override
    public Tecnologia findTecnologia(Long id) {
        Tecnologia tecno = TecnoRepo.findById(id).orElse(null);
        return tecno;
    }
    
}
