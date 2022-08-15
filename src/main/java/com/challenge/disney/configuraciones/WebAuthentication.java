package com.challenge.disney.configuraciones;

import com.challenge.disney.modelos.Usuario;
import com.challenge.disney.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebAuthentication extends GlobalAuthenticationConfigurerAdapter {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    public void init(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(usuarioEmail -> {
            Usuario usuario = usuarioRepositorio.findByEmail(usuarioEmail);
            if (usuario != null) {
                return new User(usuario.getEmail(), usuario.getContraseña(), AuthorityUtils.createAuthorityList("USUARIO"));
            } else {
                throw new UsernameNotFoundException("Usuario no registrado: " + usuarioEmail);
            }
        });
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
