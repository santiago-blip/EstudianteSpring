/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstudianteSpring.service;

import EstudianteSpring.domain.Rol;


public interface IServiceRol {
    
    public void saveRol(Rol rol);
    
    public Rol findRol(Rol rol);
}
