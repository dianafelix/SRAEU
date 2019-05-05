package com.appwbd.sraeu.entity;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="tipo")
    private String tipo;



    public Usuario(String username, String password, String tipo ) {
        this.username = username;
        this.password = password;
        this.tipo = tipo;
    }

    public Usuario(){

    }
}
