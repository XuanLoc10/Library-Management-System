package com.dxc.webapp.controllers;

import com.dxc.webapp.api.UserApi;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
@Autowired
	UserApi userApi;
	@GetMapping("/")
	public String Page(Model model) {
		return "library/HomePage";
	}


	@GetMapping("/home")
	public String homePage(Model model) {
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		if (auth != null) {
//			String username = auth.getName();
//			String userResponse = userApi.findByUser(username);
//			ObjectMapper objectMapper = new ObjectMapper();
//			//objectMapper.readValue(userResponse, User.class);
//			model.addAttribute("user", userResponse);
//			return "library/HomePage";
//		}
		return "library/HomePage";
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "login/FromLogin";
	}


	@GetMapping("/admin")
	public String userInfo(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
			return "admin/AdminPage";
		}
		return "library/HomePage";
	}

	@GetMapping("/ticket")
	public String ticket(Model model) {
		return "library/Ticket";
	}

	@GetMapping("/403")
	public String notPermitPage(Model model) {
		return "403";
	}

	@GetMapping("/error")
	public String errorPage(Model model) {
		return "redirect:403";
	}
}
