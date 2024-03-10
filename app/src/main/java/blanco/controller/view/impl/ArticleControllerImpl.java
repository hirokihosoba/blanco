package blanco.controller.view.impl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import blanco.controller.view.ArticleController;
import blanco.domain.impl.CustomerDomainServiceImpl;
import blanco.domain.model.Customer;
import blanco.service.ArticleService;

@Controller
public class ArticleControllerImpl implements ArticleController {
	
	ArticleService articleService;
	
	CustomerDomainServiceImpl customerDomainServiceImpl;
	
	public ArticleControllerImpl(ArticleService articleService,CustomerDomainServiceImpl customerDomainServiceImpl) {
		this.articleService = articleService;
		this.customerDomainServiceImpl = customerDomainServiceImpl;
	}

	@Override
	public String index(Model model) {
		Customer customer = customerDomainServiceImpl.getUser("suzuki"); 
		model.addAttribute("message", customer.getName() + " " + customer.getPassword() + " hot reloaded");
		return "article/index";
	}

	
}
