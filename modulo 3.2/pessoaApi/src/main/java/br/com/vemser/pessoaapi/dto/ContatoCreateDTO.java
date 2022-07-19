package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.TipoContato;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class ContatoCreateDTO {

    @Schema(description = "Id da pessoa", example = "1")
    private Integer idPessoa;
    @NotNull
    @Schema(description = "Tipo do contato", example = "Pessoal")
    private TipoContato tipoContato;
    @NotEmpty
    @Size(max = 13)
    @Schema(description = "Número do contato", example = "51996031653")
    private String numero;
    @NotEmpty
    @Schema(description = "Descrição do contato", example = "Whatsapp")
    private String descricao;

}
