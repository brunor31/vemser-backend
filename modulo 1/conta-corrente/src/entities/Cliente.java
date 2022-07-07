package entities;

public class Cliente {

    public String nome;
    public String cpf;
    public Contato[] contatos = new Contato[2];
    public Endereco[] enderecos = new Endereco[2];

    public void imprimirContatos(){
        for (Contato c : contatos){
            if (c != null) {
                c.imprimirContato();
            } else {
                System.out.println("O contato está vazio!");
            }
        }
    }
    public void imprimirEnderecos(){
        for (Endereco e : enderecos){
            if (e != null){
                e.imprimirEndereco();
            } else {
                System.out.println("O endereço está vazio!");
            }
        }
    }
    public void imprimirCliente(){
        System.out.printf("Nome: %s, Cpf: %s\n", nome, cpf);
    }
}
