package com.appwbd.sraeu.controllers;

import com.appwbd.sraeu.constant.ViewConstant;
import com.appwbd.sraeu.model.TipoUsuarioModel;
import com.appwbd.sraeu.model.UsuarioModel;
import com.appwbd.sraeu.services.SecurityService;
import com.appwbd.sraeu.services.TipoUsuarioService;
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

    @Autowired
    @Qualifier("securityServiceImpl")
    private SecurityService securityService;

    @Autowired
    @Qualifier("tipoUsuarioServiceImpl")
    private TipoUsuarioService tipoUsuarioService;

    private static final Log log = LogFactory.getLog(UsuarioController.class);

    @GetMapping("/cancel")
    public String cancel() {return "redirect:/usuarios/showUsuarios";}

    @GetMapping("/usuarioForm")
    public String redirectUserForm(Model model, @RequestParam(name = "username", required = false) String username) {
        UsuarioModel usuarioModel = new UsuarioModel();
        boolean b = true;
       String currentUser = securityService.findLoggedInUsername();

        if(!username.equals("none")) {
            usuarioModel = usuarioService.findUserByUsernameModel(username);
            b = false;
        }

        model.addAttribute("usuarioModel",usuarioModel);
        model.addAttribute("tipos",tipoUsuarioService.listAllTipos());
        model.addAttribute("b",b);
        model.addAttribute("currentUser", currentUser);
        return ViewConstant.USUARIO_FORM;
    }

    @PostMapping("/addusuario")
    public String addUser(@ModelAttribute(name = "userModel") UsuarioModel usuarioModel, Model model) {
        log.info("Method: addUser() -- Params: " + usuarioModel.toString());
        usuarioModel.setEnable(true);
        if (usuarioService.addUser(usuarioModel) != null)
            model.addAttribute("result", 1);
        else
            model.addAttribute("result", 0);
        return "redirect:/usuarios/showUsuarios";
    }

    @GetMapping("/showUsuarios")
    public ModelAndView showUsers() {
        ModelAndView mav = new ModelAndView(ViewConstant.USUARIOS);
        String currentUser = securityService.findLoggedInUsername();
        System.out.println(currentUser);

        mav.addObject("usuarios",usuarioService.listAllUsers());
        mav.addObject("currentUser", currentUser);


        return mav;
    }

    @GetMapping("/removeUsuario")
    public ModelAndView removeUsuario(@RequestParam(name = "username",required = true)String username){
        usuarioService.removeUser(username);
        return showUsers();
    }
}
