package br.com.biblioteca.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping
public class IndexController {
	@Autowired
	private ServletContext servletContext;

	@RequestMapping("/index")
	String home() {
		return "index";
	}

	@RequestMapping("/doc")
	public RedirectView getApi() {
		return new RedirectView(servletContext.getContextPath() + "/swagger-ui.html");
	}

}
