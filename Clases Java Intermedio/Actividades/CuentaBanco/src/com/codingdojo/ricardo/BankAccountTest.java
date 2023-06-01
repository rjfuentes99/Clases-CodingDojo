package com.codingdojo.ricardo;

public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount newAccount = new BankAccount();

        newAccount.depositarDinero(1000,"corriente");
        newAccount.retirarDinero(500,"corriente");
        newAccount.saldoTotal("corriente");

        newAccount.cuentasCreadas();
    }
}


