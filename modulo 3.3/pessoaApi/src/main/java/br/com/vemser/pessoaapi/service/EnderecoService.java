package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.*;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private ObjectMapper objectMapper;

    public List<EnderecoDTO> listar() {
        return enderecoRepository.findAll().stream()
                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                .toList();
    }

    public List<EnderecoDTO> listByIdPessoa(Integer id) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = pessoaService.findById(id);
        return enderecoRepository.findAll().stream()
                .filter(enderecoEntity -> enderecoEntity.getPessoas().contains(pessoaEntity))
                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                .toList();
    }

    public EnderecoDTO create(Integer id, EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = pessoaService.findById(id);
        EnderecoEntity enderecoEntity = objectMapper.convertValue(endereco, EnderecoEntity.class);
        enderecoEntity.setPessoas(Set.of(pessoaEntity));
        enderecoRepository.save(enderecoEntity);
        return objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
    }

    public EnderecoDTO update(Integer id, EnderecoDTO endereco) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = pessoaService.findById(endereco.getIdPessoa());
        EnderecoEntity enderecoEntity = findById(id);
        EnderecoEntity enderecoEntity1 = objectMapper.convertValue(endereco, EnderecoEntity.class);
        enderecoEntity1.setIdEndereco(id);
        enderecoEntity1.setPessoas(Set.of(pessoaEntity));
        return objectMapper.convertValue(enderecoRepository.save(enderecoEntity1), EnderecoDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        EnderecoEntity enderecoEntity = findById(id);
        enderecoRepository.delete(enderecoEntity);
    }

    public EnderecoDTO findByIdDTO(Integer id) throws RegraDeNegocioException {
        EnderecoEntity enderecoEntity = findById(id);
        return objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
    }

    public EnderecoEntity findById(Integer id) throws RegraDeNegocioException {
        return enderecoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
    }
}
