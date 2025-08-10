//package com.bubches.forohub.controller;
//
//import com.bubches.forohub.usuarios.DatosAutenticacionUsuario;
//import com.bubches.forohub.model.Usuario;
//import com.bubches.forohub.security.DatosJWTToken;
//import com.bubches.forohub.security.TokenService;
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.*;
//import org.springframework.security.core.Authentication;
//
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/login")
//public class AutenticacionController {
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private TokenService tokenService;
//
//    @PostMapping
//    public ResponseEntity autenticarUsuario(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario) {
//        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.login(),
//                datosAutenticacionUsuario.clave());
//        var usuarioAutenticado = authenticationManager.authenticate(authToken);
//        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
//        return ResponseEntity.ok(new DatosJWTToken(JWTtoken));
//    }
//
//}