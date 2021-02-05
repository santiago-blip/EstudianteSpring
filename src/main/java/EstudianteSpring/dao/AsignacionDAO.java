/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstudianteSpring.dao;

import EstudianteSpring.domain.Asignacion;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author santi
 */
public interface AsignacionDAO extends CrudRepository<Asignacion,Long>{
    
//    @Query("delete from Asignacion a where a.idAlumno.idAlumno= ?1")
//    public void deleteAsignacion(Long id);
    
}
