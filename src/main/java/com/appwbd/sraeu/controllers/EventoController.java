package com.appwbd.sraeu.controllers;


import com.appwbd.sraeu.constant.ViewConstant;
import com.appwbd.sraeu.entity.Lugar;
import com.appwbd.sraeu.model.AsistenteModel;
import com.appwbd.sraeu.model.EventoModel;
import com.appwbd.sraeu.model.LugarModel;
import com.appwbd.sraeu.repository.LugarRepository;
import com.appwbd.sraeu.services.AsistenteService;
import com.appwbd.sraeu.services.EventoService;
import com.appwbd.sraeu.services.LugarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    @Qualifier("eventoServiceImpl")
    private EventoService eventoService;

    @Autowired
    @Qualifier("asistenteServiceImpl")
    private AsistenteService asistenteService;

    @Autowired
    @Qualifier("lugarServiceImpl")
    private LugarService lugarService;

    private List<LugarModel> lugares;


    private static final Log log = LogFactory.getLog(EventoController.class);

    @GetMapping("/cancel")
    public String cancel() {
        return "redirect:/eventos/showEventos";
    }

    @GetMapping("/eventoForm")
    public String redirectEventoForm(Model model, @RequestParam(name = "id", required = false) int id) {
        EventoModel eventoModel = new EventoModel();
        lugares = new ArrayList<>();
        List<LugarModel> lugarModels = lugarService.listAllLugares();
        boolean b = true;
        if(id != 0) {
            eventoModel = eventoService.findEventoByIdModel(id);
            b = false;
        }
        model.addAttribute("eventoModel",eventoModel);
        model.addAttribute("lugarModels", lugarModels);
        model.addAttribute("b",b);
        return ViewConstant.EVENTO_FORM;
    }

    @PostMapping("/addevento")
    public String addEvento(@ModelAttribute(name = "eventoModel") EventoModel eventoModel, Model model)throws Exception {
        log.info("Method: addEvento() -- Params: " + eventoModel.toString());
        if (eventoService.addEvento(eventoModel) != null)
            model.addAttribute("result", 1);
        else
            model.addAttribute("result", 0);
        return "redirect:/eventos/showEventos";
    }

    @GetMapping("/showEventos")
    public ModelAndView showEventos() {
        ModelAndView mav = new ModelAndView(ViewConstant.EVENTOS);
        mav.addObject("eventos",eventoService.listAllEventos());
        return mav;
    }

    @GetMapping("/removeEvento")
    public ModelAndView removeEvento(@RequestParam(name = "id",required = true)int id) {
        eventoService.removeEvento(id);
        return showEventos();
    }

    @GetMapping("/calendario")
    public String calendario(Model model) {
        return ViewConstant.CALENDARIO;
    }

    @RequestMapping(value = "/EventosDelDia", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void getEventosDelDia(@RequestBody String fecha) {
        log.info("Method getEventosDelDia() -- Inicio,  Fecha a buscar:" + fecha);
        Date fechaB;
        List<EventoModel> eventosDelDia = new ArrayList();
        try {
            fechaB = new SimpleDateFormat("dd-MM-yyyy").parse(fecha);
            for(EventoModel evento : eventoService.listAllEventos()) {
                Date fechaI = new SimpleDateFormat("dd-MM-yyyy").parse(evento.getFechaI());
                Date fechaF = new SimpleDateFormat("dd-MM-yyyy").parse(evento.getFechaF());
                if (fechaI.equals(fechaB) || fechaF.equals(fechaB)) {
                    eventosDelDia.add(evento);
                }
            }
        } catch (ParseException e) {

        }
        log.info("Method getEventosDelDia() -- Fin, Cantidad de eventos: " + eventosDelDia.size());
    }
}
