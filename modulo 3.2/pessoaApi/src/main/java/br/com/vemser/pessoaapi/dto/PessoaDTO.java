package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
public class PessoaDTO extends PessoaCreateDTO{

    @Schema(description = "Id da Pessoa", example = "1")
    private Integer idPessoa;

    @Schema(description = "Retorna uma lista de enderecos")
    private List<EnderecoDTO> enderecoDTOS;

    @Schema(description = "Retorna uma lista de contatos")
    private List<ContatoDTO> contatoDTOS;

    @Schema(description = "Retorna uma lista de pets")
    private PetDTO petDTO;
}
