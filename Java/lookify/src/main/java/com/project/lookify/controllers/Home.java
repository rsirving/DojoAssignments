package com.project.lookify.controllers;
import com.project.lookify.models.Song;
import com.project.lookify.services.SongService;
import java.util.List;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class Home{
	//Member variables go here
	private final SongService songService;

	public Home(SongService songService){
		this.songService = songService;
	}
	
	@RequestMapping("")
	public String index(){
		return "index";
	}

	@RequestMapping("/dashboard")
	public String dashboard(Model model){
		model.addAttribute("songs", songService.allSongs());
		return "dashboard";
	}

	@RequestMapping("/songs/new")
	public String newSong(){
		return "newsong";
	}

	@PostMapping("/songs/new")
	public String newSong(@Valid @ModelAttribute("song") Song song, BindingResult result){
		if (result.hasErrors()){
			return "redirect:/dashboard";
		} else {
			songService.addSong(song);
			return "redirect:/dashboard";
		}
	}

	@RequestMapping("/songs/{id}")
	public String showSong(Model model, @PathVariable("id") Long id){
		Song song = songService.findSong(id);
		if (song != null) {
			model.addAttribute("song", song);
			return "onesong";
		} else {
			return "redirect:/dashboard";
		}
	}

	@RequestMapping("/songs/edit/{id}")
	public String editSong(@PathVariable("id") Long id, Model model){
		Song song = songService.findSong(id);
		if (song != null){
			model.addAttribute("song", song);
			return "editsong";
		} else {
			return "redirect:/dashboard";
		}
	}

	@PostMapping("/songs/edit/{id}")
	public String editSong(@PathVariable("id") Long id, @Valid @ModelAttribute("song") Song song, BindingResult result){
		if (result.hasErrors()){
			return "editsong";
		} else {
			songService.updateSong(song);
			return "redirect:/songs/id";
		}
	}

	@RequestMapping("/songs/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id){
		songService.destroySong(id);
		return "redirect:/dashboard";
	}
}
