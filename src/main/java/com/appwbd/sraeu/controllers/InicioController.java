package com.appwbd.sraeu.controllers;

import com.appwbd.sraeu.constant.ViewConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class InicioController {

    @GetMapping("/inicio")
    public String inicio(){ return ViewConstant.INDEX; }
}
