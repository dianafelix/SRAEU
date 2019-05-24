package com.appwbd.sraeu.services;

import com.appwbd.sraeu.entity.Lugar;
import com.appwbd.sraeu.model.LugarModel;

import java.util.List;

public interface LugarService{
    public abstract LugarModel addLugar(LugarModel lugarModel);

    public abstract List<LugarModel> listAllLugares();

    public abstract Lugar findLugarById(int id);

    public abstract void removeLugar(int id);

    public abstract LugarModel findLugarByIdModel(int id);
}