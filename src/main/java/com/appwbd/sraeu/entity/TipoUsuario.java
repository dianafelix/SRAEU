package com.appwbd.sraeu.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="tipoUsuario")
public class TipoUsuario {
    @Id
    @GeneratedValue
    @Column(name = "tipo_usuario", unique = true, nullable = false)
    private int tipoUsuarioId;

    @Column(name = "tipo", nullable = false)
    private String tipo;
}
