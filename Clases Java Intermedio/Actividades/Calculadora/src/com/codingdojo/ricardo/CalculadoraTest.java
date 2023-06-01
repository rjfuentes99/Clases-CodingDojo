package com.codingdojo.ricardo;

public class CalculadoraTest {
    public static void main(String[] args) {
        Calculadora primeraOperacion = new Calculadora(10.5,"+",5.2);
        primeraOperacion.realizandoOperacion();
        primeraOperacion.resultadoTotal();

    }
}