package com.theironyard;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by darionmoore on 12/27/16.
 */
@org.springframework.stereotype.Controller
public class Controller {
    public static final String SESSION_USERNAME = "userName";
    public static ArrayList<Message> messages= new ArrayList<>();
//    In your controller, create a route for /
//    It should take the model and the session as arguments
//    It should read the username from the session and add it to the model
//    It should return the home template
    @RequestMapping(path="/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session){
        String userName = (String)session.getAttribute(SESSION_USERNAME);
        model.addAttribute("name", userName);
        return "home";
    }
//    In your controller, create a route for /login
//    It should take the session and the username as arguments
//    It should save the username to the session
//    It should return a redirect to /
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName){
        session.setAttribute(SESSION_USERNAME, userName);
        return "redirect:/";
    }

//    In your controller, create a route for /add-message
//    It should take the message text as an argument
//    It should create a Message object and add it to the arraylist (for the id, do something like messages.size() + 1)
//    It should return a redirect to /



}
