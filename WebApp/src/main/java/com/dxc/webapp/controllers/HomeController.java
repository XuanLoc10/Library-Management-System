package com.dxc.webapp.controllers;

import com.dxc.webapp.api.UserApi;
import com.dxc.webapp.model.User;
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
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			String username = auth.getName();
			User user= userApi.findByUser(username);
			model.addAttribute("user", user);
			return "library/HomePage";
		}
		return "library/HomePage";

	}

	@GetMapping("/home")
	public String homePage(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			String username = auth.getName();
			User user= userApi.findByUser(username);
			model.addAttribute("user", user);
			return "library/HomePage";
		}
		return "library/HomePage";
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "login/FormLogin";
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

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			String username = auth.getName();
			User user= userApi.findByUser(username);
			model.addAttribute("user", user);
			return "library/Ticket";
		}
		return "library/Ticket";
	}
}
