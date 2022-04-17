package com.vector.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.vector.app.model.User;
import com.vector.app.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BasicController {
    @Autowired
    private UserRepository userRepo;

    @RequestMapping(value="/",method=RequestMethod.GET)
    public String getHome() {
        return "index";
    }

    @RequestMapping(value="/signup",method=RequestMethod.GET)
    public String getSignUp(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        if(session.getAttribute("currentUser") != null){
            model.addAttribute("user", session.getAttribute("currentUser"));
            return "home";
        }
        return "signup";    
    }

    @RequestMapping(value="/signup",method=RequestMethod.POST)
    public String registerUser(@ModelAttribute User user) {
        
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        userRepo.save(user);
        return "login";
    }

    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String getLogin(HttpServletRequest request,Model model) {
        HttpSession session = request.getSession();
        if(session.getAttribute("currentUser") != null){ 
            model.addAttribute("user", session.getAttribute("currentUser"));
            return "home";
        }
        return "login";
    }

    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String doLogin(@ModelAttribute User user,Model model,HttpServletRequest request) {
        User currentUser = userRepo.findByUserNameAndPassword(user.getUserName(),DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        HttpSession session = request.getSession();

        if(currentUser !=null) {
            session.setAttribute("currentUser", currentUser);
            model.addAttribute("user", session.getAttribute("currentUser"));
            
            return "home";
        }
        model.addAttribute("error", "user not found");
        return "login";
    }

    @RequestMapping(value="/logout",method=RequestMethod.POST)
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("currentUser", null);
        return "login";
    }
    @RequestMapping(value="/logout",method=RequestMethod.GET)
    public String getLogOut(HttpServletRequest request) {
        return logout(request);
    }
}
