package entities;

public class ContaCorrente {

    public Cliente cliente;
    public String numeroConta;
    public int agencia;
    public double saldo;
    public double chequeEspecial;

    public void imprimirContaCorrente(){
        System.out.printf("Cliente: %s, Número da conta: %s, Agência: %d, " +
                "Saldo: R$%.2f, Cheque especial: R$%.2f\n", cliente.nome, numeroConta, agencia, saldo, chequeEspecial);
    }
    public boolean sacar(double montate){
        if (montate <= (saldo + chequeEspecial) && montate > 0){
            saldo -= montate;
            return true;
        } else {
            return false;
        }
    }
    public boolean depositar(double montate){
        if (montate > 0) {
            saldo += montate;
            return true;
        } else {
            return false;
        }
    }
    public double retornarSaldoComChequeEspecial(){
        return saldo + chequeEspecial;
    }
    public boolean transferir(ContaCorrente contaCorrente, double valor){
        if (valor > 0 && valor <= (saldo + chequeEspecial)){
            saldo -= valor;
            contaCorrente.saldo += valor;
            return true;
        } else {
            return false;
        }
    }
}
