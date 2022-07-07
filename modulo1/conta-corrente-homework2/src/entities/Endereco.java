package entities;

public class Endereco {

    private Integer tipo; // (1 - residencial, 2 - comericial)
    private String logradouro;
    private Integer numero;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;

    public Endereco(){
    }

    public Endereco(Integer tipo, String logradouro, Integer numero, String complemento, String cep, String cidade, String estado, String pais) {
        this.tipo = tipo;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
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
            default -> {
                System.out.println("Endereço inválido");
            }
        }
    }
}
