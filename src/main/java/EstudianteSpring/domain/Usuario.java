package EstudianteSpring.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tbl_usuario")
public class Usuario implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_usuario")
    private int idUsuario;
    
    @ManyToOne
    @JoinColumn(name = "id_rol")
    private Rol rol;
    
    private String nombre;
    
    @Column(name="contra")
    private String pass;
    
    public Usuario(){
        
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    
}
