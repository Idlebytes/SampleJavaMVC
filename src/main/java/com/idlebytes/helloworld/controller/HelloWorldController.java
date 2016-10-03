package com.idlebytes.helloworld.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@EnableAutoConfiguration
public class HelloWorldController {
	
	String message = "Welcome to Spring MVC!";
	
	@RequestMapping("/hello")
	public ModelAndView showMessage( @RequestParam(value = "name", required = false, defaultValue = "World") String name){
		System.out.println("Inside controller...");
		
		ModelAndView mv = new ModelAndView("helloworld");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}
	
	@RequestMapping("/blog")
	public ModelAndView replyBlog(@RequestParam(value = "blogname", required = false, defaultValue = "idlebytes.blogspot.com") String blogname){
		ModelAndView mv = new ModelAndView("blogname");
		mv.addObject("blogname", blogname);
		return mv;
	}
	
	@RequestMapping("/")
    String home() {
        return "Hello World!";
    }
	
	public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloWorldController.class, args);
    }

}
