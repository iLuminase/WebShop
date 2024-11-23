package com.phatlaptrinh.ShopLapTrinh.controller;

import com.phatlaptrinh.ShopLapTrinh.dto.UserDTO;
import com.phatlaptrinh.ShopLapTrinh.service.LoginService;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.*;

@Controller
public class HelloController {

    private LoginService loginService = new LoginService();
    @RequestMapping(value = "/", method = RequestMethod.GET)

    public ModelAndView hello()
    {
        ModelAndView mav = new ModelAndView("hello");
        mav.addObject("model", "Test model Phatlaptrinh deeptrai!");
        return mav;
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "message", required = false) String message) {
        ModelAndView mav = new ModelAndView("/login");
        mav.addObject("model", message);
        return mav;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView loginProcess(@ModelAttribute("model") UserDTO model) {
        String message = loginService.loginProcess(model.getUserName(), model.getPassword());
        return new ModelAndView("redirect:/login?message="+message);
    }
}
