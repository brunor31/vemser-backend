package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class UsuarioCreateDTO {

    @NotEmpty
    @Schema(description = "Login de usuário")
    private String login;
    @NotEmpty
    @Schema(description = "Senha de usuário")
    private String senha;
}
