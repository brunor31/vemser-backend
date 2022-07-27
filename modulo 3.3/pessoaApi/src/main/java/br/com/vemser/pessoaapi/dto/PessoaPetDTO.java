package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class PessoaPetDTO extends PessoaCreateDTO {

    @Schema(description = "Id da Pessoa", example = "1")
    private Integer idPessoa;

}
