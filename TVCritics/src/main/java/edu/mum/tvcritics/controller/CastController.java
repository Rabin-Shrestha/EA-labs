package edu.mum.tvcritics.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.mum.tvcritics.entity.Cast;
import edu.mum.tvcritics.exception.NoSuchResourceException;
import edu.mum.tvcritics.service.CastService;

@Controller
public class CastController {
	
	@Autowired
	CastService castService;
	
	@RequestMapping(value = "/cast")
	public String redirectRoot() {
		return "redirect:/castList"; 
	}
	
	@RequestMapping(value = "/addCast",method=RequestMethod.GET)
	public String addCast(){
		return "cast/addCast";
	}
	
	@RequestMapping(value = "/addCast",method=RequestMethod.POST)
	public String saveCast(Cast cast){
		castService.createCast(cast);
		return "redirect:/castList";
	}
	
	@RequestMapping(value = "/castList",method=RequestMethod.GET)
	public String getCastList(Model model){
		List<Cast> castList = new ArrayList<>();
		castList = castService.getCastList();
		model.addAttribute("casts",castList);
		return "cast/castList";
	}
	
	@RequestMapping(value="/castEdit/{id}", method=RequestMethod.GET)
	public String getCast(@PathVariable int id, Model model) {
		model.addAttribute("cast", castService.getCastbyId(id));
		return "cast/castDetail";
	}
	
	@RequestMapping(value="/castEdit/{id}", method=RequestMethod.POST)
	public String updateCast(Cast cast, @PathVariable int id) {
		cast.setId(id);
		castService.castUpdate(cast);
		
		return "redirect:/castList";
	}
	
	@RequestMapping(value="/castEdit/delete", method=RequestMethod.POST)
	public String delete(int castId) {
		castService.castDelete(castId);
		return "redirect:/castList";
	}
	
	@ExceptionHandler(NoSuchResourceException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handle(Exception e, Model model) {
		System.out.println("<-------error------->");
		model.addAttribute("e", e);
		return "cast/noSuchResource";
	}
}
