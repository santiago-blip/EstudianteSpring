/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstudianteSpring.dao;

import EstudianteSpring.domain.Rol;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author santi
 */
public interface RolDAO extends CrudRepository<Rol,Long>{
    
}
