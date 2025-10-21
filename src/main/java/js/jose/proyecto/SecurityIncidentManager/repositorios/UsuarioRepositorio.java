/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Repository.java to edit this template
 */
package js.jose.proyecto.SecurityIncidentManager.repositorios;

import js.jose.proyecto.SecurityIncidentManager.modelos.Usuario;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author josepino
 */
public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {
    
}
