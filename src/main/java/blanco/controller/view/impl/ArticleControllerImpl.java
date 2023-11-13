package blanco.controller.view.impl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import blanco.controller.view.ArticleController;
import blanco.service.ArticleService;

@Controller
public class ArticleControllerImpl implements ArticleController {
	
	ArticleService articleService;
	
	public ArticleControllerImpl(ArticleService articleService) {
		this.articleService = articleService;
	}

	@Override
	public String index(Model model) {
		model.addAttribute("message", articleService.getArticle());
		return "article/index";
	}
}
