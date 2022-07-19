package br.com.vemser.pessoaapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
public class ContatoDTO extends ContatoCreateDTO {

    @Schema(description = "Id do contato", example = "3")
    private Integer idContato;
}
