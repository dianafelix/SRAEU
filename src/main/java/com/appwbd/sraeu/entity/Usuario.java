package com.appwbd.sraeu.entity;

import lombok.Data;
import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name="usuario")
public class Usuario {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name="usuario")
    private String usuario;
    @Column(name="password")
    private String password;
    @Column(name="nivel")
    private String nivel;



    public Usuario(int id, String usuario, String password, String nivel ) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.nivel = nivel;
    }

    public Usuario(){

    }
}
