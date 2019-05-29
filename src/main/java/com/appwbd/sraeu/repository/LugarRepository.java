package com.appwbd.sraeu.repository;

import com.appwbd.sraeu.entity.Lugar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("lugarRepository")
public interface LugarRepository extends JpaRepository<Lugar, Serializable> {
    public abstract Lugar findById(int id);
}