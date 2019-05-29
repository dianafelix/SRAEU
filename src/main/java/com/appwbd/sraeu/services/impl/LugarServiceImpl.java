package com.appwbd.sraeu.services.impl;

import com.appwbd.sraeu.component.LugarConverter;
import com.appwbd.sraeu.entity.Lugar;
import com.appwbd.sraeu.model.LugarModel;
import com.appwbd.sraeu.repository.LugarRepository;
import com.appwbd.sraeu.services.LugarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("lugarServiceImpl")
public class LugarServiceImpl implements LugarService {

    @Autowired
    @Qualifier("lugarRepository")
    private LugarRepository lugarRepository;

    @Autowired
    @Qualifier("lugarConverter")
    private LugarConverter lugarConverter;

    @Override
    public LugarModel addLugar(LugarModel lugarModel){
        //Aquí nos pide una entidad, por lo tanto tenemos que transformar el eventoModel a entidad
        Lugar temp=lugarConverter.convertLugarToModel2Lugar(lugarModel);
        Lugar lugar = lugarRepository.save(temp);
        return lugarConverter.convertLugar2LugarModel(lugar);
    }

    @Override
    public List<LugarModel> listAllLugares() {
        List<Lugar> lugares = lugarRepository.findAll();
        List<LugarModel> lugaresModel = new ArrayList();
        for(Lugar lugar : lugares){
            lugaresModel.add(lugarConverter.convertLugar2LugarModel(lugar));

        }
        return lugaresModel;
    }

    @Override
    public Lugar findLugarById(int id) {
        return lugarRepository.findById(id);
    }

    public LugarModel findLugarByIdModel(int id){
        return lugarConverter.convertLugar2LugarModel(findLugarById(id));
    }

    @Override
    public LugarModel convertLugar2LugarModel(Lugar lugar) {
        return lugarConverter.convertLugar2LugarModel(lugar);
    }

    @Override
    public Lugar convertLugarModel2Lugar(LugarModel lugarModel) {
        return lugarConverter.convertLugarToModel2Lugar(lugarModel);
    }

    @Override
    public void removeLugar(int id) {
        Lugar lugar  = findLugarById(id);
        if(lugar != null){
            lugarRepository.delete(findLugarById(id));
        }
    }
}
