/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstudianteSpring.service.impl;

import EstudianteSpring.dao.CursoDAO;
import EstudianteSpring.domain.Curso;
import EstudianteSpring.service.IServiceCurso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IServiceCursoImpl implements IServiceCurso{

    @Autowired
    private CursoDAO serviceDAO;
    
    @Override
    public List<Curso> findAll() {
        return (List<Curso>) serviceDAO.findAll();
    }

    @Override
    public void save(Curso curso) {
        serviceDAO.save(curso);
    }

    @Override
    public Curso findById(Curso curso) {
        return serviceDAO.findById(curso.getIdCurso()).orElse(null);
    }

    @Override
    public void delete(Curso curso) {
        serviceDAO.delete(curso);
    }
    
}
