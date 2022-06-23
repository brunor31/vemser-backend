package entities;

import java.util.ArrayList;

public class Cliente {

    private String nome;
    private String cpf;
    private ArrayList<Contato> contatos = new ArrayList<>();
    private ArrayList<Endereco> enderecos = new ArrayList<>();

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
