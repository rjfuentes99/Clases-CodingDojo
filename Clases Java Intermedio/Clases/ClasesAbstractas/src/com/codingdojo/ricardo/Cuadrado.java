package com.codingdojo.ricardo;

public class Cuadrado extends Figura{

    private double longitud;

    public Cuadrado(double longitud) {
        this.longitud = longitud;
    }

    public double area(){
        return this.longitud*this.longitud;
    }
    
}
