package com.appwbd.sraeu.model;

import com.appwbd.sraeu.entity.TipoUsuario;
import lombok.Data;

@Data
public class UsuarioModel {

    private String username;
    private String password;
    private TipoUsuario tipoUsuario;
    private boolean enable;

    public UsuarioModel(){
    }

    public UsuarioModel(String username, String password, TipoUsuario tipoUsuario, boolean enable) {
        this.username = username;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
        this.enable = enable;
    }
}


