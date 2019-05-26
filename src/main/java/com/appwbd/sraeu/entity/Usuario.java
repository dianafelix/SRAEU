package com.appwbd.sraeu.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @Column(name="username", unique = true, nullable = false)
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="enable")
    private boolean enable;

    @ManyToOne
    @JoinColumn(nullable = true)
    private TipoUsuario tipoUsuario;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Usuario(){

    }
}
