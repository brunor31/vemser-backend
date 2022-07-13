package br.com.vemser.pessoaapi.entity;

import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Contato {

    private Integer idContato;
    private Integer idPessoa;
    private String tipoContato;
    private String numero;
    private String descricao;

}
