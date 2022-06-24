package entities;

import java.util.ArrayList;

public class Cliente {

    private String nome;
    private String cpf;
    private ArrayList<Contato> contatos;
    private ArrayList<Endereco> enderecos;

    public Cliente(){
    }

    public Cliente(String nome, String cpf, ArrayList<Contato> contatos, ArrayList<Endereco> enderecos) {
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

    public ArrayList<Contato> getContatos() {
        return contatos;
    }

    public void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(ArrayList<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public void imprimirContatos() {
        if(contatos != null){
            for (Contato c : contatos) {
                if (c != null) {
                    c.imprimirContato();
                }
            }
        }
    }
    public void imprimirEnderecos(){
        if (enderecos != null){
            for (Endereco e : enderecos){
                if (e != null) {
                    e.imprimirEndereco();
                }
            }
        }
    }
    public void imprimirCliente(){
        System.out.printf("Nome: %s, Cpf: %s\n", nome, cpf);
    }
}
