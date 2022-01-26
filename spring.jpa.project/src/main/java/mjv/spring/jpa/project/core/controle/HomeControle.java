package mjv.spring.jpa.project.core.controle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControle {
	
	@RequestMapping({"/", "/home"})
	public String home() {
		return "/home";
	}
}
