package com.appwbd.sraeu.services.impl;

import com.appwbd.sraeu.component.TipoUsuarioConverter;
import com.appwbd.sraeu.entity.TipoUsuario;
import com.appwbd.sraeu.model.TipoUsuarioModel;
import com.appwbd.sraeu.repository.TipoUsuarioRepository;
import com.appwbd.sraeu.services.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("tipoUsuarioServiceImpl")
public class TipoUsuarioServiceImpl implements TipoUsuarioService {

    @Autowired
    @Qualifier("tipoUsuarioRepository")
    private TipoUsuarioRepository tipoUsuarioRepository;

    @Autowired
    @Qualifier("tipoUsuarioConverter")
    private TipoUsuarioConverter tipoUsuarioConverter;


    @Override
    public TipoUsuarioModel addTipoUsuario(TipoUsuarioModel tipoUsuarioModel) {
        TipoUsuario temp = tipoUsuarioConverter.convertTipoUsuarioModel2TipoUsuario(tipoUsuarioModel);
        TipoUsuario tipoUsuario = tipoUsuarioRepository.save(temp);

        return tipoUsuarioConverter.convertTipoUsuario2TipoUsuarioModel(tipoUsuario);
    }

    @Override
    public List<TipoUsuarioModel> listAllTipos() {
        List<TipoUsuario> tipoUsuarios = tipoUsuarioRepository.findAll();
        List<TipoUsuarioModel> tipoUsuarioModels = new ArrayList();

        for(TipoUsuario tipoUsuario:tipoUsuarios)
            tipoUsuarioModels.add(tipoUsuarioConverter.convertTipoUsuario2TipoUsuarioModel(tipoUsuario));

        return tipoUsuarioModels;
    }

    @Override
    public TipoUsuario findTipoUsuarioById(int id) {

        return tipoUsuarioRepository.findById(id);
    }

    @Override
    public TipoUsuarioModel findTipoUsuarioByTipoUsuarioModel(int id) {

        return tipoUsuarioConverter.convertTipoUsuario2TipoUsuarioModel(findTipoUsuarioById(id));
    }

    @Override
    public void removeTipoUsuario(int id) {
        TipoUsuario tipoUsuario = findTipoUsuarioById(id);
        if(tipoUsuario != null)
            tipoUsuarioRepository.delete(findTipoUsuarioById(id));
    }
}
