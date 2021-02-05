/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstudianteSpring.service.impl;

import EstudianteSpring.dao.UsuarioDAO;
import EstudianteSpring.domain.Rol;
import EstudianteSpring.domain.Usuario;
import EstudianteSpring.service.IServiceRol;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("serviceLogin")
public class ServiceLogin implements UserDetailsService {

    @Autowired
    private UsuarioDAO serviceDAO;

    @Autowired
    private IServiceRol serviceRolDAO;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        Usuario usuario = serviceDAO.findByNombre(string);
        List<GrantedAuthority> grantedAuthority = new ArrayList<>();
          grantedAuthority.add(new SimpleGrantedAuthority(usuario.getRol().getRole()));
          System.out.println("Esto es el ROL QUE PASA: "+usuario.getRol().getRole());
        return new User(usuario.getNombre(), usuario.getPass(), grantedAuthority);

    }

}
