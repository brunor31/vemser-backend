package application;

import entities.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Contato contato1 = new Contato("Celular", "51996031653", 1);
        Contato contato2 = new Contato("Telefone Fixo", "5135498100", 2);
        Contato contato3 = new Contato("Celular", "51995429246", 1);
        Contato contato4 = new Contato("Telefone Fixo", "5135452500", 2);
        Contato contato5 = new Contato("Celular", "51997283301", 1);
        Contato contato6 = new Contato("Telefone Fixo", "5135457788", 2);
        Endereco endereco1 = new Endereco(1, "Rudi Nelson Klein", 174, "Ritter", "95650-000", "Igrejinha", "RS", "BR");
        Endereco endereco2 = new Endereco(2, "Mal Deodoro da fonseca", 530, "Casa de pedra", "95650-000", "Igrejinha", "RS", "BR");
        Endereco endereco3 = new Endereco(1, "Anita Garibaldi", 1856, "Figueiras", "95650-000", "Igrejinha", "RS", "BR");
        Endereco endereco4 = new Endereco(2, "Sete de Julho", 53, "Vila Nova", "95650-000", "Igrejinha", "RS", "BR");
        Endereco endereco5 = new Endereco(1, "Rua das Pedreiras", 984, "SESI", "95650-000", "Igrejinha", "RS", "BR");
        Endereco endereco6 = new Endereco(1, "Rudi Nelson Klein", 174, "Ritter", "95650-000", "Igrejinha", "RS", "BR");
        ArrayList<Contato> contatosCliente1 = new ArrayList<>();
        ArrayList<Contato> contatosCliente2 = new ArrayList<>();
        ArrayList<Contato> contatosCliente3 = new ArrayList<>();
        Collections.addAll(contatosCliente1, contato1, contato2);
        Collections.addAll(contatosCliente2, contato3, contato4);
        Collections.addAll(contatosCliente3, contato5, contato6);
        ArrayList<Endereco> enderecoCliente1 = new ArrayList<>();
        ArrayList<Endereco> enderecoCliente2 = new ArrayList<>();
        ArrayList<Endereco> enderecoCliente3 = new ArrayList<>();
        Collections.addAll(enderecoCliente1, endereco1, endereco2);
        Collections.addAll(enderecoCliente2, endereco3, endereco4);
        Collections.addAll(enderecoCliente3, endereco5, endereco6);
        Cliente cliente1 = new Cliente("Bruno Rodrigues", "012.494.060-99", contatosCliente1, enderecoCliente1);
        Cliente cliente2 = new Cliente("Bernardo Boss", "817.653.370-03", contatosCliente2, enderecoCliente2);
        Cliente cliente3 = new Cliente("Maria Aparecida", "931.392.790-00", contatosCliente3, enderecoCliente3);
        ContaCorrente contaCorrente = new ContaCorrente(cliente1, "1842-X", "1845", 3000.00, 1000.00);
        ContaPoupanca contaPoupanca = new ContaPoupanca(cliente2, "62424874", "3641", 8750.00);
        ContaPagamento contaPagamento = new ContaPagamento(cliente3, "17412-X", "4412", 100.00);

        // Come??o dos testes

        // Imprimir informa????es do cliente1 (Nome, Cpf, Contatos e Endere??os)
        cliente1.imprimirCliente();
        cliente1.imprimirContatos();
        cliente1.imprimirEnderecos();
        System.out.println("-----------------------------");
        // Imprimir informa????es do cliente2 (Nome, Cpf, Contatos e Endere??os)
        cliente2.imprimirCliente();
        cliente2.imprimirContatos();
        cliente2.imprimirEnderecos();
        System.out.println("-----------------------------");
        // Imprimir informa????es do cliente3 (Nome, Cpf, Contatos e Endere??os)
        cliente3.imprimirCliente();
        cliente3.imprimirContatos();
        cliente3.imprimirEnderecos();
        System.out.println("-----------------------------");

        // Imprimir informa????es da conta corrente cliente 1
        contaCorrente.imprimir();
        System.out.println("-----------------------------");
        // Imprimir informa????es da conta poupan??a cliente 2
        contaPoupanca.imprimir();
        System.out.println("-----------------------------");
        // Imprimir informa????es da conta pagamento cliente 3
        contaPagamento.imprimir();
        System.out.println("-----------------------------");

        // Sacar da conta corrente
        System.out.printf("Saldo da conta corrente: R$%.2f\n", contaCorrente.getSaldo());
        contaCorrente.sacar(4050.00);
        System.out.printf("Saldo ap??s tentar sacar um valor acima do saldo + cheque especial: R$%.2f\n", contaCorrente.getSaldo());
        contaCorrente.sacar(1500.00);
        System.out.printf("Saldo da conta corrente ap??s o saque: R$%.2f\n", contaCorrente.getSaldo());
        // Dep??sito conta corrente
        contaCorrente.depositar(750.00);
        System.out.printf("Saldo da conta corrente ap??s o dep??sito: R$%.2f\n", contaCorrente.getSaldo());
        System.out.println("-----------------------------");

        //Sacar da conta poupan??a
        System.out.printf("Saldo da conta poupan??a: R$%.2f\n", contaPoupanca.getSaldo());
        contaPoupanca.sacar(1500.00);
        System.out.printf("Saldo da conta poupan??a ap??s o saque: R$%.2f\n", contaPoupanca.getSaldo());
        // Dep??sito conta poupan??a
        contaPoupanca.depositar(300.00);
        System.out.printf("Saldo da conta poupan??a ap??s o dep??sito: R$%.2f\n", contaPoupanca.getSaldo());
        System.out.println("-----------------------------");

        //Sacar conta Pagamento
        System.out.printf("Saldo da conta pagamento: R$%.2f\n", contaPagamento.getSaldo());
        contaPagamento.sacar(105.00);
        System.out.printf("Saldo da conta pagamento ap??s tentar sacar acima do permitido: R$%.2f\n", contaPagamento.getSaldo());
        contaPagamento.sacar(95.00);
        System.out.printf("Saldo da conta pagamento ap??s o saque de R$95.00 (adicionou a taxa) : R$%.2f\n", contaPagamento.getSaldo());
        // Dep??sito conta pagamento
        contaPagamento.depositar(150.00);
        System.out.printf("Saldo da conta pagamento ap??s o dep??sito: R$%.2f\n", contaPagamento.getSaldo());
        System.out.println("-----------------------------");

        //transf??ncias entre contas
        System.out.println("Saldo das contas antes das transfer??ncias");
        System.out.printf("Saldo da conta corrente: R$%.2f\n", contaCorrente.getSaldo());
        System.out.printf("Saldo da conta poupan??a: R$%.2f\n", contaPoupanca.getSaldo());
        System.out.printf("Saldo da conta pagamento: R$%.2f\n", contaPagamento.getSaldo());
        contaCorrente.transferir(contaPoupanca, 3500.00);
        System.out.printf("Saldo da conta corrente ap??s tentar transferir um valor acima do permitido: R$%.2f\n", contaCorrente.getSaldo());
        contaCorrente.transferir(contaPoupanca, 800.00);
        System.out.printf("Saldo da conta corrente ap??s transferir 800.00 para conta poupan??a: R$%.2f\n", contaCorrente.getSaldo());
        System.out.printf("Saldo da conta poupan??a ap??s receber um transfer??ncia da conta corrente: R$%.2f\n", contaPoupanca.getSaldo());
        contaPoupanca.transferir(contaCorrente, 3000.00);
        System.out.printf("Saldo da conta corrente ap??s receber 3000.00 da conta poupan??a: R$%.2f\n", contaCorrente.getSaldo());
        System.out.printf("Saldo da conta poupan??a ap??s transferir 3000.00 da conta corrente: R$%.2f\n", contaPoupanca.getSaldo());
        System.out.println("-----------------------------");

        //testes com as transfer??ncias da conta pagamento
        System.out.println("Saldo das contas antes da rodada de transfer??ncias");
        System.out.printf("Saldo da conta pagamento: R$%.2f\n", contaPagamento.getSaldo());
        System.out.printf("Saldo da conta corrente: R$%.2f\n", contaCorrente.getSaldo());
        contaPagamento.transferir(contaCorrente, 150.00);
        System.out.printf("Saldo da conta pagamento ap??s transferir 150.00: R$%.2f\n", contaPagamento.getSaldo());
        System.out.printf("Saldo da conta corrente ap??s receber 150.00: R$%.2f\n", contaCorrente.getSaldo());
        System.out.println("-----------------------------");
        System.out.println("FIM DOS TESTES");
    }
}
