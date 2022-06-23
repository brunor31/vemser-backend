package entities;

public class Cliente {

    private String nome;
    private String cpf;
    private Contato[] contatos = new Contato[2];
    private Endereco[] enderecos = new Endereco[2];

    public Cliente(){
    }

    public Cliente(String nome, String cpf, Contato[] contatos, Endereco[] enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.contatos = contatos;
        this.enderecos = enderecos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Contato[] getContatos() {
        return contatos;
    }

    public void setContatos(int index, Contato contatos) {
        if (index < 2){
            this.contatos[index] = contatos;
        }
    }

    public Endereco[] getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(int index, Endereco enderecos) {
        if (index < 2) {
            this.enderecos[index] = enderecos;
        }
    }

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
