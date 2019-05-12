package com.appwbd.sraeu.repository;

import com.appwbd.sraeu.entity.TipoUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("tipoUsuarioRepository")
public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Serializable> {
    public abstract TipoUsuario findById(int id);
}