package com.appwbd.sraeu.services;

import com.appwbd.sraeu.entity.TipoUsuario;
import com.appwbd.sraeu.model.TipoUsuarioModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tipoUsuarioService")
public interface TipoUsuarioService {
    public abstract TipoUsuarioModel addTipoUsuario(TipoUsuarioModel tipoUsuarioModel);

    public abstract List<TipoUsuarioModel> listAllTipos();

    public abstract TipoUsuario findTipoUsuarioById(int id);

    public abstract TipoUsuarioModel findTipoUsuarioByTipoUsuarioModel(int id);

    public abstract void removeTipoUsuario(int id);
}
