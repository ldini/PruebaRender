package Service;

import Entity.Domicilio;
import Repository.DomicilioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DomicilioService implements IDomicilioService{

    @Autowired
    private DomicilioRepository DomiRepo;

    @Override
    public List<Domicilio> getDomicilio() {
        List<Domicilio> listaDomicilio = DomiRepo.findAll();
       return listaDomicilio;
    }

    @Override
    public void saveDomicilio(Domicilio domi) {
        DomiRepo.save(domi);
    }

    @Override
    public void deleteDomicilio(Long id) {
        DomiRepo.deleteById(id);
    }

    @Override
    public Domicilio findDomicilio(Long id) {
        Domicilio domi = DomiRepo.findById(id).orElse(null) ;
        return domi;
       }
}
