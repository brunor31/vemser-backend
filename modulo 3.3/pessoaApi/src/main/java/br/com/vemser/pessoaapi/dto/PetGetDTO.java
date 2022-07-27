package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.TipoPet;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class PetGetDTO {

    @Schema(description = "Id da pessoa")
    private PessoaPetDTO pessoaPetDTO;
    @Schema(description = "Nome da pessoa")
    private String nome;
    @Schema(description = "Tipo do pet")
    private TipoPet tipo;
    @Schema(description = "Id do pet")
    private Integer idPet;
}
