package ru.itis.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import ru.itis.dto.LogInDto;
import ru.itis.dto.TokenDto;
import ru.itis.services.LogInService;

@RestController
public class LogInController {

    @Autowired
    private LogInService logInService;

    @PreAuthorize("permitAll()")
    @RequestMapping(value = "/logIn", method = RequestMethod.GET)
    public ModelAndView getLogInPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("logIn");
        return modelAndView;
    }

    @RequestMapping(value = "/logIn", method = RequestMethod.POST)
    public ResponseEntity<TokenDto> logIn(@RequestBody LogInDto logInData) {
        return ResponseEntity.ok(logInService.logIn(logInData));
    }
}
