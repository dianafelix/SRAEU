package com.appwbd.sraeu.model;

import com.appwbd.sraeu.entity.TipoUsuario;
import lombok.Data;

@Data
public class UsuarioModel {

    private String username;
    private String password;
    private int tipoUsuarioId;
    private String tipoUsuarioTipo;
    private boolean enable;

    public UsuarioModel(){
    }

    public UsuarioModel(String username, String password, int tipoUsuarioId, String tipoUsuarioTipo, boolean enable) {
        this.username = username;
        this.password = password;
        this.tipoUsuarioId = tipoUsuarioId;
        this.tipoUsuarioTipo = tipoUsuarioTipo;
        this.enable = enable;
    }
}


