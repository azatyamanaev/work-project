package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.dto.SignUpDto;
import ru.itis.services.SignUpService;

@Controller
public class SignUpController {

    @Autowired
    private SignUpService signUpService;

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public ModelAndView getSignUpPage(Authentication authentication) {
        ModelAndView modelAndView = new ModelAndView();
        if (authentication == null) {
            modelAndView.setViewName("redirect:/");
        } else {
            modelAndView.setViewName("signUp");
        }
        return modelAndView;
    }

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public ModelAndView signUp(SignUpDto form) {
        signUpService.signUp(form);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/confirm");
        return modelAndView;
    }
}
