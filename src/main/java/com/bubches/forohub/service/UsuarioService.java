package com.bubches.forohub.service;

import com.bubches.forohub.model.Usuario;
import com.bubches.forohub.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return usuarioRepository.findByCorreoElectronico(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + email));
    }

    public boolean usuarioExiste(String email) {
        return usuarioRepository.findByCorreoElectronico(email).isPresent();
    }

    public Usuario crearUsuario(String correo, String password, String nombre) {
        Usuario usuario = new Usuario();
        usuario.setCorreoElectronico(correo);
        usuario.setNombre(nombre);
        usuario.setContrasena(passwordEncoder.encode(password));
        return usuarioRepository.save(usuario);
    }
}
