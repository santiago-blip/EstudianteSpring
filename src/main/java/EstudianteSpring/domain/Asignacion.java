package EstudianteSpring.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tbl_asignacion")
public class Asignacion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignacion")
    private int idAsignacion;
    
    @ManyToOne
    @JoinColumn(name = "id_alumno")
    private Alumno idAlumno;
    
    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso idCuros;
    
    public Asignacion(){
        
    }
    public int getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(int idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Alumno getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Alumno idAlumno) {
        this.idAlumno = idAlumno;
    }

    public Curso getIdCuros() {
        return idCuros;
    }

    public void setIdCuros(Curso idCuros) {
        this.idCuros = idCuros;
    }
    
}
