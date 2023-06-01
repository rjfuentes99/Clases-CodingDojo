package com.codingdojo.mostrarfecha.controladores;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@SpringBootApplication
public class ControladorFechaPlantillas {

    @GetMapping(value = "/")
    public String index(){
        return "index.jsp";
    }
    @GetMapping(value = "/date")
    public String date(Model model){ 
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE,dd MMM,yyy");
        String newdate = simpleDateFormat.format(new Date());
        model.addAttribute("Date", newdate);
        return "fecha.jsp";
    }
    @GetMapping(value = "/time")
    public String time(Model model){
        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("hh:mm a");
        String newtime = simpleTimeFormat.format(new Date());
        model.addAttribute("Time", newtime);
        return "hora.jsp";
    }
}
