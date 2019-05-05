package com.appwbd.sraeu.repository;

import com.appwbd.sraeu.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("usuarioRepository")
public interface UsuarioRepository extends JpaRepository<Usuario, Serializable> {
    public abstract Usuario findByUsername(String username);
}
