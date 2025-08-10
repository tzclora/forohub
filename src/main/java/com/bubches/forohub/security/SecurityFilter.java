//package com.bubches.forohub.security;
//
//import com.bubches.forohub.model.Usuario;
//import com.bubches.forohub.repository.UsuarioRepository; // ✅ import correcto
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//public class SecurityFilter extends OncePerRequestFilter {
//
//    @Autowired
//    private TokenService tokenService;
//
//    @Autowired
//    private UsuarioRepository usuarioRepository;
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain filterChain)
//            throws ServletException, IOException {
//
//        var authHeader = request.getHeader("Authorization");
//
//        if (authHeader != null && authHeader.startsWith("Bearer ")) {
//            var token = authHeader.substring(7);
//            var login = tokenService.getSubject(token); // obtiene login desde el JWT
//
//            if (login != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//                Usuario usuario = usuarioRepository.findByEmail(login) // ✅ usamos el método correcto
//                        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
//
//                var authentication = new UsernamePasswordAuthenticationToken(
//                        usuario,
//                        null,
//                        usuario.getAuthorities()
//                );
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }
//
//        filterChain.doFilter(request, response);
//    }
//}
