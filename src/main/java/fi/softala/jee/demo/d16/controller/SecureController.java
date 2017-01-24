package fi.softala.jee.demo.d16.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/secure")
public class SecureController {

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String paasivu(Model model) {
		return "secure/main";
	}
	
	@RequestMapping(value = "/lisaa", method = RequestMethod.GET)
	public String lisaaPaino(Model model) {
		return "secure/lisaa";
	}

}