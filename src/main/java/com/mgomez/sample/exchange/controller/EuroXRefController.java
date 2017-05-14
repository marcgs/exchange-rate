package com.mgomez.sample.exchange.controller;

import com.mgomez.sample.exchange.model.Envelope;
import com.mgomez.sample.exchange.service.EuroXRefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EuroXRefController {

    @Autowired
    private EuroXRefService euroXRefService;

    @ResponseBody
    @RequestMapping("/api/euroxref")
    public Envelope EuroXRefController() {
        return euroXRefService.getEnvelope();
    }
}
