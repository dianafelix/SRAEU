package com.appwbd.sraeu.controllers;

import com.appwbd.sraeu.constant.ViewConstant;
import com.appwbd.sraeu.model.TipoUsuarioModel;
import com.appwbd.sraeu.services.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tipoUsuarios")
public class TipoUsuarioController {

    @Autowired
    @Qualifier("tipoUsuarioServiceImpl")
    private TipoUsuarioService tipoUsuarioService;

    private static final Log log = LogFactory.getLog(TipoUsuarioController.class);

    @GetMapping("/cancel")
    public String cancel(){
        return "redirect:/tipoUsuarios/showTipoUsuarios";
    }

    @GetMapping("/tipoUsuarioForm")
    public String redirectTipoUsuarioForm(Model model, @RequestParam(name = "id",required = false) int id){
        TipoUsuarioModel tipoUsuarioModel = new TipoUsuarioModel();
        if(id != 0)
            tipoUsuarioModel = tipoUsuarioService.findTipoUsuarioByTipoUsuarioModel(id);
        model.addAttribute("tipoUsuarioModel",tipoUsuarioModel);
        return ViewConstant.TIPOUSUARIO_FORM;
    }

    @PostMapping("/addtipousuario")
    public String addTipoUsuario(@ModelAttribute(name = "tipoUsuarioModel") TipoUsuarioModel tipoUsuarioModel, Model model){
        log.info("Method: addTipoUsuario() -- Params: "+tipoUsuarioModel.toString());
        if(tipoUsuarioService.addTipoUsuario(tipoUsuarioModel) != null)
            model.addAttribute("result",1);
        else
            model.addAttribute("result");
        return "redirect:/tipoUsuarios/showTipoUsuarios";
    }

    @GetMapping("/showTipoUsuarios")
    public ModelAndView showTipoUsuarios(){
        ModelAndView mav = new ModelAndView((ViewConstant.TIPOSUSUARIO));
        mav.addObject("tipoUsuarios",tipoUsuarioService.listAllTipos());
        return mav;
    }

    @GetMapping("/removeTipoUsuario")
    public ModelAndView removeTipoUsuario(@RequestParam(name = "id",required = true)int id){
        tipoUsuarioService.removeTipoUsuario(id);
        return showTipoUsuarios();
    }
}