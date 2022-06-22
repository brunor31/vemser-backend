package application;

public class Pessoa {

    public String nome;
    public String sobrenome;
    public int idade;
    public String wpp;

    public void conversar(Pessoa pessoa){
        System.out.println(nome + " conversou com " + pessoa.nome);
    }
    public String retornarNomeCompleto(){
        return nome + " " + sobrenome;
    }

    public boolean ehMaiorDeIdade(){
        if (idade > 17){
            return true;
        } else {
            return false;
        }
    }
    public void mandarWhatsApp(Pessoa pessoa, String msg){
        System.out.println(this.nome + " enviou: " + msg + " para: " + pessoa.nome);
    }
}
