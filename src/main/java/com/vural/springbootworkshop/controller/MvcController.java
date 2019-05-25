package com.vural.springbootworkshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcController {

    @RequestMapping({"/index", "/"})
    String indexPage(){
        return "index";
    }

}
