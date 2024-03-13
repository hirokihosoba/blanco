package blanco.controller.view;

import org.springframework.ui.Model;


public interface SignController {
	
	public String signUp(Model model);

    public String signIn(Model model);

    public String signOut(Model model);
}