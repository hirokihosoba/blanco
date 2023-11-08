package blanco.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import blanco.domain.DomainService;

@Controller
public class IndexController {
	
	private final Logger logger = LoggerFactory.getLogger("appLogger");
	
	private DomainService domainService;
	
	public IndexController(DomainService ｄomainService) {
		this.domainService = ｄomainService;
	}
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("message", domainService.salude());
		logger.info("ログテスト");
		return "index";
	}
}