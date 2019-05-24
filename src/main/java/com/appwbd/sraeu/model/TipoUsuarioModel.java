package com.appwbd.sraeu.model;

import com.appwbd.sraeu.entity.Usuario;
import lombok.Data;

import java.util.List;

@Data
public class TipoUsuarioModel {

    private int id;
    private String tipo;
    private String[] privilegios;
    private List<String> usuarios;

    public TipoUsuarioModel(){}

    public TipoUsuarioModel(int id, String tipo, String[] privilegios, List<String> usuarios) {
        this.id = id;
        this.tipo = tipo;
        this.privilegios = privilegios;
        this.usuarios = usuarios;
    }
}
