package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping("/")
	public String home() {
		
		return "home.jsp";
	}
	@RequestMapping("/addAlien")
	public String addAlien(Alien alien) {
		
		repo.save(alien);
		return "home.jsp";
		
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView  getAlien(@RequestParam int aid) {
		
		ModelAndView mv =new ModelAndView("showAlien.jsp");
		
		Alien alien = repo.findById(aid).orElse(new Alien());
		
		System.out.println(repo.findByLang("java"));
		System.out.println(repo.findByAidGreaterThan(102));
		System.out.println(repo.findByLangSorted("java"));
		mv.addObject(alien);
		return mv;
		
	}
	
	@RequestMapping("/aliens/{aid}")
	@ResponseBody
	public String getAliens(@PathVariable("aid") int aid) {
		return repo.findById(aid).toString();
	}
	
	
	
}



