package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class UsuarioDTO{

    @Schema(description = "Login de usuário")
    private String login;
    @Schema(description = "Id do usuário")
    private Integer idUsuario;
}
