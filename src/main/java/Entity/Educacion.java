package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Educacion {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String tipo;
    private String institucion;
    private String titulo;
    private String carrera;
    private String inicio;
    private String fin;
    private boolean enCurso ;
    
    @OneToOne
    private TipoEducacion tipoEducacion;
    
    @ManyToMany
    private List<Persona> persona;
}
