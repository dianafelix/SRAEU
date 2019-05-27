package com.appwbd.sraeu.services.impl;

import com.appwbd.sraeu.entity.Usuario;
import com.appwbd.sraeu.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    @Qualifier("usuarioRepository")
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if(usuario==null) throw new UsernameNotFoundException(username);
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        String[] privilegios = usuario.getTipoUsuario().getPrivilegios().split(";");
        for(String privilegio : privilegios){
            grantedAuthorities.add(new SimpleGrantedAuthority(privilegio));
        }

        return new org.springframework.security.core.userdetails.User(usuario.getUsername(),usuario.getPassword(), usuario.isEnable(),true, usuario.isEnable(),true,grantedAuthorities);
    }
}
