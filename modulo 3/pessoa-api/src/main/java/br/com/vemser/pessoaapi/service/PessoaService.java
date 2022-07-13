package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private ObjectMapper objectMapper;

    @Operation(summary = "listar pessoas", description = "Lista todas as pessoas do banco")
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "Retorna a lista de pessoas"),
                    @ApiResponse(responseCode = "403", description = "Você não tem permissão para acessar este recurso"),
                    @ApiResponse(responseCode = "500", description = "Foi gerada uma exceção")
            }
    )
    public List<PessoaDTO> listar() {
        return pessoaRepository.list().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .toList();
    }

    public List<PessoaDTO> listByName(String nome) {
        return pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getNome().contains(nome))
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .toList();
    }

    public PessoaDTO create(PessoaCreateDTO pessoa) {
        Pessoa pessoaEntity = objectMapper.convertValue(pessoa, Pessoa.class);
        pessoaRepository.create(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        emailService.sendEmailPessoaCreate(pessoaDTO);
        return pessoaDTO;
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoa) throws RegraDeNegocioException {
        objectMapper.convertValue(pessoa, Pessoa.class);
        Pessoa pessoaAtualizar = findById(id);
        pessoaAtualizar.setCpf(pessoa.getCpf());
        pessoaAtualizar.setNome(pessoa.getNome());
        pessoaAtualizar.setDataNascimento(pessoa.getDataNascimento());
        pessoaAtualizar.setEmail(pessoa.getEmail());
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaAtualizar, PessoaDTO.class);
        emailService.sendEmailPessoaUpdate(pessoaDTO);
        return pessoaDTO;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        emailService.sendEmailPessoaDelete(findById(id));
        pessoaRepository.list().remove(findById(id));
    }

    public Pessoa findById(Integer id) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
        return pessoaRecuperada;
    }
}
