package com.bubches.forohub.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(name = "correo_electronico", unique = true, nullable = false)
    private String correoElectronico;

    private String contrasena;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "usuarios_perfiles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "perfil_id")
    )
    private Set<Perfil> perfiles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return perfiles.stream()
                .map(perfil -> new SimpleGrantedAuthority(perfil.getNombre()))
                .collect(Collectors.toSet());
    }

    @Override
    public String getPassword() {
        return this.contrasena;  // DEVUELVE CONTRASEÑA REAL HASHEADA
    }

    @Override
    public String getUsername() {
        return this.correoElectronico;  // DEVUELVE EL CORREO REAL
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // o lógica propia si tienes campo para esto
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // o lógica propia
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // o lógica propia
    }

    @Override
    public boolean isEnabled() {
        return true; // o lógica propia
    }
}
