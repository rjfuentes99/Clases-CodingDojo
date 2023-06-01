package com.codingdojo.ricardo;

import java.util.Random;

public class BankAccount {
    /*Variables*/
    private String numeroDeCuenta = "";
    private double saldoCuentaCorriente = 0;
    private double saldoCuentaAhorro = 0;
    private static int numeroCuentasCreadas = 0;
    private static double saldoTotal = 10000;

    /* Getters and setters*/
    public double getSaldoCuentaAhorro() {
        return saldoCuentaAhorro;
    }

    public double getSaldoCuentaCorriente() {
        return saldoCuentaCorriente;
    }

    public BankAccount() {
        //this.numeroDeCuenta = numeroAleatorio();
        this.numeroDeCuenta = generarCuenta();
        numeroCuentasCreadas++;
    }
    private String generarCuenta() {
        String numCta = "";

        Random rdm = new Random();
        for (int i = 0; i < 10; i++) {
            numCta += String.valueOf(rdm.nextInt(9));
        }

        return numCta;
    }
    public void depositarDinero(double dinero, String tipoDeCuenta) {

        if (tipoDeCuenta.equals("ahorro")) {
            this.saldoCuentaAhorro += dinero;
            System.out.println("Se ha depositado en la cuenta de ahorro + $" + dinero);

        } else if (tipoDeCuenta.equals("corriente")) {
            this.saldoCuentaCorriente += dinero;
            System.out.println("Se ha depositado en la cuenta corriente + $" + dinero);

        } else {
            System.out.println("especifique en que tipo de cuenta quiere interactuar <ahorro> o <corriente>");
        }
        saldoTotal += dinero;
    }

    public void retirarDinero(double dinero, String tipoDeCuenta) {
        if (tipoDeCuenta.equals("ahorro")) {
            if (dinero <= saldoCuentaAhorro) {
                this.saldoCuentaAhorro -= dinero;
                saldoTotal -= dinero;
                System.out.println("Se retiro de la cuenta de ahorro - $" + dinero);
            } else {
                System.out.println("fondos insuficiente en la cuenta de ahorro!");
            }
        } else {
            System.out.println("especifique en que tipo de cuenta quiere interactuar <ahorro> o <corriente>");

        }
        if (tipoDeCuenta.equals("corriente")) {
            if (dinero <= saldoCuentaCorriente) {
                this.saldoCuentaCorriente -= dinero;
                saldoTotal -= dinero;
                System.out.println("Se retiro de la cuenta corriente - $" + dinero);
            } else {
                System.out.println("fondos insuficiente en la cuenta corriente!");
            }
        } else {
            System.out.println("especifique en que tipo de cuenta quiere interactuar <ahorro> o <corriente>");

        }

    }

    public void saldoTotal(String tipoDeCuenta) {
        if (tipoDeCuenta.equals("ahorro")) {
            System.out.println("Saldo total en la cuenta de ahorro: " + saldoCuentaAhorro);
        } else if (tipoDeCuenta.equals("corriente")) {
            System.out.println("Saldo total en la cuenta de ahorro: " + saldoCuentaCorriente);
        } else {
            System.out.println("especifique en que tipo de cuenta quiere interactuar <ahorro> o <corriente>");

        }
    }
    public void cuentasCreadas() {
        System.out.println(numeroCuentasCreadas);
    }

}

