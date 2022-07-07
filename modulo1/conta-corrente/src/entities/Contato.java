package entities;

public class Contato {

    public String descricao;
    public String telefone;
    public int tipo; // (1 - residencial, 2 - comercial)

    public void imprimirContato(){
        switch (tipo){
            case 1 -> {
                System.out.printf("%s: %s - contato residencial\n", descricao, telefone);
            }
            case 2 -> {
                System.out.printf("%s: %s - contato comercial\n", descricao, telefone);
            }
            default -> {
                System.out.println("Contato inválido");
            }
        }
    }
}
