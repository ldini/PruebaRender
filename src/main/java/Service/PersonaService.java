package Service;

import Entity.Persona;
import Repository.PersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaServicio {
    
    @Autowired
    private PersonaRepository personaRepositorio;

    @Override
    public List<Persona> getPersonas() {
       List<Persona> listaPersonas = personaRepositorio.findAll();
       return listaPersonas;
    }

    @Override
    public void savePersona(Persona perso) {
        personaRepositorio.save(perso);
    }

    @Override
    public void deletePersona(Long id) {
    personaRepositorio.deleteById(id);
    }

    @Override
    public Persona findPersona(Long id) {
        Persona perso = personaRepositorio.findById(id).orElse(null) ;
        return perso;
    }
}
