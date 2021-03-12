package com.dxc.webapp.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("appName", "test");
		return "home";
	}

	@GetMapping("/login")
	public String login(Model model) {
		return "FromLogin";
	}

	@GetMapping("/info")
	public String userInfo(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
			return "admin";
		}

		return "userInfo";
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
