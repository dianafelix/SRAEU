package com.appwbd.sraeu.model;

import lombok.Data;

@Data
public class UsuarioModel {

    private String username;
    private String password;
    private String tipo;

    public UsuarioModel(){
    }

    public UsuarioModel(String username, String password, String tipo) {
        this.username = username;
        this.password = password;
        this.tipo = tipo;
    }
}


