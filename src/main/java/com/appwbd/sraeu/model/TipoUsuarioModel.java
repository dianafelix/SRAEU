package com.appwbd.sraeu.model;

import com.appwbd.sraeu.entity.Usuario;
import lombok.Data;

import java.util.List;

@Data
public class TipoUsuarioModel {

    private int id;
    private String tipo;
    private List<Usuario> usuarios;

    public TipoUsuarioModel(){}

    public TipoUsuarioModel(int id, String tipo, List<Usuario> usuarios) {
        this.id = id;
        this.tipo = tipo;
        this.usuarios = usuarios;
    }
}
