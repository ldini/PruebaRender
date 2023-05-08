package Service;

import Entity.Domicilio;
import Entity.Persona;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface IDomicilioService {
    
    public List<Domicilio> getDomicilio();

    public void saveDomicilio (Domicilio domi);

    public void deleteDomicilio (Long id);

    public Domicilio findDomicilio (Long id);
}
