package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MicroblogSpringControllers {
    public static final String SESSION_USERNAME = "username";
    public static List<Message> messages = new ArrayList<>();

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session){
        String username = (String)session.getAttribute(SESSION_USERNAME);
        model.addAttribute("username", username);
        model.addAttribute("messages", messages);
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String username){
        session.setAttribute(SESSION_USERNAME, username);
        return "redirect:/";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(String content){
        Message m = new Message(messages.size()+1, content);
        messages.add(m);
        System.out.println(m.getContent());
        return "redirect:/";
    }

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String deleteMessage(int id){
        messages.remove(id-1);
        return "redirect:/";
    }
}
