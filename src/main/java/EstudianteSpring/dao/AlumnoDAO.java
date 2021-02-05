package EstudianteSpring.dao;

import EstudianteSpring.domain.Alumno;
import org.springframework.data.repository.CrudRepository;


public interface AlumnoDAO extends CrudRepository<Alumno, Long>{
    
}
