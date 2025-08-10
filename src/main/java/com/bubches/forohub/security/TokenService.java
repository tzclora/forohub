//package com.bubches.forohub.security;
//
//import com.bubches.forohub.model.Usuario;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//
//@Service
//public class TokenService {
//
//    @Value("${api.security.secret}")
//    private String secret;
//
//    public String generarToken(Usuario usuario) {
//        Date ahora = new Date();
//        Date expiracion = new Date(ahora.getTime() + 1000 * 60 * 60); // 1 hora
//
//        return Jwts.builder()
//                .setIssuer("API ForoHub")
//                .setSubject(usuario .getEmail()) // usamos email en vez de login
//                .setIssuedAt(ahora)
//                .setExpiration(expiracion)
//                .signWith(SignatureAlgorithm.HS256, secret)
//                .compact();
//    }
//
//    public String getSubject(String tokenJWT) {
//        return Jwts.parser()
//                .setSigningKey(secret)
//                .parseClaimsJws(tokenJWT)
//                .getBody()
//                .getSubject();
//    }
//}
