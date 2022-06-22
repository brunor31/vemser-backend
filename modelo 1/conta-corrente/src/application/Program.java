package application;

import entities.Cliente;
import entities.ContaCorrente;
import entities.Contato;
import entities.Endereco;
import java.util.Locale;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Cliente cliente1 = new Cliente();
        cliente1.nome = "Bruno";
        cliente1.cpf = "891.484.640-74";
        Contato contato1 = new Contato();
        Contato contato2 = new Contato();
        contato1.descricao = "Celular";
        contato1.telefone = "51996031653";
        contato1.tipo = 1;
        contato2.descricao = "Telefone Fixo";
        contato2.telefone = "5135498100";
        contato2.tipo = 2;
        cliente1.contatos[0] = contato1;
        cliente1.contatos[1] = contato2;
        Endereco endereco1 = new Endereco();
        Endereco endereco2 = new Endereco();
        endereco1.tipo = 1;
        endereco1.logradouro = "Rudi Nelson Klein";
        endereco1.numero = 174;
        endereco1.complemento = "Próximo a Stier Bier";
        endereco1.cep = "95650-000";
        endereco1.cidade = "Igrejinha";
        endereco1.estado = "RS";
        endereco1.pais = "BR";
        endereco2.tipo = 2;
        endereco2.logradouro = "Mal Deodoro da Fonseca";
        endereco2.numero = 530;
        endereco2.complemento = "Casa de Pedra";
        endereco2.cep = "95650-000";
        endereco2.cidade = "Igrejinha";
        endereco2.estado = "RS";
        endereco2.pais = "BR";
        cliente1.enderecos[0] = endereco1;
        cliente1.enderecos[1] = endereco2;
        ContaCorrente contaCorrente1 = new ContaCorrente();
        contaCorrente1.cliente = cliente1;
        contaCorrente1.numeroConta = "8804";
        contaCorrente1.agencia = 1804;
        contaCorrente1.saldo = 3700.00;
        contaCorrente1.chequeEspecial = 1000.00;
        Cliente cliente2 = new Cliente();
        cliente2.nome = "Bernardo";
        cliente2.cpf = "764.569.010-06";
        Contato contato3 = new Contato();
        Contato contato4 = new Contato();
        contato3.descricao = "Celular";
        contato3.telefone = "51995429246";
        contato3.tipo = 1;
        contato4.descricao = "Telefone Fixo";
        contato4.telefone = "5135454756";
        contato4.tipo = 2;
        cliente2.contatos[0] = contato3;
        cliente2.contatos[1] = contato4;
        Endereco endereco3 = new Endereco();
        Endereco endereco4 = new Endereco();
        endereco3.tipo = 1;
        endereco3.logradouro = "Anita Garibaldi";
        endereco3.numero = 1856;
        endereco3.complemento = "Bairro Figueiras";
        endereco3.cep = "95650-000";
        endereco3.cidade = "Igrejinha";
        endereco3.estado = "RS";
        endereco3.pais = "BR";
        endereco4.tipo = 2;
        endereco4.logradouro = "Rua das Pedreiras";
        endereco4.numero = 1475;
        endereco4.complemento = "Próximo ao SESI";
        endereco4.cep = "95650-000";
        endereco4.cidade = "Igrejinha";
        endereco4.estado = "RS";
        endereco4.pais = "BR";
        cliente2.enderecos[0] = endereco3;
        cliente2.enderecos[1] = endereco4;
        ContaCorrente contaCorrente2 = new ContaCorrente();
        contaCorrente2.cliente = cliente2;
        contaCorrente2.numeroConta = "1234";
        contaCorrente2.agencia = 3604;
        contaCorrente2.saldo = 2000.00;
        contaCorrente2.chequeEspecial = 500.00;

        cliente1.imprimirCliente();
        cliente1.imprimirContatos();
        cliente1.imprimirEnderecos();
        contaCorrente1.imprimirContaCorrente();
        contaCorrente1.sacar(4000.00);
        contaCorrente1.imprimirContaCorrente();
        contaCorrente1.depositar(1100.00);
        contaCorrente1.imprimirContaCorrente();
        System.out.printf("Saldo com cheque especial: R$%.2f\n", contaCorrente1.retornarSaldoComChequeEspecial());
        cliente2.imprimirCliente();
        cliente2.imprimirContatos();
        cliente2.imprimirEnderecos();
        contaCorrente2.imprimirContaCorrente();
        contaCorrente2.sacar(250.00);
        contaCorrente2.imprimirContaCorrente();
        contaCorrente2.depositar(1500.00);
        contaCorrente2.imprimirContaCorrente();
        System.out.printf("Saldo com cheque especial: R$%.2f\n", contaCorrente2.retornarSaldoComChequeEspecial());
        contaCorrente1.transferir(contaCorrente2, 1000.00);
        contaCorrente1.imprimirContaCorrente();
        contaCorrente2.imprimirContaCorrente();
        contaCorrente2.transferir(contaCorrente1, 2000.00);
        contaCorrente2.imprimirContaCorrente();
        contaCorrente1.imprimirContaCorrente();
    }
}
