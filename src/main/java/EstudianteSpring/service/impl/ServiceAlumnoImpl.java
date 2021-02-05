/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstudianteSpring.service.impl;

import EstudianteSpring.dao.AlumnoDAO;
import EstudianteSpring.domain.Alumno;
import EstudianteSpring.service.IServiceAlumno;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceAlumnoImpl implements IServiceAlumno{

    @Autowired
   private AlumnoDAO serviceDAO;
    
    @Override
    public List<Alumno> listarAlumnos() {
        return (List<Alumno>) serviceDAO.findAll();
    }

    @Override
    public void guardarAlumno(Alumno alumno) {
        serviceDAO.save(alumno);
    }

    @Override
    public Alumno traerAlumno(Alumno alumno) {
        return serviceDAO.findById(alumno.getIdAlumno()).orElse(null);
    }

    @Override
    public void eliminarAlumno(Alumno alumno) {
        serviceDAO.delete(alumno);
    }
    
}
