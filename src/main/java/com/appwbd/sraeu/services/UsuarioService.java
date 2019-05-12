package com.appwbd.sraeu.services;

import com.appwbd.sraeu.entity.Usuario;
import com.appwbd.sraeu.model.UsuarioModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("usuarioService")
public interface UsuarioService {
    public abstract UsuarioModel addUser(UsuarioModel usuarioModel);

    public abstract List<UsuarioModel> listAllUsers();

    public abstract Usuario findUserByUsername(String username);

    public abstract UsuarioModel findUserByUsernameModel(String username);

    public abstract void removeUser(String username);
}
