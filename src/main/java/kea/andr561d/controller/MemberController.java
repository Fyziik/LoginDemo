package kea.andr561d.controller;

import kea.andr561d.model.Member;
import kea.andr561d.repository.IMemberRepository;
import kea.andr561d.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    @Autowired
    IMemberRepository imr;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/")
    public String login(@ModelAttribute Member member, Model model) {
        //System.out.println(member.getEmail());
        //System.out.println(member.getPassword());
        model.addAttribute("members", imr.readAll());
        return "secret";
    }

}
