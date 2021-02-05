/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstudianteSpring.service.impl;

import EstudianteSpring.dao.RolDAO;
import EstudianteSpring.domain.Rol;
import EstudianteSpring.service.IServiceRol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceRolImpl implements IServiceRol{

    @Autowired
    private RolDAO serviceRolDAO;
    
    @Override
    public void saveRol(Rol rol) {
        serviceRolDAO.save(rol);
    }

    @Override
    public Rol findRol(Rol rol) {
        return serviceRolDAO.findById(rol.getIdRol()).orElse(null);
    }
    
}
