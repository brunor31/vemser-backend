package entities;

import services.Movimentacao;
public abstract class Conta implements Movimentacao {

    private Cliente cliente;
    private String numeroConta;
    private String agencia;
    private Double saldo;


    public Conta() {
    }
    public Conta(Cliente cliente, String numeroConta, String agencia, Double saldo) {
        this.cliente = cliente;
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean sacar(double montate){
        if (montate <= saldo && montate > 0){
            saldo -= montate;
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean depositar(double montate){
        if (montate > 0) {
            saldo += montate;
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean transferir(Conta conta, double valor){
        if (valor > 0 && valor <= saldo){
            saldo -= valor;
            conta.saldo += valor;
            return true;
        } else {
            return false;
        }
    }
}
