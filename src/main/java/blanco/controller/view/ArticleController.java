package blanco.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public interface ArticleController {

	@GetMapping("/article")
	public String index(Model model);
}