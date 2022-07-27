package br.com.vemser.pessoaapi.controller;

import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.dto.RelatorioDTO;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.entity.TipoContato;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import br.com.vemser.pessoaapi.service.PessoaService;
import br.com.vemser.pessoaapi.service.RelatorioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pessoa")  // localhost:8080/pessoa/hello
@Validated
@Slf4j
@ApiResponses({
        @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
        @ApiResponse(responseCode = "404", description = "Pessoa não encontrada"),
        @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
})
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private RelatorioService relatorioService;

    @Operation(summary = "Listar pessoas", description = "Lista todas as pessoas")
    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas")
    @GetMapping // localhost:8080/pessoa
    public List<PessoaDTO> list() {
        log.info("listar pessoas");
        return pessoaService.listar();
    }

    @Operation(summary = "Criar uma nova pessoa", description = "Cria uma nova pessoa e inclui no banco")
    @ApiResponse(responseCode = "200", description = "Cria uma nova pessoa e armazena no banco")
    @PostMapping // localhost:8080/pessoa
    public ResponseEntity<PessoaDTO> create(@RequestBody @Valid PessoaCreateDTO pessoa) {
        log.info("criar pessoa");
        return ResponseEntity.ok(pessoaService.create(pessoa));
    }

    @Operation(summary = "Atualizar uma pessoa", description = "Busca uma pessoa no banco pelo id e atualiza")
    @ApiResponse(responseCode = "200", description = "Atualizar uma pessoa do banco")
    @PutMapping("/{idPessoa}") // localhost:8080/pessoa/1000
    public void update(@PathVariable("idPessoa") Integer id,
                       @RequestBody @Valid PessoaCreateDTO pessoa) throws RegraDeNegocioException {
        log.info("atualizar pessoa");
        pessoaService.update(id, pessoa);
    }

    @Operation(summary = "Deletar uma pessoa", description = "Busca uma pessoa no banco pelo id e deleta")
    @ApiResponse(responseCode = "200", description = "Pessoa deleteda")
    @DeleteMapping("/{idPessoa}") // localhost:8080/pessoa/10
    public void delete(@PathVariable("idPessoa") Integer id) throws RegraDeNegocioException {
        log.info("deletar pessoa");
        pessoaService.delete(id);
    }
    @GetMapping("/{nome}")
    public List<PessoaDTO> findByNome(@RequestParam("nome") String nome){
        return pessoaService.findByNome(nome);
    }

    @GetMapping("/{cpf}/cpf")
    public PessoaDTO findByCpf(@RequestParam("cpf") String cpf){
        return pessoaService.findByCpf(cpf);
    }

    @GetMapping("/endereco")
    public List<PessoaDTO> getWithAdress(@RequestParam(required = false) Integer id) throws RegraDeNegocioException {
        return pessoaService.listWithAdress(id);
    }
    @GetMapping("/contato")
    public List<PessoaDTO> getWithContacts(@RequestParam(required = false) Integer id) {
        return pessoaService.listWithContacts(id);
    }

    @GetMapping("/pet")
    public List<PessoaDTO> getWithPets(@RequestParam(required = false) Integer id) {
        return pessoaService.listWithPets(id);
    }

    @GetMapping("/contato-por-tipo")
    public List<PessoaEntity> listByTypeContact(TipoContato tipoContato){
        List<PessoaEntity> pessoaEntities = pessoaRepository.listPessoasPorTipoContato(tipoContato);
        return pessoaEntities;
    }

    @GetMapping("/pessoa-completo")
    public List<PessoaDTO> listPessoaCompleta(@RequestParam(required = false) Integer id){
        return pessoaService.listarPessoaCompleta(id);
    }
    @GetMapping("/pessoa-relatorio")
    public List<RelatorioDTO> relatorio(@RequestParam(required = false) Integer id){
        return relatorioService.relatorios(id);
    }
}
