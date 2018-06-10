package com.example.demo.controller;

import com.example.demo.model.Kunde;
import com.example.demo.model.UserRole;
import com.example.demo.model.Users;
import com.example.demo.repo.KundeKartotek;
import com.example.demo.repo.UserKartotek;
import com.example.demo.repo.UserRoleKartotek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @Autowired
    KundeKartotek kundeKartotek = new KundeKartotek();

    @Autowired
    UserKartotek userKartotek = new UserKartotek();

    @Autowired
    UserRoleKartotek userRoleKartotek = new UserRoleKartotek();




    @RequestMapping(value = "/")
    public String home() {
        return "frontPage";
    }

    @RequestMapping(value = "/user")
    public String user() {
        return "user";
    }

    @RequestMapping(value = "/admin")
    public String admin() { return "admin"; }

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


    @GetMapping("/signup")
    public String signUp(Model model) {
        model.addAttribute("kunde", new Kunde());
        model.addAttribute("users", new Users());
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute Kunde kunde, Users users, UserRole userRole, Model model) {
        kundeKartotek.insert(kunde);
        model.addAttribute("kunde", kundeKartotek.findAll());
        userKartotek.insert(users);
        model.addAttribute("users", userKartotek.findAll());

        userRoleKartotek.insert(userRole);
        model.addAttribute("userRole", userRoleKartotek.findAll());


        return "home";

    }

}