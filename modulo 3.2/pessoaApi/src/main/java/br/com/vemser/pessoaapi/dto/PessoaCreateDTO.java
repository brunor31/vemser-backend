package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class PessoaCreateDTO {

    @NotBlank
    @Schema(description = "Nome da Pessoa", example = "Bruno Rodrigues")
    private String nome;
    @NotNull
    @Past
    @Schema(description = "Data de Nascimento", example = "1997/12/31")
    private LocalDate dataNascimento;
    @NotNull
    @Size(min = 11, max = 11)
    @Schema(description = "Número do CPF", example = "55078588027")
    private String cpf;
    @Schema(description = "Email da Pessoa", example = "brunoroliveira_@outlook.com")
    @NotBlank
    private String email;



}
