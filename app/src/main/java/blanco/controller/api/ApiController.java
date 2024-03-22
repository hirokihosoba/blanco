package blanco.controller.api;

import java.util.Objects;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blanco.controller.api.dto.GetParamIn;
import blanco.controller.api.dto.MessageOut;
import blanco.controller.api.dto.MessagePostIn;
import blanco.controller.api.dto.MessagePostOut;

@RestController
@RequestMapping("api")
public class ApiController {
	
	 @GetMapping("/test")
	 public MessageOut test() {
		 MessageOut out = new MessageOut();
		 out.setContent("How are you?");
		 return out;
	 }

	 @GetMapping("/error")
	 public MessageOut error() throws Exception {
		 throw new Exception("エラー！！！！！！");
	 }

	 @GetMapping("/param")
	 public MessageOut param(@ModelAttribute GetParamIn in) {
		 MessageOut out = new MessageOut();
		 out.setResult1(in.getParam1());
		 out.setResult2(in.getParam2());
		 return out;
	 }

	 @PostMapping("/post")
	 public MessagePostOut testPost(@RequestBody MessagePostIn in) {
		MessagePostOut out = new MessagePostOut();
		 if (Objects.equals(in.getTitle(), "sample")){
			out.setResult("exito");
		 }else {
			out.setResult("falla");
		 }

		 return out;
	 }
}
