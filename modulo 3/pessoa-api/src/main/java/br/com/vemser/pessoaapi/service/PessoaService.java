package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.PessoaCreateDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ObjectMapper objectMapper;

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
        return objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoa) throws RegraDeNegocioException {
        objectMapper.convertValue(pessoa, Pessoa.class);
        Pessoa pessoaAtualizar = findById(id);
        pessoaAtualizar.setCpf(pessoa.getCpf());
        pessoaAtualizar.setNome(pessoa.getNome());
        pessoaAtualizar.setDataNascimento(pessoa.getDataNascimento());
        return objectMapper.convertValue(pessoaAtualizar, PessoaDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = findById(id);
        pessoaRepository.list().remove(pessoaRecuperada);
    }

    public Pessoa findById(Integer id) throws RegraDeNegocioException {
        Pessoa pessoaRecuperada = pessoaRepository.list().stream()
                .filter(pessoa -> pessoa.getIdPessoa().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não econtrada"));
        return pessoaRecuperada;
    }
}
