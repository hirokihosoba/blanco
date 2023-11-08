package blanco.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import blanco.domain.DomainService;

@Controller
public class IndexController {
	
	private DomainService domainService;
	
	public IndexController(DomainService ｄomainService) {
		this.domainService = ｄomainService;
	}
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("message", domainService.salude());
		return "index";
	}
}