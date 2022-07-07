package entities;

import services.Impressao;

public class ContaPagamento extends Conta implements Impressao {

    public static Double TAXA_SAQUE = 4.25;

    public ContaPagamento() {
    }

    public ContaPagamento(Cliente cliente, String numeroConta, String agencia, Double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    @Override
    public boolean sacar(double montate){
        montate += TAXA_SAQUE;
        if (montate <= getSaldo() && montate > 0){
            setSaldo(getSaldo() - montate);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public boolean transferir(Conta conta, double valor){
        if (valor > 0 && valor <= getSaldo()){
            sacar(valor - TAXA_SAQUE);
            conta.depositar(valor);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public void imprimir() {
        System.out.printf("Nome do titular: %s" +
                "\nNúmero da conta: %s" +
                "\nAgência: %s" +
                "\nSaldo: R$%.2f\n",
                getCliente().getNome(), getNumeroConta(), getAgencia(), getSaldo());
    }
}
