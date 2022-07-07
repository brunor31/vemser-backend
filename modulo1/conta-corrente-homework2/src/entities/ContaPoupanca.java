package entities;

import services.Impressao;

public class ContaPoupanca extends Conta implements Impressao {

    public static final double JUROS_MENSAL = 1.01;

    public ContaPoupanca() {
    }

    public ContaPoupanca(Cliente cliente, String numeroConta, String agencia, Double saldo) {
        super(cliente, numeroConta, agencia, saldo);
    }

    public void creditarTaxa(){
        setSaldo(getSaldo() * JUROS_MENSAL);
    }
    @Override
    public void imprimir() {
        System.out.printf("Nome do titular da conta: %s" +
                        "\nNúmero da conta: %s" +
                        "\nAgência: %s" +
                        "\nSaldo: R$%.2f\n", getCliente().getNome(),
                getNumeroConta(),
                getAgencia(),
                getSaldo());
    }
}
