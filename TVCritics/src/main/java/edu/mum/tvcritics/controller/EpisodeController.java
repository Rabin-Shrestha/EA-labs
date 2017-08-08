package edu.mum.tvcritics.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.tvcritics.entity.Episode;
import edu.mum.tvcritics.service.EpisodeService;

@Controller
public class EpisodeController {
	
	@Autowired
	EpisodeService episodeService;
	
	@RequestMapping(value = "/episode")
	public String redirectRoot() {
		return "redirect:/episodeList"; 
	}
	
	@RequestMapping(value = "/addEpisode",method=RequestMethod.GET)
	public String addEpisode(){
		return "episode/addEpisode";
	}
	
	@RequestMapping(value = "/addEpisode",method=RequestMethod.POST)
	public String saveEpisode(Episode Episode){
		System.out.println("<----Aired date----->"+Episode.getAiredDate());
		episodeService.createEpisode(Episode);
		return "redirect:/episodeList";
	}
	
	@RequestMapping(value = "/episodeList",method=RequestMethod.GET)
	public String getEpisodeList(Model model){
		List<Episode> episodeList = new ArrayList<>();
		episodeList = episodeService.getEpisodeList();
		model.addAttribute("episodes",episodeList);	
		return "episode/episodeList";
	}
	
	@RequestMapping(value="/episodeEdit/{id}", method=RequestMethod.GET)
	public String getEpisode(@PathVariable int id, Model model) {
		model.addAttribute("episode", episodeService.getEpisodebyId(id));
		return "episode/episodeDetail";
	}
	
	@RequestMapping(value="/episodeEdit/{id}", method=RequestMethod.POST)
	public String updateEpisode(Episode episode, @PathVariable int id) {
		episode.setId(id);
		episodeService.EpisodeUpdate(episode);
		return "redirect:/episodeList";
	}
	
	@RequestMapping(value="/episodeEdit/delete", method=RequestMethod.POST)
	public String delete(int episodeId) {
		episodeService.EpisodeDelete(episodeId);
		return "redirect:/episodeList";
	}
	
}
