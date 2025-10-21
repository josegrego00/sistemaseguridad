/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package js.jose.proyecto.SecurityIncidentManager.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class LoginControlador {

    @GetMapping({"/index", "/"})
    public String index() {
        return "login";
    }

    @GetMapping("/gestion")
    public String validacionUsuario() {
        return "menuPrincipal";
    }

}
