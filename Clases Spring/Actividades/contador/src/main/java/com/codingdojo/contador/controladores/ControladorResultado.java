package com.codingdojo.contador.controladores;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControladorResultado {
	@RequestMapping("/counter")
	public String results(HttpSession session) {
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
        Integer count = (Integer) session.getAttribute("count");
		count ++;
		session.setAttribute("count", count);
		return "contador.jsp";
	}
}
