/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstudianteSpring.controller;

import EstudianteSpring.dao.UsuarioDAO;
import EstudianteSpring.domain.Alumno;
import EstudianteSpring.domain.Curso;
import EstudianteSpring.domain.Rol;
import EstudianteSpring.domain.Usuario;
import EstudianteSpring.service.IServiceAlumno;
import EstudianteSpring.service.IServiceCurso;
import EstudianteSpring.service.IServiceRol;
import EstudianteSpring.service.IServiceUsuario;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {

    private Logger logger = LoggerFactory.getLogger(AppController.class);
    @Autowired
    private IServiceAlumno serviceDAO;

    @Autowired
    private IServiceRol serviceRolDAO;
    
    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    private IServiceCurso serviceCursoDAO;

    @Autowired
    private IServiceUsuario serviceUsuarioDAO;

    @Autowired
    private BCryptPasswordEncoder encode;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexAdmin(Model model,Authentication auth) {

            System.out.println(auth.getName());
            Usuario usuario = usuarioDAO.findByNombre(auth.getName());
           System.out.println(usuario.getIdUsuario());
           System.out.println(usuario.getNombre());
           System.out.println(usuario.getRol().getIdRol() + " "+ usuario.getRol().getRole());
        model.addAttribute("usuarioLog", usuario);
        model.addAttribute("alumnos", serviceDAO.listarAlumnos());
        return "admin/indexAdmin";
    }

    @GetMapping("/nuevo")
    public String nuevoEstudiante(Alumno alumno, Model model) {

        return "admin/nuevo";
    }

    @PostMapping("/agregar")
    public String nuevoEstudiante(Alumno alumno, BindingResult error, Model model) {
        Long idViene = alumno.getIdAlumno();
//        if (error.hasErrors()) {
//            System.out.println(error.getFieldError().toString());
//            System.out.println("Entro en hasError");
//            return "admin/nuevo";
//        }
        if (alumno != null) {
            Usuario usuario = (Usuario) alumno.getIdUsuario();
            Rol rol = new Rol();
            rol.setIdRol(2L);
//            rol.setRole("ROLE_USER");
            usuario.setRol(rol);
            usuario.setPass(encode.encode(usuario.getPass()));
            System.out.println("Rol: " + usuario.getRol().getRole());
            System.out.println("Usuario: " + usuario.getNombre());
            System.out.println("Password: " + usuario.getPass());
            System.out.println("ContactoEmail: " + alumno.getIdContacto().getEmail());
            System.out.println("");
            System.out.println("");
            serviceUsuarioDAO.guardarUsuario(usuario);
            serviceDAO.guardarAlumno(alumno);

        }
        if (idViene == null || idViene == 0) {
            return "redirect:/";
        } else {
            return "redirect:/ver/" + alumno.getIdAlumno();
        }
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable(name = "id") String id, Alumno alumno, Model model) {
        alumno.setIdAlumno(Long.parseLong(id));
        alumno = serviceDAO.traerAlumno(alumno);
        if (alumno != null) {
            model.addAttribute("alumno", alumno);
            return "admin/ver";
        }
        return "redirect:/";
    }

    @GetMapping("/ver/cursos")
    public String cursoVer(Model model) {
        model.addAttribute("cursos", serviceCursoDAO.findAll());
        return "admin/cursoVer";
    }

    @GetMapping("/agregar/curso")
    public String cursoAdd(Curso curso) {
        return "admin/curso";
    }

    @PostMapping("/agregar/curso")
    public String cursoAdd(@Valid Curso curso, Errors errors) {
        if (errors.hasErrors()) {
            return "admin/curso";
        }
        serviceCursoDAO.save(curso);
        return "redirect:/ver/cursos";
    }

    @GetMapping("/editar/curso")
    public String cursoEdit(Curso curso, Model model) {
        if (curso.getIdCurso() > 0) {
            curso = serviceCursoDAO.findById(curso);
            if (curso != null) {
                model.addAttribute("curso", curso);
                return "admin/curso";
            }
        }
        return "redirect:/";
    }

    @GetMapping("/eliminar/curso/{id}")
    public String cursoDelete(@PathVariable(name = "id") Long id, Curso curso) {
        curso.setIdCurso(id);
        serviceCursoDAO.delete(curso);
        return "redirect:/ver/cursos";
    }

    //VALIDAR USUARIO
//    @PostConstruct
//    public void initMethod(){
//        Authentication auth = SecurityContextHolder
//                .getContext()
//                .getAuthentication();
//        UserDetails userDetail = (UserDetails) auth.getPrincipal();
//        Usuario usuario = new Usuario();
//        System.out.println(userDetail.getUsername());
//        usuario = this.usuarioDAO.findByNombre(userDetail.getUsername());
//        System.out.println(usuario);
//        System.out.println(usuario.getNombre());
//        System.out.println(usuario.getPass());
//        System.out.println(usuario.getRol().getIdRol());
//        System.out.println(usuario.getRol().getRole());
    }
//}
