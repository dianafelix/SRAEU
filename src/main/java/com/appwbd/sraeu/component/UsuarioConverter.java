package com.appwbd.sraeu.component;

import com.appwbd.sraeu.entity.Usuario;
import com.appwbd.sraeu.model.UsuarioModel;
import org.springframework.stereotype.Component;

@Component("usuarioConverter")

public class UsuarioConverter {
    public Usuario convertUsuarioModel2Usuario(UsuarioModel usuarioModel) {
        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioModel.getUsername());
        usuario.setPassword(usuarioModel.getPassword());
        usuario.setEnable(usuarioModel.isEnable());
        usuario.setTipoUsuario(usuarioModel.getTipoUsuario());

        return usuario;
    }

    public UsuarioModel convertUsuario2UsuarioModel(Usuario usuario){
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setUsername(usuario.getUsername());
        usuarioModel.setPassword(usuario.getPassword());
        usuarioModel.setEnable(usuario.isEnable());
        usuarioModel.setTipoUsuario(usuario.getTipoUsuario());

        return usuarioModel;
    }
}
