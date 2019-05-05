package com.appwbd.sraeu.controllers;

import com.appwbd.sraeu.constant.ViewConstant;
import com.appwbd.sraeu.model.UsuarioModel;
import com.appwbd.sraeu.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    @Qualifier("usuarioServiceImpl")
    private UsuarioService usuarioService;

    private static final Log log = LogFactory.getLog(UsuarioController.class);

    @GetMapping("/cancel")
    public String cancel() {
        return "redirect:/usuarios/showUsuarios";
    }

    @GetMapping("/usuarioForm")
    public String redirectUserForm(Model model, @RequestParam(name = "username", required = false) String username) {
        UsuarioModel usuarioModel = new UsuarioModel();
        if(!username.equals("none"))
            usuarioModel = usuarioService.findUserByUsernameModel(username);
        model.addAttribute("usuarioModel",usuarioModel);
        return ViewConstant.USUARIO_FORM;
    }

    @PostMapping("/addusuario")
    public String addUser(@ModelAttribute(name = "userModel") UsuarioModel usuarioModel, Model model) {
        log.info("Method: addUser() -- Params: " + usuarioModel.toString());
        if (usuarioService.addUser(usuarioModel) != null)
            model.addAttribute("result", 1);
        else
            model.addAttribute("result", 0);
        return "redirect:/usuarios/showUsuarios";
    }

    @GetMapping("/showUsuarios")
    public ModelAndView showUsers() {
        ModelAndView mav = new ModelAndView(ViewConstant.USUARIOS);
        mav.addObject("usuarios",usuarioService.listAllUsers());
        return mav;
    }
}
