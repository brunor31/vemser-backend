package services;

import entities.Conta;

public interface Movimentacao {

     boolean sacar(double montante);
     boolean depositar(double montante);
     boolean transferir(Conta conta, double montante);
}
