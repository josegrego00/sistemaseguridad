package js.jose.proyecto.SecurityIncidentManager.servicios;

import java.util.List;
import java.util.Optional;

import js.jose.proyecto.SecurityIncidentManager.modelos.Usuario;
import js.jose.proyecto.SecurityIncidentManager.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UsuarioServicioImplementacion implements UsuarioServicios {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private BCryptPasswordEncoder claveEncoder;

    @Override
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioRepositorio.findAll();
    }

    @Override
    public Optional<Usuario> findById(Integer id) {
        return usuarioRepositorio.findById(id);
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        if (usuarioRepositorio.findById(id).isPresent()) {
            usuarioRepositorio.deleteById(id);
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

    // 👉 Este método maneja creación o actualización a partir del DTO
    @Transactional
    public void guardarUsuario(Usuario usuario) {

        if (usuario.getId() != null) {
            Optional<Usuario> existente = usuarioRepositorio.findById(usuario.getId());
            if (existente.isPresent()) {
                String contrasennaActual = existente.get().getContrasenna();

                // Si el campo viene vacío o nulo, mantenemos la existente
                if (usuario.getContrasenna() == null || usuario.getContrasenna().isBlank()) {
                    usuario.setContrasenna(contrasennaActual);
                    usuario.setUsername(existente.get().getUsername());
                }
            }
        } else {
            // Nuevo usuario: encriptar siempre
            usuario.setContrasenna(claveEncoder.encode(usuario.getContrasenna()));
        }

        save(usuario);
    }

}
