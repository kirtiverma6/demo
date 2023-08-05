package com.kirti.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalTime;

@Controller
public class OutputController {

    @RequestMapping("/")
    public ModelAndView index (Model model) {
        ModelAndView modelAndView = new ModelAndView();
        LocalTime currentTime = LocalTime.now();
        int hour = currentTime.getHour();
        String greeting;

        if (hour >= 0 && hour < 12) {
            greeting = " Good morning ";
        } else {
            greeting = " Good afternoon ";
        }
        model.addAttribute("message", greeting + " Kirti Verma Welcome to Comp367");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
