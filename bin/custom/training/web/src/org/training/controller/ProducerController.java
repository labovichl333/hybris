package org.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.data.ProducerData;
import org.training.facade.ProducerFacade;

import javax.annotation.Resource;

@Controller
@RequestMapping("/producer")
public class ProducerController {
    @Resource
    private ProducerFacade producerFacade;

    @GetMapping
    public String showProducerPage(@RequestParam String code, Model model) {
        ProducerData producerData = producerFacade.getProducer(code);
        model.addAttribute("producer", producerData);
        return "producer";
    }

}
