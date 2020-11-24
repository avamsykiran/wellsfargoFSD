package com.wellsfargo.batch7.sbwd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/friends")
@Scope("session")
public class FriendsController {

	private List<String> friends = new ArrayList<>();
	
	@GetMapping
	public ModelAndView listFriendsAction() {
		return new ModelAndView("friends/friends-page","friends",friends);
	}
	
	@GetMapping("/add")
	public ModelAndView addFriendAction(@RequestParam("fnm") String friend) {
		friends.add(friend);
		return new ModelAndView("friends/friends-page","friends",friends);
	}
	
	@GetMapping("/remove")
	public ModelAndView removeFriendAction(@RequestParam("fnm") String friend) {
		friends.remove(friend);
		return new ModelAndView("friends/friends-page","friends",friends);
	}
}
