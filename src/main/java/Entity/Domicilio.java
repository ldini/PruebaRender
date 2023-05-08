package Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Domicilio {
     @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String  calle;
    private String numero;
    private String piso;
    private String departamento;
    private String ciudad;
    private String provincia;
    
    @ManyToOne
    private Persona persona;
}
