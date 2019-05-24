package com.appwbd.sraeu.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="tipo_usuario")
public class TipoUsuario {

    @Id
    @GeneratedValue
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "privilegios")
    private String privilegios;

    @OneToMany(mappedBy = "tipoUsuario")
    private List<Usuario> usuarios;
}
