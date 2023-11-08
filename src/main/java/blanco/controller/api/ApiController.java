package blanco.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blanco.controller.api.model.MessageOut;

@RestController
@RequestMapping("api")
public class ApiController {
	
	 @GetMapping("/test")
	 public MessageOut test() {
		 MessageOut out = new MessageOut();
		 out.setContent("How are you?");
		 return out;
	 }
}