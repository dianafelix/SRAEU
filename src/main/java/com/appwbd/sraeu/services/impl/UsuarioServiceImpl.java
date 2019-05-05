package com.appwbd.sraeu.services.impl;

import com.appwbd.sraeu.component.UsuarioConverter;
import com.appwbd.sraeu.entity.Usuario;
import com.appwbd.sraeu.model.UsuarioModel;
import com.appwbd.sraeu.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.appwbd.sraeu.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service("usuarioServiceImpl")
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    @Qualifier("usuarioRepository")
    private UsuarioRepository usuarioRepository;

    @Autowired
    @Qualifier("usuarioConverter")
    private UsuarioConverter usuarioConverter;

    @Override
    public UsuarioModel addUser(UsuarioModel usuarioModel) {
       Usuario temp = usuarioConverter.convertUsuarioModel2Usuario(usuarioModel);
       Usuario usuario = usuarioRepository.save(temp);

       return usuarioConverter.convertUsuario2UsuarioModel(usuario);
    }

    @Override
    public List<UsuarioModel> listAllUsers() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioModel> usuariosModel = new ArrayList();

        for(Usuario usuario : usuarios)
            usuariosModel.add(usuarioConverter.convertUsuario2UsuarioModel(usuario));

        return usuariosModel;
    }

    @Override
    public Usuario findUserByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public UsuarioModel findUserByUsernameModel(String username) {
        return usuarioConverter.convertUsuario2UsuarioModel(findUserByUsername(username));
    }
}
