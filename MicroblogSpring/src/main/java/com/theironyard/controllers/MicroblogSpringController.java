package com.theironyard.controllers;

import com.theironyard.models.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by sparatan117 on 12/27/16.
 */
@Controller
public class MicroblogSpringController {
    public static final String SESSION_USER_NAME = "username";
    static ArrayList<Message> messages = new ArrayList<>();

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
       String username = (String)session.getAttribute(SESSION_USER_NAME);
       model.addAttribute("name", username);
       model.addAttribute("messages", messages);
       return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String username){
        session.setAttribute(SESSION_USER_NAME, username);
        return "redirect:/";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(String text, Integer id){
        Message a = new Message(messages.size() + 1, text);
        messages.add(a);
        return "redirect:/";
    }

    @RequestMapping(path = "/delete-message", method = RequestMethod.POST)
    public String deleteMessage(Integer id){

        Message mess = null;
        for (Message m: messages){
            if(m.getId() == id){
                mess = m;
            }
        }
        messages.remove(mess);
        return "redirect:/";
    }
}
