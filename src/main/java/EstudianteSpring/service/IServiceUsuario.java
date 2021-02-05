/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstudianteSpring.service;

import EstudianteSpring.domain.Usuario;
import java.util.List;

/**
 *
 * @author santi
 */
public interface IServiceUsuario {

    public List<Usuario> listarUsuario();

    public void guardarUsuario(Usuario usuario);

    public Usuario traerUsuario(Usuario usuario);

    public void eliminarUsuario(Long id);
}
