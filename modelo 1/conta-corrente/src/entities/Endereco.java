package entities;

public class Endereco {

    public int tipo; // (1 - residencial, 2 - comercial)
    public String logradouro;
    public int numero;
    public String complemento;
    public String cep;
    public String cidade;
    public String estado;
    public String pais;

    public void imprimirEndereco(){
        switch (tipo){
            case 1 -> {
                System.out.printf("Endereço residencial - Rua: %s, Número: %d, Cep: %s, Cidade: %s, Estado: " +
                        "%s, País: %s\n", logradouro, numero, cep, cidade, estado, pais);
            }
            case 2 ->{
                System.out.printf("Endereço comercial - Rua: %s, Número: %d, Cep: %s, Cidade: %s, Estado: " +
                        "%s, País: %s\n", logradouro, numero, cep, cidade, estado, pais);
            }
        }
    }
}
