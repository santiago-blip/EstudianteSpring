package EstudianteSpring.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_curso")
public class Curso implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long idCurso;
    
    @NotEmpty
    @Column(name = "nombre")
    private String nombreCurso;
    
    @NotNull
    @Column(name = "precio")
    private Double precioCurso;
    
    public Curso(){
        
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombreCurso() {
        return nombreCurso;
    }

    public void setNombreCurso(String nombreCurso) {
        this.nombreCurso = nombreCurso;
    }

    public Double getPrecioCurso() {
        return precioCurso;
    }

    public void setPrecioCurso(Double precioCurso) {
        this.precioCurso = precioCurso;
    }
    
}
