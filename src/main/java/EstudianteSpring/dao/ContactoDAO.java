/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstudianteSpring.dao;

import EstudianteSpring.domain.Contacto;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author santi
 */
public interface ContactoDAO extends CrudRepository<Contacto,Long>{
    
}
