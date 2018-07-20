package com.boraji.tutorial.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class HelloController {

   @RequestMapping("/index")
   public String index() {
      return "index";
   }

   @RequestMapping(value = "/hello" ,method=RequestMethod.GET)
   public String sayHello(@RequestParam("name") String name,@RequestParam("email")String email, Model model) {
      model.addAttribute("name", name);
      model.addAttribute("email",email);
      return "hello";
   }
   @RequestMapping(value = "/hello2" ,method=RequestMethod.GET)
   public  String sayhello2(@RequestParam("email")String email,@RequestParam("name") String name,Model model){
      model.addAttribute("name",name);
      model.addAttribute("email",email);
      return "hello";

   }
}
