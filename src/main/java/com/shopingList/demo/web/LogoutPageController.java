package com.shopingList.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutPageController {
    @GetMapping("/users/logout")
    public String userLogout (HttpSession httpSession){
        httpSession.invalidate();
        return "index";
    }
}
