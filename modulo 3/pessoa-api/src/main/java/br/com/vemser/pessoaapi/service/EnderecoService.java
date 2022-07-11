package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.entity.Endereco;
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
    private PessoaService pessoaService;
    @Autowired
    private ObjectMapper objectMapper;

    public List<EnderecoDTO> listar() {
        return enderecoRepository.list().stream()
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .toList();
    }

    public List<EnderecoDTO> listByIdPessoa(Integer id) throws RegraDeNegocioException {
        pessoaService.findById(id);
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdPessoa().equals(id))
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .toList();
    }

    public EnderecoDTO create(Integer idPessoa, EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        pessoaService.findById(idPessoa);
        Endereco enderecoEntity = objectMapper.convertValue(endereco, Endereco.class);
        enderecoEntity.setIdPessoa(idPessoa);
        enderecoRepository.create(enderecoEntity);
        return objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
    }

    public EnderecoDTO update(Integer id, EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        Endereco enderecoAtualizar = findById(id);
        enderecoAtualizar = objectMapper.convertValue(endereco, Endereco.class);
        pessoaService.findById(endereco.getIdPessoa());
        enderecoAtualizar.setIdPessoa(endereco.getIdPessoa());
        enderecoAtualizar.setTipo(endereco.getTipo());
        enderecoAtualizar.setLogradouro(endereco.getLogradouro());
        enderecoAtualizar.setNumero(endereco.getNumero());
        enderecoAtualizar.setComplemento(endereco.getComplemento());
        enderecoAtualizar.setCep(endereco.getCep());
        enderecoAtualizar.setCidade(endereco.getCidade());
        enderecoAtualizar.setEstado(endereco.getEstado());
        enderecoAtualizar.setPais(endereco.getPais());
        return objectMapper.convertValue(enderecoAtualizar, EnderecoDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Endereco enderecoDeletar = findById(id);
        enderecoRepository.list().remove(enderecoDeletar);
    }

    public EnderecoDTO findByIdDTO (Integer id) {
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .map(endereco -> objectMapper.convertValue(endereco, EnderecoDTO.class))
                .findFirst()
                .get();
    }

    public Endereco findById(Integer id) throws RegraDeNegocioException {
        Endereco enderecoAtualizar = enderecoRepository.list().stream()
                .filter(x -> x.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Endereço não encontrado"));
        return enderecoAtualizar;
    }

}
