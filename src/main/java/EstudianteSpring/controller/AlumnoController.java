/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstudianteSpring.controller;

import EstudianteSpring.dao.ContactoDAO;
import EstudianteSpring.dao.DomicilioDAO;
import EstudianteSpring.domain.Alumno;
import EstudianteSpring.domain.Asignacion;
import EstudianteSpring.domain.Curso;
import EstudianteSpring.domain.Usuario;
import EstudianteSpring.service.IServiceAlumno;
import EstudianteSpring.service.IServiceAsignacion;
import EstudianteSpring.service.IServiceCurso;
import EstudianteSpring.service.IServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/alumno")
public class AlumnoController {

    @Autowired
    private BCryptPasswordEncoder encode;

    @Autowired
    private IServiceCurso serviceCursoDAO;

    @Autowired
    private ContactoDAO serviceContactoDAO;
    @Autowired
    private DomicilioDAO serviceDomicilioDAO;
    
    @Autowired
    private IServiceAsignacion serviceAsignacionDAO;

    @Autowired
    private IServiceUsuario serviceUsuario;

    @Autowired
    private IServiceAlumno serviceAlumno;

    @GetMapping("/recuperar")
    public String recuperar(@RequestParam(name = "id") String id, Usuario usuario, Model model) {

        if (Long.parseLong(id) > 0) {
            Alumno alumno = new Alumno();
            alumno.setIdAlumno(Long.parseLong(id));
            alumno = serviceAlumno.traerAlumno(alumno);
            usuario.setIdUsuario(alumno.getIdUsuario().getIdUsuario());
            usuario = serviceUsuario.traerUsuario(usuario);
            if (usuario != null) {
                model.addAttribute("usuario", usuario.getIdUsuario());
                model.addAttribute("alumno", alumno.getIdAlumno());
                return "admin/recuperar";
            } else {
                return "redirect:/ver/" + id;
            }
        }
        return "redirect:/";
    }

    @PostMapping("/recuperar")
    public String recuperar(@RequestParam(name = "idUsuario") String id, @RequestParam(name = "passUser") String pass, @RequestParam(name = "idAlumno") String idAlumno) {

        Usuario usuario = new Usuario();
        if (Long.parseLong(id) > 0 && id != null) {
            usuario.setIdUsuario(Long.parseLong(id));
            usuario = serviceUsuario.traerUsuario(usuario);
            usuario.setPass(encode.encode(pass));
            serviceUsuario.guardarUsuario(usuario);
            return "redirect:/ver/" + idAlumno;
        }
        return "redirect:/";
    }

    @GetMapping("/editar")
    public String editar(@RequestParam(name = "idAlumno") Long id, Alumno alumno, Model model) {
        alumno = serviceAlumno.traerAlumno(alumno);
        model.addAttribute("alumno", alumno);
        return "admin/nuevo";
    }

    @GetMapping("/eliminar")
    public String eliminar(Alumno alumno) {
        try{
            alumno = serviceAlumno.traerAlumno(alumno);
            System.out.println("Usuario id: "+alumno.getIdUsuario().getIdUsuario());
            System.out.println("Contacto id: "+alumno.getIdContacto().getIdContacto());
            System.out.println("Domicilio id: "+alumno.getIdDomicilio().getIdDomicilio());
            System.out.println("Alumno ID: "+alumno.getIdAlumno());
            System.out.println("Alumno NOMBRE: "+alumno.getNombre());
            System.out.println("Alumno APELLIDO: "+alumno.getApellido());
        serviceUsuario.eliminarUsuario(alumno.getIdUsuario().getIdUsuario());
        serviceContactoDAO.deleteById(alumno.getIdContacto().getIdContacto());
        serviceDomicilioDAO.deleteById(alumno.getIdDomicilio().getIdDomicilio());
        Long id = alumno.getIdAlumno();
        serviceAsignacionDAO.deleteAlumno(alumno.getListaAsignacion());
            System.out.println("ID ASIGNACION: "+id);
        serviceAlumno.eliminarAlumno(alumno);
        }catch(Exception e){
            return "redirect:/";
        }
        return "redirect:/";
    }

    @GetMapping("/curso/alumno/{idAlumno}")
    public String agregarCurso(@PathVariable(name = "idAlumno") Long id, Model model, Curso curso) {
        model.addAttribute("idAlumno", id);
        model.addAttribute("idUsuario",0L);
        model.addAttribute("cursos", serviceCursoDAO.findAll());
        return "admin/cursosAdd";
    }
    @PostMapping("/curso/alumno/")
    public String agregarCurso(@RequestParam(name = "idAlumno") Long idAlumno, @RequestParam(name = "idUsuario",required = false) Long idUsuario,Model model, Curso curso) {
        model.addAttribute("idAlumno", idAlumno);
        model.addAttribute("idUsuario", idUsuario);
        model.addAttribute("cursos", serviceCursoDAO.findAll());
        return "admin/cursosAdd";
    }

    @PostMapping("/agregar/curso/alumno/")
    public String agregarCurso(@RequestParam(name = "idCurso") Long id, Curso curso, @RequestParam(name = "idAlumno") Long idAlumno, Alumno alumno,@RequestParam(name = "idUsuario") Long idUsuario ,Model model) {
        System.out.println("IdAlumno: " + alumno.getIdAlumno());
        System.out.println("IdCurso: " + curso.getIdCurso());
        alumno = serviceAlumno.traerAlumno(alumno);
        curso = serviceCursoDAO.findById(curso);
        if (alumno == null && curso != null) {
            return "redirect:/";
        }
        Asignacion asignacion = new Asignacion();
        asignacion.setIdAlumno(alumno);
        asignacion.setIdCuros(curso);
        serviceAsignacionDAO.save(asignacion);
        if(idUsuario == null || idUsuario==0){
        return "redirect:/alumno/curso/alumno/" + alumno.getIdAlumno();
        }else{
            return "redirect:/";
        }
    }

    @GetMapping("/eliminar/curso/alumno/{idCurso}")
    public String eliminarCurso(@PathVariable(name = "idCurso") Long id, Asignacion asignacion) {
        System.out.println("ENTRO A ELIMINAR EL CURSO: ");
        asignacion.setIdAsignacion(id);
        System.out.println("AQUÍ SE LE ASIGNA EL ID: "+id+" da: "+asignacion.getIdAsignacion());
        asignacion = serviceAsignacionDAO.findById(asignacion);
        if (asignacion == null) {
            System.out.println("ENTRO EN NULL");
            return "redirect:/";
        }
        System.out.println("ENTRO A ELIMINAR EL CURSO: "+asignacion.getIdAsignacion());
        serviceAsignacionDAO.delete(asignacion);
//        return "redirect:/alumno/curso/alumno/" + alumno.getIdAlumno();
          return "redirect:/";
    }
//    @PostMapping("/eliminar/curso/alumno")
//    public String eliminarCurso(@RequestParam(name = "idCurso") Long id, @RequestParam(name = "idUsuario") Long idUsuario,Asignacion asignacion) {
//        asignacion.setIdAsignacion(id);
//        asignacion = serviceAsignacionDAO.findById(asignacion);
//        if (asignacion == null) {
//            System.out.println("ENTRO EN NULL");
//            return "redirect:/";
//        }
//        System.out.println("ENTRO A ELIMINAR EL CURSO: "+asignacion.getIdAsignacion());
//        serviceAsignacionDAO.delete(asignacion);
////        return "redirect:/alumno/curso/alumno/" + alumno.getIdAlumno();
//          return "redirect:/";
//    }
}
