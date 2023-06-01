package com.codingdojo.ricardo.herencia;

import org.springframework.boot.SpringApplication;

public class Aplicacion {
    
    public static void main(String[] args) {

		//Vehiculo barco = new Vehiculo(2015, "Barco 123", "ModeloBarquil", "blanco",0);
		//barco.imprimir();

		Auto auto1 = new Auto(2010, "honda", "civic", "rojo", 4, "ABC123");
		auto1.imprimir();
		auto1.acelerar();
		auto1.acelerar();
		auto1.desacelerar();

		Bicicleta biciBMX = new Bicicleta(2021, "BMX", "GT100", "Cromado verde", 2);
		biciBMX.imprimir();
		biciBMX.acelerar();
		biciBMX.acelerar();
		biciBMX.acelerar();

		biciBMX.desacelerar();
	}
}
