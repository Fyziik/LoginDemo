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

import javax.servlet.http.HttpSession;

@Controller
public class MemberController {

    @Autowired
    IMemberRepository imr;

    @GetMapping("/")
    public String index(HttpSession session, Model model) {

        if (session.getAttribute("isLoggedIn") != null) {
            model.addAttribute("members", imr.readAll());
            return "secret";
        }
        return "index";
    }

    @PostMapping("/")
    public String login(@ModelAttribute Member member, Model model, HttpSession session) {
        // Check if credentials is in the arraylist
        Member m = imr.read(member.getEmail());
        if (m != null) {
            if (member.getPassword().equals(m.getPassword())) {
                session.setAttribute("isLoggedIn", "yes");
                model.addAttribute("members", imr.readAll());
                return "secret";
            }
        }
        return "index";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("isLoggedIn");
        return "index";
    }

}
