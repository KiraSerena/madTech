package com.example.demo.controller;

import com.example.demo.model.Kunde;
import com.example.demo.repo.KundeRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {


    KundeRepo kundeRepo = new KundeRepo();


    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/user")
    public String user() {
        return "user";
    }

    @RequestMapping(value = "/admin")
    public String admin() {
        return "admin";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/403")
    public String Error403() {
        return "403";
    }

    @RequestMapping(value = "/brings")
    public String brings() {
        return "brings";
    }

    @RequestMapping(value = "/covers")
    public String covers() {
        return "covers";
    }

    @RequestMapping(value = "/about")
    public String about() {
        return "about";
    }


    @RequestMapping(value = "/caps")
    public String caps() {
        return "caps";
    }


    @RequestMapping(value = "/mouthpiece")
    public String mouthPiece() {
        return "mouthpiece";
    }

    @RequestMapping(value = "/signup")
    public String signUp() {
        return "signup";
    }

    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("kunde", new Kunde());
        return "signup";
    }

    @PostMapping("/signup")
    public String create(@ModelAttribute Kunde kunde, Model model) {
        kundeRepo.insert(kunde);
        model.addAttribute("kunde", kundeRepo.findAll());
        return "redirect:/";

    }

}