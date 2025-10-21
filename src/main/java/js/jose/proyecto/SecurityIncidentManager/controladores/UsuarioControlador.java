/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package js.jose.proyecto.SecurityIncidentManager.controladores;

import js.jose.proyecto.SecurityIncidentManager.modelos.Usuario;
import js.jose.proyecto.SecurityIncidentManager.servicios.UsuarioServicioImplementacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuario")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicioImplementacion servicioImplementacion;

    @GetMapping("/listaUsuarios")
    public String listaUsuarios(Model model) {

        model.addAttribute("titulo", "Lista de Usuarios");
        model.addAttribute("listaUsuario", servicioImplementacion.findAll());

        return "listaUsuarios";
    }

    @GetMapping("/crearUsuario")
    public String crearUsuarios(Model model) {

        model.addAttribute("titulo", "Crear nuevo de Usuarios");
        model.addAttribute("usuario", new Usuario());
        return "crearUsuario";
    }

    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        
        servicioImplementacion.guardarUsuario(usuario);
        return "redirect:/usuario/listaUsuarios";

    }

    @GetMapping("/editarUsuario/{id}")
    public String editarUsuario(@PathVariable Integer id, Model model) {
        Usuario usuario = servicioImplementacion.findById(id).orElseThrow(() -> new IllegalArgumentException("Id no encontrado: ->  " + id));
        model.addAttribute("titulo", "Editar al Usuario");
        model.addAttribute("usuario", usuario);
        return "editarUsuario";

    }

    @GetMapping("/eliminarUsuario/{id}")
    public String eliminarUsuario(@PathVariable Integer id) {
        Usuario usuario = servicioImplementacion.findById(id).orElseThrow(() -> new IllegalArgumentException("Id no encontrado: ->  " + id));
        servicioImplementacion.deleteById(id);
        return "redirect:/usuario/listaUsuarios";

    }

}
