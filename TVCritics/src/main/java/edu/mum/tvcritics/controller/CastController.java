package edu.mum.tvcritics.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.tvcritics.entity.Cast;
import edu.mum.tvcritics.service.CastService;

@Controller
public class CastController {
	
	@Autowired
	CastService castService;
	
	@RequestMapping(value = "/addCast",method=RequestMethod.GET)
	public String addCast(){
		return "addCast";
	}
	
	@RequestMapping(value = "/addCast",method=RequestMethod.POST)
	public String saveCast(Cast cast){
		System.out.println(cast.getName());
		castService.createCast(cast);
		return "redirect:/addCast";
	}
	
	@RequestMapping(value = "/castList",method=RequestMethod.GET)
	public String getCastList(Model model){
		List<Cast> castList = new ArrayList<>();
		castList = castService.getCastList();
		model.addAttribute("casts",castList);	
		return "castList";
	}
}
