package com.appwbd.sraeu.component;

import com.appwbd.sraeu.entity.TipoUsuario;
import com.appwbd.sraeu.entity.Usuario;
import com.appwbd.sraeu.model.TipoUsuarioModel;
import com.appwbd.sraeu.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("tipoUsuarioConverter")
public class TipoUsuarioConverter {

    @Autowired
    @Qualifier("usuarioRepository")
    private UsuarioRepository usuarioRepository;

    public TipoUsuario convertTipoUsuarioModel2TipoUsuario(TipoUsuarioModel tipoUsuarioModel){
        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setId(tipoUsuarioModel.getId());
        tipoUsuario.setTipo(tipoUsuarioModel.getTipo());
        String priv = "";
        for (String privilegios : tipoUsuarioModel.getPrivilegios()) {
            priv += privilegios + ";";
        }
        List<Usuario> temp = new ArrayList<>();
        for (String usuario : tipoUsuarioModel.getUsuarios()) {
            temp.add(usuarioRepository.findByUsername(usuario));
        }
        tipoUsuario.setUsuarios(temp);
        tipoUsuario.setPrivilegios(priv);
        return tipoUsuario;
    }

    public TipoUsuarioModel convertTipoUsuario2TipoUsuarioModel(TipoUsuario tipoUsuario){
        TipoUsuarioModel tipoUsuarioModel = new TipoUsuarioModel();
        tipoUsuarioModel.setId(tipoUsuario.getId());
        tipoUsuarioModel.setTipo(tipoUsuario.getTipo());
        tipoUsuarioModel.setPrivilegios(tipoUsuario.getPrivilegios().split(";"));
        for (Usuario usuario : tipoUsuario.getUsuarios()) {
            tipoUsuarioModel.getUsuarios().add(usuario.getUsername());
        }
        return tipoUsuarioModel;
    }

}
