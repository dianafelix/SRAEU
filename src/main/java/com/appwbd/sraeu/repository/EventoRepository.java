package com.appwbd.sraeu.repository;

import com.appwbd.sraeu.entity.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("eventoRepository")
public interface EventoRepository extends JpaRepository<Evento, Serializable> {
    public abstract Evento findById(int id);
}

