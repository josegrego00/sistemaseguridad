/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package js.jose.proyecto.SecurityIncidentManager.servicios;

import java.util.List;
import java.util.Optional;
import js.jose.proyecto.SecurityIncidentManager.modelos.Usuario;

/**
 *
 * @author josepino
 */
public interface UsuarioServicios {

    List<Usuario> findAll();

    Optional<Usuario> findById(Integer id);

    Usuario save(Usuario usuario);

    void deleteById(Integer id);
    
    

}
