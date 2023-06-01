package com.codingdojo.ricardo.herencia;

public interface ManejarVehiculo {
    
    int aumento = 2;

    //3 metodos que podemos usar
    //**Metodo Abstracto: Son aquellos que obligamos a nuestra clase a implementar
    // Metodo Default: Esos no neceistan ser implementados ya que los usamos en la interface
    // Metodos estaticos: Metodos que pertenecen a la interface

    abstract void acelerar();
    abstract void desacelerar();

}
