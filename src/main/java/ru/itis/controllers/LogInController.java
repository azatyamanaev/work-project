package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.dto.LogInDto;
import ru.itis.services.LogInService;

@Controller
public class LogInController {

    @Autowired
    private LogInService logInService;

    @RequestMapping(value = "/logIn", method = RequestMethod.GET)
    public ModelAndView getLogInPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("logIn");
        return modelAndView;
    }

    //@RequestMapping(value = "/logIn", method = RequestMethod.POST)
    //public ModelAndView logIn(LogInDto form) {
    //    Boolean auth = logInService.logIn(form);
    //    ModelAndView modelAndView = new ModelAndView();
    //    if (auth) {
    //        modelAndView.setViewName("redirect:/profile");
    //    } else {
    //        modelAndView.setViewName("redirect:/logIn?error");
    //    }
    //    return modelAndView;
    //}
//
    //@RequestMapping(value = "/logIn?error", method = RequestMethod.GET)
    //public ModelAndView getLogInErrorPage() {
    //    return getLogInPage();
    //}
}
