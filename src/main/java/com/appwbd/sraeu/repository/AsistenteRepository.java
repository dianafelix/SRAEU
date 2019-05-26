package com.appwbd.sraeu.repository;

import com.appwbd.sraeu.entity.Asistente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("asistenteRepository")
public interface AsistenteRepository extends JpaRepository<Asistente, Serializable> {
    public abstract Asistente findById(int id);
    public abstract Asistente findByMat(int mat);
}
