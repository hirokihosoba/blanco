package blanco.controller.view;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public interface ArticleController {

	@GetMapping("/article")
	public String index(Model model);
}