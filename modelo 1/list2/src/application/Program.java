package application;

public class Program {

    public static void main(String[] args) {

        Pessoa pessoa1 = new Pessoa();
        Pessoa pessoa2 = new Pessoa();
        pessoa1.setNome("Bruno");
        pessoa1.setSobrenome("Rodrigues");
        pessoa1.setIdade(24);
        pessoa1.setWpp("51996031653");
        pessoa2.setNome("Igor");
        pessoa2.setSobrenome("Medeiros");
        pessoa2.setIdade(30);
        pessoa2.setWpp("51982495757");

        pessoa1.conversar(pessoa2);
        System.out.println(pessoa1.retornarNomeCompleto());
        System.out.println("É maior de idade: " + pessoa1.ehMaiorDeIdade());
        pessoa1.mandarWhatsApp(pessoa2, "preciso de ajuda" );
    }
}
