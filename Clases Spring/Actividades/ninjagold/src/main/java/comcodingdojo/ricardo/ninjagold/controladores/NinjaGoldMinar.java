package comcodingdojo.ricardo.ninjagold.controladores;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class NinjaGoldMinar {

	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@PostMapping("/oro")
	public String encontrar_oro(@RequestParam("lugar") String lugar,
								HttpSession session) {
		
		int gold = 0; //Comenzamos con 0 puntos
		ArrayList<String> activities = new ArrayList<String>(); //lista vacía de actividades
		
		SimpleDateFormat simpleFormat = new SimpleDateFormat("MMMM d Y h:mm a"); //Fecha y hora actual
		
		//Verificamos si ya hay algo en sesión
		if(session.getAttribute("gold")==null) {
			session.setAttribute("gold", gold); //si no hay nada inicializamos en 0
			session.setAttribute("activities", activities); //y lista vacía
		}else {
			gold = (int) session.getAttribute("gold"); //Si existe algo, nuestras variables las igualamos a sesión
			activities = (ArrayList<String>) session.getAttribute("activities");
		}
		
		
		int min = 0; //Monto mínimo
		int max = 0; //Monto máximo
		
		//Hacemos un switch (como if.. elseif) del lugar que se ingresó
		switch(lugar) {

			case "granja":
				min = 10;
				max = 20;
				break;
				
			case "cueva":
				min = 5;
				max = 10;
				break;
			
			case "casa":
				min = 2;
				max = 5;
				break;
			
			case "casino":
				min = -50;
				max = 50;
				break;
		}
		
		//Generamos el número aleatorio
		int amount = new Random().nextInt(max - min + 1) + min;
		gold += amount; //Agregamos el monto generado
		String mensaje = "";
		
		//Establecemos un mensaje
		if(amount>=0) {
			mensaje = "Entraste a "+lugar+" y ganaste "+amount+". "+simpleFormat.format(new Date());
		} else {
			mensaje = "Entraste a "+lugar+" y perdiste "+amount+". "+simpleFormat.format(new Date());
		}
		
		//Agregamos el mensaje a las actividades
		activities.add(mensaje);
		
		//Agregamos el mensaje y el oro a sesión
		session.setAttribute("activities", activities);
		session.setAttribute("gold", gold);
		return "redirect:/";
		
	}
}

