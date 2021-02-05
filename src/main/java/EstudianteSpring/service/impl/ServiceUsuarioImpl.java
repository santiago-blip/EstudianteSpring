/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstudianteSpring.service.impl;

import EstudianteSpring.dao.UsuarioDAO;
import EstudianteSpring.domain.Usuario;
import EstudianteSpring.service.IServiceUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceUsuarioImpl implements IServiceUsuario{

    @Autowired
    private UsuarioDAO serviceDAO;
    
    @Override
    public List<Usuario> listarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        serviceDAO.save(usuario);
    }

    @Override
    public Usuario traerUsuario(Usuario usuario) {
       return serviceDAO.findById(usuario.getIdUsuario()).orElse(null);
    }

    @Override
    public void eliminarUsuario(Long id) {
        serviceDAO.deleteById(id);
    }

   
    
}
