package blanco.controller.view;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public interface MainController {

	@GetMapping("/main")
	public String main(Model model);
}