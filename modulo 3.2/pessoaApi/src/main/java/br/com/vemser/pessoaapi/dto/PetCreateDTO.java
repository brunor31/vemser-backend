package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.TipoPet;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PetCreateDTO {

    @Schema(description = "Id da pessoa")
    private Integer idPessoa;
    @Schema(description = "Nome do pet")
    private String nome;
    @Schema(description = "Tipo do pet")
    private TipoPet tipo;
}
