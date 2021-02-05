/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstudianteSpring.service;

import EstudianteSpring.domain.Asignacion;
import java.util.List;

/**
 *
 * @author santi
 */
public interface IServiceAsignacion {

    public List<Asignacion> findAll();

    public void save(Asignacion asignacion);

    public Asignacion findById(Asignacion asignacion);

    public void delete(Asignacion asignacion);
    
    public void deleteAlumno(List<Asignacion> asignaciones);
}
