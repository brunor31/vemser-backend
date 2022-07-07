package application;

import entities.*;

import java.util.Locale;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Contato contato1 = new Contato("Celular", "51996031653", 1);
        Contato contato2 = new Contato("Telefone Fixo", "5135498100", 2);
        Contato contato3 = new Contato("Celular", "51982495757", 1);
        Contato contato4 = new Contato("Telefone Fixo", "5135452549", 2);
        Endereco endereco1 = new Endereco(1, "Rudi Nelson klein", 174, "Ritter", "95650-000", "Igrejinha", "Rs", "BR");
        Endereco endereco2 = new Endereco(2, "Mal Deodoro da Fonseca", 530, "Casa de Pedra", "9560-000", "Igrejinha", "RS", "BR");
        Endereco endereco3 = new Endereco(1, "Anita Garibaldi", 1856, "Garibaldi", "9560-000", "Igrejinha", "RS", "BR");
        Endereco endereco4 = new Endereco(2, "Rua das Pedreiras", 1683, "Vila Nova", "9560-000", "Igrejinha", "RS", "BR");
        Cliente cliente1 = new Cliente("Bruno", "682.887.290-88", new Contato[]{contato1, contato2}, new Endereco[]{endereco1, endereco2});
        Cliente cliente2 = new Cliente("Bernardo", "152.991.990-82", new Contato[]{contato3, contato4}, new Endereco[]{endereco3, endereco4});
        ContaCorrente contaCliente1 = new ContaCorrente(cliente1, "18041478", "3604", 3500.00, 1000.00);
        ContaPoupanca contaCliente2 = new ContaPoupanca(cliente2, "25148698", "1804", 2000.00);
        cliente1.imprimirCliente();
        System.out.println("--------------------");
        cliente1.imprimirContatos();
        System.out.println("--------------------");
        cliente1.imprimirEnderecos();
        System.out.println("--------------------");
        cliente2.imprimirCliente();
        System.out.println("--------------------");
        cliente2.imprimirContatos();
        System.out.println("--------------------");
        cliente2.imprimirEnderecos();
        System.out.println("--------------------");
        contaCliente1.imprimir();
        System.out.println("--------------------");
        contaCliente2.imprimir();
        System.out.println("--------------------");
        contaCliente1.sacar(1000);
        contaCliente1.imprimir();
        System.out.println("--------------------");
        contaCliente1.depositar(250);
        contaCliente1.imprimir();
        System.out.println("--------------------");
        contaCliente2.imprimir();
        System.out.println("--------------------");
        contaCliente1.transferir(contaCliente2, 1000);
        contaCliente1.imprimir();
        System.out.println("--------------------");
        contaCliente2.imprimir();
        System.out.println("--------------------");
        contaCliente2.creditarTaxa();
        contaCliente2.imprimir();
        System.out.println("--------------------");
        contaCliente2.sacar(1000);
        contaCliente2.imprimir();
        System.out.println("--------------------");
        contaCliente2.depositar(700);
        contaCliente2.imprimir();
        System.out.println("--------------------");
        contaCliente2.transferir(contaCliente1, 500);
        contaCliente2.imprimir();
        System.out.println("--------------------");
        contaCliente1.imprimir();
    }
}
