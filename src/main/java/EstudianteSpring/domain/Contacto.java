package EstudianteSpring.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tbl_contacto")
public class Contacto implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_contacto")
    private int idContacto;
    
    private String telefono;
    
    private String email;
    
    public Contacto(){
        
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
