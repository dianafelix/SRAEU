package com.appwbd.sraeu.component;

import com.appwbd.sraeu.entity.Usuario;
import com.appwbd.sraeu.model.UsuarioModel;
import com.appwbd.sraeu.repository.TipoUsuarioRepository;
import com.appwbd.sraeu.services.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("usuarioConverter")
public class UsuarioConverter {

    @Autowired
    @Qualifier("tipoUsuarioRepository")
    private TipoUsuarioRepository tipoUsuarioRepository;

    public Usuario convertUsuarioModel2Usuario(UsuarioModel usuarioModel) {
        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioModel.getUsername());
        usuario.setPassword(usuarioModel.getPassword());
        usuario.setEnable(usuarioModel.isEnable());
        usuario.setTipoUsuario(tipoUsuarioRepository.findById(usuarioModel.getTipoUsuarioId()));

        return usuario;
    }

    public UsuarioModel convertUsuario2UsuarioModel(Usuario usuario){
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setUsername(usuario.getUsername());
        usuarioModel.setPassword(usuario.getPassword());
        usuarioModel.setEnable(usuario.isEnable());
        if(usuario.getTipoUsuario() != null) {
            usuarioModel.setTipoUsuarioId(usuario.getTipoUsuario().getId());
            usuarioModel.setTipoUsuarioTipo(usuario.getTipoUsuario().getTipo());
        }
        return usuarioModel;
    }
}
