package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

//    public List<EnderecoDTO> listByIdPessoa(Integer id) throws RegraDeNegocioException {
//        pessoaService.findById(id);
//        return enderecoRepository.findAll().stream()
//                .filter(enderecoEntity -> enderecoEntity.getIdPessoa().equals(id))
//                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
//                .toList();
//    }

    public EnderecoDTO create(EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        EnderecoEntity enderecoEntity = objectMapper.convertValue(endereco, EnderecoEntity.class);
        enderecoRepository.save(enderecoEntity);
        return objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        EnderecoEntity enderecoEntity = findById(id);
        enderecoEntity.setTipo(endereco.getTipo());
        enderecoEntity.setLogradouro(endereco.getLogradouro());
        enderecoEntity.setNumero(endereco.getNumero());
        enderecoEntity.setComplemento(endereco.getComplemento());
        enderecoEntity.setCep(endereco.getCep());
        enderecoEntity.setCidade(endereco.getCidade());
        enderecoEntity.setEstado(endereco.getEstado());
        enderecoEntity.setPais(endereco.getPais());
        enderecoRepository.save(enderecoEntity);
        return objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
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
