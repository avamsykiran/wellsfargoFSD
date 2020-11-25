package com.wellsfargo.batch5.sbwdd.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wellsfargo.batch5.sbwdd.exception.LibraryException;
import com.wellsfargo.batch5.sbwdd.model.GenreModel;
import com.wellsfargo.batch5.sbwdd.service.GenreService;

@Controller
@RequestMapping("/genres")
public class GenreController {

	@Autowired
	private GenreService gService;
	
	@GetMapping
	public ModelAndView genresAction() throws LibraryException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("genres/genres-page");
		mv.addObject("genres", gService.getAll());
		mv.addObject("genre", new GenreModel());
		return mv;
	}
	
	@PostMapping("/add")
	public ModelAndView addGenresAction(@ModelAttribute("genre") @Valid GenreModel genre,BindingResult result) throws LibraryException {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("genres/genres-page");
		if(!result.hasErrors()) {
			gService.add(genre);
			mv.addObject("genre", new GenreModel());			
		}else {
			mv.addObject("genre", genre);
		}
		mv.addObject("genres", gService.getAll());
		
		return mv;
	}
	
	@GetMapping("/delete")
	public String deleteGenreAction(@RequestParam("gid") int genreId) throws LibraryException {
		gService.delete(genreId);
		
		return "redirect:/genres";
	}
}
