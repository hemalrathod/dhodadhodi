package in.hrsoftwares.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping(method=RequestMethod.GET)
	public String Index(Model m){
		m.addAttribute("Message", "From Model");
		m.addAttribute("By","HR Softwares");
		return "index";
	}
	@RequestMapping(value="Logout",method=RequestMethod.GET)
	public String Logout(){
		
		return "index";
	}
}
