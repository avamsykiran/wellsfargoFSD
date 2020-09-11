package com.wellsfargo.fsd.swbd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@Scope("session")
public class FriendsController {

	private List<String> friends;
	
	@GetMapping("/friends")
	public ModelAndView showFriends() {
		return new ModelAndView("friends-page","frds",friends);
	}
	
	@GetMapping("/addFriend")
	public ModelAndView addFriends(@RequestParam("fnm")String friendName) {
		if(friends==null) {
			friends=new ArrayList<>();
		}
		
		friends.add(friendName);
		
		return new ModelAndView("friends-page","frds",friends);
	}
	
	@GetMapping("/removeFriend")
	public ModelAndView removeFriends(@RequestParam("fnm")String friendName) {
		if(friends!=null) {
			friends.remove(friendName);	
		}
		
		return new ModelAndView("friends-page","frds",friends);
	}
}
