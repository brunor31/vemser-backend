package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.LoginDTO;
import br.com.vemser.pessoaapi.entity.UsuarioEntity;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.security.TokenService;
import br.com.vemser.pessoaapi.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
@Validated
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioService usuarioService;
    private final TokenService tokenService;

    @PostMapping
    public String auth(@RequestBody @Valid LoginDTO login) throws RegraDeNegocioException {
        Optional<UsuarioEntity> usuario = usuarioService.findByLoginAndSenha(login.getLogin(), login.getSenha());
        if(usuario.isPresent()){
            String token = tokenService.getToken(usuario.get());
            return token;
        } else {
            throw new RegraDeNegocioException("Usuário ou senha inválidos.");
        }
    }
}
