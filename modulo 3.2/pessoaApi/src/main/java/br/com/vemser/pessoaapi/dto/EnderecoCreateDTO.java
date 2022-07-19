package br.com.vemser.pessoaapi.dto;

import br.com.vemser.pessoaapi.entity.TipoEndereco;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Data
public class EnderecoCreateDTO {

    @NotNull
    @Schema(description = "Tipo de endereço [1- RESIDENCIAL, 2- COMERCIAL]", example = "COMERCIAL")
    private TipoEndereco tipo;
    @NotBlank
    @Size(max = 250)
    @Schema(description = "Nome da rua", example = "Rudi Nelson Klein")
    private String logradouro;
    @NotNull
    @Schema(description = "Número do endereço", example = "174")
    private Integer numero;
    @Schema(description = "Complemento do endereço", example = "Próximo a cervejaria Stier")
    private String complemento;
    @NotEmpty
    @Size(max = 8)
    @Schema(description = "CEP do endereço", example = "95650000")
    private String cep;
    @NotBlank
    @Size(max = 250)
    @Schema(description = "Nome da cidade", example = "Porto Alegre")
    private String cidade;
    @NotNull
    @Schema(description = "Nome do estado", example = "Rio Grande do Sul")
    private String estado;
    @NotNull
    @Schema(description = "Nome do país", example = "Brasil")
    private String pais;

}
