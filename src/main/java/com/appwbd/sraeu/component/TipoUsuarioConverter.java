package com.appwbd.sraeu.component;

import com.appwbd.sraeu.entity.TipoUsuario;
import com.appwbd.sraeu.model.TipoUsuarioModel;
import org.springframework.stereotype.Component;

@Component("tipoUsuarioConverter")
public class TipoUsuarioConverter {

    public TipoUsuario convertTipoUsuarioModel2TipoUsuario(TipoUsuarioModel tipoUsuarioModel){
        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setId(tipoUsuarioModel.getId());
        tipoUsuario.setTipo(tipoUsuarioModel.getTipo());
        tipoUsuario.setUsuarios(tipoUsuarioModel.getUsuarios());

        return tipoUsuario;
    }

    public TipoUsuarioModel convertTipoUsuario2TipoUsuarioModel(TipoUsuario tipoUsuario){
        TipoUsuarioModel tipoUsuarioModel = new TipoUsuarioModel();
        tipoUsuarioModel.setId(tipoUsuario.getId());
        tipoUsuarioModel.setTipo(tipoUsuario.getTipo());
        tipoUsuarioModel.setUsuarios(tipoUsuario.getUsuarios());

        return tipoUsuarioModel;
    }

}
