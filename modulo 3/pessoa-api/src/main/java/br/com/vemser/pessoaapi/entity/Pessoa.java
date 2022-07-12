package br.com.vemser.pessoaapi.entity;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    private Integer idPessoa;
    @NotBlank
    private String nome;
    @NotNull
    private LocalDate dataNascimento;
    @CPF
    private String cpf;
    @NotBlank
    private String email;

}
