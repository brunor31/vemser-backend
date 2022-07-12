package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.EnderecoCreateDTO;
import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.entity.Pessoa;
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
        Pessoa pessoa = pessoaService.findById(idPessoa);
        Endereco enderecoEntity = objectMapper.convertValue(endereco, Endereco.class);
        enderecoEntity.setIdPessoa(idPessoa);
        enderecoRepository.create(enderecoEntity);
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoEntity, EnderecoDTO.class);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoa, PessoaDTO.class);
        emailService.sendEmailCreateEndereco(enderecoDTO, pessoaDTO);
        return enderecoDTO;
    }

    public EnderecoDTO update(Integer idEndereco, EnderecoCreateDTO endereco) throws RegraDeNegocioException {
        Endereco enderecoEntity = objectMapper.convertValue(endereco, Endereco.class);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaService.findById(enderecoEntity.getIdPessoa()), PessoaDTO.class);
        Endereco enderecoAtualizar = findById(idEndereco);
        enderecoAtualizar.setIdPessoa(enderecoEntity.getIdPessoa());
        enderecoAtualizar.setTipo(enderecoEntity.getTipo());
        enderecoAtualizar.setLogradouro(enderecoEntity.getLogradouro());
        enderecoAtualizar.setNumero(enderecoEntity.getNumero());
        enderecoAtualizar.setComplemento(enderecoEntity.getComplemento());
        enderecoAtualizar.setCep(enderecoEntity.getCep());
        enderecoAtualizar.setCidade(enderecoEntity.getCidade());
        enderecoAtualizar.setEstado(enderecoEntity.getEstado());
        enderecoAtualizar.setPais(enderecoEntity.getPais());
        EnderecoDTO enderecoDTO = objectMapper.convertValue(enderecoAtualizar, EnderecoDTO.class);
        emailService.sendEmailUpdateEndereco(enderecoDTO, pessoaDTO);
        return enderecoDTO;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Endereco enderecoDeletar = findById(id);
        emailService.sendEmailDeleteEndereco(enderecoDeletar, pessoaService.findById(enderecoDeletar.getIdPessoa()));
        enderecoRepository.list().remove(enderecoDeletar);
    }

    public EnderecoDTO findByIdDTO(Integer id) {
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
