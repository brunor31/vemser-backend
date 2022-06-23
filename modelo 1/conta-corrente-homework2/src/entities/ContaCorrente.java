package entities;

import services.Impressao;

public class ContaCorrente extends Conta implements Impressao {

    private Double chequeEspecial;

    public ContaCorrente() {
    }

    public ContaCorrente(Cliente cliente, String numeroConta, String agencia, Double saldo, Double chequeEspecial) {
        super(cliente, numeroConta, agencia, saldo);
        this.chequeEspecial = chequeEspecial;
    }

    public void setChequeEspecial(Double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }

    public double retornarSaldoComChequeEspecial(){
        return getSaldo() + chequeEspecial;
    }
    @Override
    public boolean sacar(double montate){
        if (montate <= retornarSaldoComChequeEspecial() && montate > 0){
            setSaldo(getSaldo() - montate);
            return true;
        } else {
            return false;
        }
    }
    @Override // Reescrevi o método também para considerar o valor de cheque especial, não foi pedido
    public boolean transferir(Conta conta, double valor){
        if (valor > 0 && valor <= retornarSaldoComChequeEspecial()){
            setSaldo(getSaldo() - valor);
            conta.setSaldo(conta.getSaldo() + valor);
            return true;
        } else {
            return false;
        }
    }
    @Override
    public void imprimir() {
        System.out.printf("Nome do titular da conta: %s" +
                "\nNúmero da conta: %s" +
                "\nAgência: %s" +
                "\nSaldo: R$%.2f" +
                "\nCheque Especial: R$%.2f\n", getCliente().getNome(),
                getNumeroConta(),
                getAgencia(),
                getSaldo(),
                chequeEspecial);
    }
}
