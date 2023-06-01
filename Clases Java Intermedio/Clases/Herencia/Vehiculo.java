package com.codingdojo.ricardo.herencia;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Vehiculo {

	private int año;
	private String marca;
	private String modelo;
	private String color;
	private int ruedas;
	protected int velocidad = 0;

	public Vehiculo(){

	}

	public Vehiculo(String color) {
		this.color = color;
	}

	public Vehiculo(String color, int ruedas) {
		this.color = color;
		this.ruedas = ruedas;
	}

	public Vehiculo(int año, String marca, String modelo, String color, int ruedas) {
		this.año = año;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.ruedas = ruedas;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getRuedas() {
		return ruedas;
	}

	public void setRuedas(int ruedas) {
		this.ruedas = ruedas;
	}
	public void imprimir(){
		System.out.print("Año:"+this.año+" Marca:"+this.marca+" Modelo:"+this.modelo+" Color:"+this.color+" Ruedas:"+this.ruedas);
	}

}
