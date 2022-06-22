package entities;

public class Cliente {

    public String nome;
    public String cpf;
    public Contato[] contatos = new Contato[2];
    public Endereco[] enderecos = new Endereco[2];

    public void imprimirContatos(){
        for (Contato c : contatos){
            c.imprimirContato();
        }
    }
    public void imprimirEnderecos(){
        for (Endereco e : enderecos){
            e.imprimirEndereco();
        }
    }
    public void imprimirCliente(){
        System.out.printf("Nome: %s, Cpf: %s\n", nome, cpf);
    }
}
