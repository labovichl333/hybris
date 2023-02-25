package org.training.controller;

import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.model.ModelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.training.data.ContactRequestData;
import org.training.facade.ContactRequestFacade;
import org.training.model.ContactRequestModel;

import javax.annotation.Resource;

@Controller
@RequestMapping("/contactRequest")
public class ContactRequestController {
    @Resource
    private ContactRequestFacade contactRequestFacade;
    @Resource
    private ModelService modelService;

    @GetMapping
    public String showPage(@RequestParam(required = false) String sender, Model model) {
        ContactRequestData contactRequest = null;
        if (sender != null) {
            try {
                contactRequest = contactRequestFacade.getContactRequestDetails(sender);
            } catch (final UnknownIdentifierException e) {
                // OK, nothing found
            }
        }

        model.addAttribute("contactRequest", contactRequest);
        return "contactRequest";
    }

    @PostMapping
    public String sendMessage(@RequestParam(required = false) String newSender,
                              @RequestParam(required = false) String newMessage) {
        ContactRequestModel contactRequest = new ContactRequestModel();
        modelService.attach(contactRequest);
        if (newSender != null) {
            contactRequest.setSender(newSender);
        }
        if (newMessage != null) {
            contactRequest.setMessage(newMessage);
        }
        modelService.save(contactRequest);
        return "redirect:/contactRequest/";
    }

}