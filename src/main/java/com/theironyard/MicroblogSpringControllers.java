package com.theironyard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class MicroblogSpringControllers {
    public static final String SESSION_USERNAME = "username";
    public static Map<String, Message> messages = new HashMap<>();

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session){
        String username = (String)session.getAttribute(SESSION_USERNAME);
        model.addAttribute("username", username);
        model.addAttribute("messages", messages.values());
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String username){
        session.setAttribute(SESSION_USERNAME, username);
        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(HttpSession session, String content){
        String username = (String)session.getAttribute(SESSION_USERNAME);
        Message m = new Message(content, username);
        messages.put(m.getId(), m);
        return "redirect:/";
    }

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String deleteMessage(String id){
        messages.remove(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/message", method = RequestMethod.GET)
    public String messageDetail(Model model, String id){
        Message message = messages.get(id);
        model.addAttribute("message", message);
        return "message";
    }

    @RequestMapping(path = "/update-message", method = RequestMethod.POST)
    public String updateMessage(String id, String content){
        Message message = messages.get(id);
        message.setContent(content);
        return "redirect:/message?id="+id;
    }
}
