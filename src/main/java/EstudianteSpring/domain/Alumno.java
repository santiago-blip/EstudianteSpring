package EstudianteSpring.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "tbl_alumno")
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno")
    private int idAlumno;

    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario idUsuario;

    @ManyToOne
    @JoinColumn(name = "id_domicilio")
    private Domicilio idDomicilio;

    @ManyToOne
    @JoinColumn(name = "id_contacto")
    private Contacto idContacto;

    @Column(name = "nombre_alumno")
    private String nombre;

    @Column(name = "apellido_alumno")
    private String apellido;
    
    @OneToMany // o @OneToMany(mappedBy = "alumno") alumno es el campo de la otra clase donde está el joinColumn a esta tabla
    @JoinColumn(name = "id_alumno")
    private List<Asignacion> listaAsignacion;
    
    public Alumno(){
        
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Domicilio getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Domicilio idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public Contacto getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Contacto idContacto) {
        this.idContacto = idContacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Asignacion> getListaAsignacion() {
        return listaAsignacion;
    }

    public void setListaAsignacion(List<Asignacion> listaAsignacion) {
        this.listaAsignacion = listaAsignacion;
    }
    
}
