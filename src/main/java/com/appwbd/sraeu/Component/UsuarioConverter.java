package com.appwbd.sraeu.Component;

import com.appwbd.sraeu.Model.UsuarioModel;
import com.appwbd.sraeu.entity.Usuario;
import org.springframework.stereotype.Component;

@Component("usuarioConverter")

public class UsuarioConverter {
    Usuario convertUsuarioModel2Usuario(UsuarioModel usuarioModel) {
        Usuario usuario = new Usuario();
        usuario.setId(usuarioModel.getId());
        usuario.setNivel(usuarioModel.getNivel());
        usuario.setPassword(usuarioModel.getPassword());
        usuario.setNivel(usuarioModel.getNivel());
        return usuario;
    }

    public UsuarioModel convertUsuario2UsuarioModel(Usuario usuario){
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setId(usuarioModel.getId());
        usuarioModel.setNivel(usuarioModel.getNivel());
        usuarioModel.setPassword(usuarioModel.getPassword());
        return usuarioModel;
    }
}
