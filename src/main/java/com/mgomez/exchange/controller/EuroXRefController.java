package com.mgomez.exchange.controller;

import com.mgomez.exchange.model.EuroXRef;
import com.mgomez.exchange.service.EuroXRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EuroXRefController {

    @Autowired
    private EuroXRefService euroXRefService;


    @ResponseBody
    @RequestMapping("/api/euroxref")
    public EuroXRef getEuroXRef() {
        return euroXRefService.getEuroXRef();
    }

    @ResponseBody
    @RequestMapping("/api/euroxref/{daysFromToday}")
    public EuroXRef getEuroXRefForDay(@PathVariable final Integer daysFromToday) {
        return euroXRefService.getEuroXRef(daysFromToday);
    }
}
