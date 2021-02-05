/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstudianteSpring.service;

import EstudianteSpring.domain.Curso;
import java.util.List;


public interface IServiceCurso {
    
    public List<Curso> findAll();
    
    public void save(Curso curso);
    
    public Curso findById(Curso curso);
    
    public void delete(Curso curso);
    
}
