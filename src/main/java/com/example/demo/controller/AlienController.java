package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.model.Alien;

@Controller

public class AlienController {
	
	@Autowired
	AlienRepo repo;
	
    @RequestMapping("/")
	
	public String home() 
    {
		System.out.println("hi");
		return "home.jsp";
	}
    
   
    //Post request sending some data from client to server
    @PostMapping(path={"/Alien"},consumes= {"application/json"})//it means server will accept data from client only in json format
    
    public String addAlien(@RequestBody Alien alien)
    //if we are sending raw data like here in json format from client we need to use @RequestBody
    {
	    repo.save(alien);
	    //we want to return the data itself to the the client so use return alien and use Alien in return type of function
    	return "home.jsp";
    }
    
    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int aid)
    {
    	ModelAndView mv=new ModelAndView("showAlien.jsp");
    	Alien alien=repo.findById(aid).orElse(new Alien());
    	mv.addObject(alien);
	    //repo.save(alien);
    	return mv;
    }
    
    @RequestMapping(path="/Aliens",produces= {"application/xml"})//to restrict the data to user only in this format and spring will now only support xml
    @ResponseBody
    public List<Alien> getAliens()
    {
    	
    	return repo.findAll();
    }
    
    //get request
    @RequestMapping("/Alien/{aid}")
    @ResponseBody 
    public Optional<Alien> Alienbyid(@PathVariable("aid") int aid)
    {
    	
    	return repo.findById(aid);
    	
    	//ans will be in json format
    	//return repo.findById(aid).Tostring();
    	//ans will be in string format
    }
    
    //update data
    @RequestMapping("/updateAlien/{aid}")
    public ModelAndView updateAlien(@PathVariable("aid") int aid)
    {
    	
    	ModelAndView mv=new ModelAndView("showAlien.jsp");
    	Alien alien1=repo.findById(alien.getAid()).orElse(new Alien());
    	alien1=alien;
    	repo.save(alien1);
    	
    	
    	mv.addObject(alien1);
	    //repo.save(alien);
    	return mv;
    }
    
  //delete data
    @DeleteMapping("/Alien/{aid}")
    public Alien deleteAlien(@PathVariable("aid") int aid)
    {
    	
    	
    	Alien alien1=repo.findById(aid).orElse(null);
    	repo.delete(alien1);
    	return alien1;
    	
    }



    
   
}
