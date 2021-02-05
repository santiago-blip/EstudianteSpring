package EstudianteSpring.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.Valid;

@Entity
@Table(name = "tbl_asignacion")
public class Asignacion implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignacion")
    private Long idAsignacion;
    
    @Valid
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_alumno")
    private Alumno idAlumno;
    
    @Valid
    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso idCuros;
    
    public Asignacion(){
        
    }
    public Long getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Long idAsignacion) {
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
