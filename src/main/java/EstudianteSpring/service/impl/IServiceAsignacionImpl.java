/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstudianteSpring.service.impl;

import EstudianteSpring.dao.AsignacionDAO;
import EstudianteSpring.domain.Asignacion;
import EstudianteSpring.service.IServiceAsignacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IServiceAsignacionImpl implements IServiceAsignacion{

    @Autowired
    private AsignacionDAO serviceDAO;
    
    @Override
    public List<Asignacion> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save(Asignacion asignacion) {
        serviceDAO.save(asignacion);
    }

    @Override
    public Asignacion findById(Asignacion asignacion) {
        return serviceDAO.findById(asignacion.getIdAsignacion()).orElse(null);
    }

    @Override
    public void delete(Asignacion asignacion) {
        serviceDAO.delete(asignacion);
    }

    @Override
    public void deleteAlumno(List<Asignacion> asignaciones) {
        serviceDAO.deleteAll(asignaciones);
    }

    
    
}
