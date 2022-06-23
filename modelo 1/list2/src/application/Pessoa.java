package application;

public class Pessoa {

    private String nome;
    private String sobrenome;
    private int idade;
    private String wpp;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getWpp() {
        return wpp;
    }

    public void setWpp(String wpp) {
        this.wpp = wpp;
    }

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
        System.out.println(nome + " enviou: " + msg + " para: " + pessoa.nome);
    }
}
