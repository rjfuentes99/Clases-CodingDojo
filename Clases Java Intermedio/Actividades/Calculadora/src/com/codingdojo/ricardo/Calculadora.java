package com.codingdojo.ricardo;

public class Calculadora {

    private Double numeroUno = 0.0;
    private Double numeroDos = 0.0;
    private Double resultado = 0.0;

    private String operador = "";
    public Calculadora(){

    }

    public Calculadora(Double numeroUno, String operador, Double numeroDos) {
        this.numeroUno = numeroUno;
        this.operador = operador;
        this.numeroDos = numeroDos;
    }
    public Double getNumeroUno() {
        return numeroUno;
    }

    public void setNumeroUno(Double numeroUno) {
        this.numeroUno = numeroUno;
    }

    public Double getNumeroDos() {
        return numeroDos;
    }

    public void setNumeroDos(Double numeroDos) {
        this.numeroDos = numeroDos;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    public void realizandoOperacion(){
        if (getOperador().equals("+")) {

            Double total = getNumeroDos() + getNumeroUno();
            setResultado(total);
        }else if (getOperador().equals("-")){

            Double total = getNumeroDos() - getNumeroUno();
            setResultado(total);
        }
    }

    public void resultadoTotal(){
        System.out.println(getResultado());
    }

}

