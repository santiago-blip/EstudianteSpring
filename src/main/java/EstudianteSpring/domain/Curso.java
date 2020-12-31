package EstudianteSpring.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "tbl_curso")
public class Curso implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private int idCurso;
    
    @Column(name = "nombre")
    private String nombreCurso;
    
    @Column(name = "precio")
    private Double precioCurso;
    
    public Curso(){
        
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
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
