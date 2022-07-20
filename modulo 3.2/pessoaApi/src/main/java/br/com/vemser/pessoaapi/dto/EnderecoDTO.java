package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class EnderecoDTO extends EnderecoCreateDTO {

    @Schema(description = "Id do endereço", example = "2")
    private Integer idEndereco;
}
