package EstudianteSpring.domain;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="tbl_domicilio")
public class Domicilio implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_domicilio")
    private int idDomicilio;
    
    private String calle;
    
    @Column(name="no_calle")
    private String noCalle;
    
    private String pais;
    
    public Domicilio(){
        
    }

    public int getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNoCalle() {
        return noCalle;
    }

    public void setNoCalle(String noCalle) {
        this.noCalle = noCalle;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
    
}
