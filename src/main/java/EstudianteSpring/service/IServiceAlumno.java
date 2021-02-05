/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstudianteSpring.service;

import EstudianteSpring.domain.Alumno;
import java.util.List;


public interface IServiceAlumno {
    
    public List<Alumno> listarAlumnos();
    
    public void guardarAlumno(Alumno alumno);
    
    public Alumno traerAlumno(Alumno alumno);
    
    public void eliminarAlumno(Alumno alumno);
}
