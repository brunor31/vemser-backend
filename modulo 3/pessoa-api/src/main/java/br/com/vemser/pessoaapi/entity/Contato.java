package br.com.vemser.pessoaapi.entity;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Contato {


    private Integer idContato;
    private Integer idPessoa;
    @NotNull
    private String tipoContato;
    @NotEmpty
    @Size(max = 13)
    private String numero;
    @NotEmpty
    private String descricao;

}
