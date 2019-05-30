package com.appwbd.sraeu.model;

import lombok.Data;


@Data
public class AsistenciaModel {

    private int asistente_Id;
    private int evento_Id;
    private Integer mat;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String tipo;

    public AsistenciaModel(){

    }

    public AsistenciaModel(int asistente_Id, int evento_Id, Integer mat, String nombre, String apellido, String correo, String telefono, String tipo) {
        this.asistente_Id = asistente_Id;
        this.evento_Id = evento_Id;
        this.mat = mat;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    public int getAsistente_Id() {
        return asistente_Id;
    }

    public void setAsistente_Id(int asistente_Id) {
        this.asistente_Id = asistente_Id;
    }

    public int getEvento_Id() {
        return evento_Id;
    }

    public void setEvento_Id(int evento_Id) {
        this.evento_Id = evento_Id;
    }

    public Integer getMat() {
        return mat;
    }

    public void setMat(Integer mat) {
        this.mat = mat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }



    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
