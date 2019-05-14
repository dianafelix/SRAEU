package com.appwbd.sraeu.component;

import com.appwbd.sraeu.model.LugarModel;
import com.appwbd.sraeu.entity.Lugar;
import org.springframework.stereotype.Component;



@Component("lugarConverter")
public class LugarConverter {

    public Lugar convertLugarToModel2Lugar(LugarModel lugarModel){
        Lugar lugar = new Lugar();
        lugar.setId(lugarModel.getId());
        lugar.setNombre(lugarModel.getNombre());
        lugar.setDireccion(lugarModel.getDireccion());
        return lugar;
    }

    public LugarModel convertLugar2LugarModel(Lugar lugar) {
        LugarModel lugarModel = new LugarModel();
        lugarModel.setId(lugar.getId());
        lugarModel.setNombre(lugar.getNombre());
        lugarModel.setDireccion(lugar.getDireccion());
        return lugarModel;
    }
}
