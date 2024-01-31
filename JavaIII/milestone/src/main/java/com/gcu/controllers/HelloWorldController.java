package com.gcu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloWorldController 
{
	/**
	 * Simple Hello world Controller that returns a string to the response body
	 * @return Hello World Test String
	 */
	@GetMapping("/test1")
	@ResponseBody
	public String printHello()
	{
		// return a string in the response Body (Must use @ResponseBody)
		return "Hello World!";
	}
	
	/**
	 * Simple Hello World Controller that returns a View Name along with a model attribute named message.
	 * invoke using /test2
	 * @param model Model to bind to the View
	 * @return View name hello	
	 */
	@GetMapping("/test2")
	public String printHello(Model model)
	{
		// return a Model with an attribute named message and return a view named hello
		model.addAttribute("message", "Hello Spring MVC Framework!");
		return "test";
	}
	
	
	@GetMapping("/test3")
	public ModelAndView printHello1()
	{
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", new String("Hello World from ModelAndView!"));
		mv.addObject("message2", new String("Another Hello World from ModelAndView!"));
		mv.setViewName("test");
		return mv;
	}
	
	
	@GetMapping("/test4")
	public String printHello(@RequestParam("message") String message, Model model)
	{
		model.addAttribute("message", message);
		return "test";
	}

}
