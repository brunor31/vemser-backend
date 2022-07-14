package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.Sexo;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class DadosPessoaisDTO {

    private String nome;
    private String nomeMae;
    private String nomePai;
    private String cnh;
    private String cpf;
    private String rg;
    private Sexo sexo;
    private String tituloEleitor;
}
