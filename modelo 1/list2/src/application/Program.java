package application;

public class Program {

    public static void main(String[] args) {

        Pessoa pessoa1 = new Pessoa();
        Pessoa pessoa2 = new Pessoa();
        pessoa1.nome = "Bruno";
        pessoa1.sobrenome = "Rodrigues";
        pessoa1.idade = 24;
        pessoa1.wpp = "51996031653";
        pessoa2.nome = "Igor";
        pessoa2.sobrenome = "Medeiros";
        pessoa2.idade = 30;
        pessoa2.wpp = "51982495757";

        pessoa1.conversar(pessoa2);
        System.out.println(pessoa1.retornarNomeCompleto());
        System.out.println("É maior de idade: " + pessoa1.ehMaiorDeIdade());
        pessoa1.mandarWhatsApp(pessoa2, "preciso de ajuda" );
    }
}
