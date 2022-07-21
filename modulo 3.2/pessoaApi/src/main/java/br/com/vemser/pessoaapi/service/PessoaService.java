package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.*;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PessoaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private EmailService emailService;
    @Autowired
    private ObjectMapper objectMapper;

    public List<PessoaDTO> listar() {
        return pessoaRepository.findAll().stream()
                .map(pessoa -> objectMapper.convertValue(pessoa, PessoaDTO.class))
                .toList();
    }

    public PessoaDTO create(PessoaCreateDTO pessoa) {
        PessoaEntity pessoaEntity = objectMapper.convertValue(pessoa, PessoaEntity.class);
        pessoaRepository.save(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        emailService.sendEmailPessoaCreate(pessoaDTO);
        return pessoaDTO;
    }

    public PessoaDTO update(Integer id, PessoaCreateDTO pessoaCreateDTO) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = findById(id);
        pessoaEntity.setCpf(pessoaCreateDTO.getCpf());
        pessoaEntity.setNome(pessoaCreateDTO.getNome());
        pessoaEntity.setDataNascimento(pessoaCreateDTO.getDataNascimento());
        pessoaEntity.setEmail(pessoaCreateDTO.getEmail());
        pessoaRepository.save(pessoaEntity);
        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
        emailService.sendEmailPessoaUpdate(pessoaDTO);
        return pessoaDTO;
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        PessoaEntity pessoaEntity = findById(id);
        emailService.sendEmailPessoaDelete(pessoaEntity);
        pessoaRepository.delete(pessoaEntity);
    }

    public PessoaEntity findById(Integer id) throws RegraDeNegocioException {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pessoa não encontrada"));
    }

    public PessoaDTO findByCpf(String cpf) {
        PessoaEntity pessoaEntity = pessoaRepository.findByCpf(cpf);
        return objectMapper.convertValue(pessoaEntity, PessoaDTO.class);
    }

    public List<PessoaDTO> findByNome(String nome) {
        return pessoaRepository.findByNomeContainsIgnoreCase(nome).stream()
                .map(pessoaEntity -> objectMapper.convertValue(pessoaEntity, PessoaDTO.class))
                .toList();
    }

    public List<PessoaDTO> listWithAdress(Integer id) {
        if (id != null) {
            return pessoaRepository.findById(id).stream()
                    .map(pessoaEntity1 -> {
                        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity1, PessoaDTO.class);
                        pessoaDTO.setEnderecoDTOS(pessoaEntity1.getEnderecos().stream()
                                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                                .toList());
                        return pessoaDTO;
                    }).toList();
        } else {
            return pessoaRepository.findAll().stream()
                    .map(pessoaEntity1 -> {
                        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity1, PessoaDTO.class);
                        pessoaDTO.setEnderecoDTOS(pessoaEntity1.getEnderecos().stream()
                                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                                .toList());
                        return pessoaDTO;
                    }).toList();
        }
    }

    public List<PessoaDTO> listWithContacts(Integer id) {
        if (id != null) {
            return pessoaRepository.findById(id).stream()
                    .map(pessoaEntity1 -> {
                        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity1, PessoaDTO.class);
                        pessoaDTO.setContatoDTOS(pessoaEntity1.getContatos().stream()
                                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                                .toList());
                        return pessoaDTO;
                    }).toList();
        } else {
            return pessoaRepository.findAll().stream()
                    .map(pessoaEntity1 -> {
                        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity1, PessoaDTO.class);
                        pessoaDTO.setContatoDTOS(pessoaEntity1.getContatos().stream()
                                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                                .toList());
                        return pessoaDTO;
                    }).toList();
        }
    }

    public List<PessoaDTO> listWithPets(Integer id) {
        if (id != null) {
            return pessoaRepository.findById(id).stream()
                    .map(pessoaEntity1 -> {
                        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity1, PessoaDTO.class);
                        pessoaDTO.setPetDTO(objectMapper.convertValue(pessoaEntity1.getPetEntity(), PetDTO.class));
                        return pessoaDTO;
                    }).toList();
        } else {
            return pessoaRepository.findAll().stream()
                    .map(pessoaEntity1 -> {
                        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity1, PessoaDTO.class);
                        pessoaDTO.setPetDTO(objectMapper.convertValue(pessoaEntity1.getPetEntity(), PetDTO.class));
                        return pessoaDTO;
                    }).toList();
        }
    }

    public List<PessoaDTO> listarPessoaCompleta(Integer id) {
        if (id != null) {
            return pessoaRepository.findById(id).stream()
                    .map(pessoaEntity1 -> {
                        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity1, PessoaDTO.class);
                        pessoaDTO.setEnderecoDTOS(pessoaEntity1.getEnderecos().stream()
                                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                                .toList());
                        pessoaDTO.setContatoDTOS(pessoaEntity1.getContatos().stream()
                                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                                .toList());
                        pessoaDTO.setPetDTO(objectMapper.convertValue(pessoaEntity1.getPetEntity(), PetDTO.class));
                        return pessoaDTO;
                    }).toList();
        } else {
            return pessoaRepository.findAll().stream()
                    .map(pessoaEntity1 -> {
                        PessoaDTO pessoaDTO = objectMapper.convertValue(pessoaEntity1, PessoaDTO.class);
                        pessoaDTO.setEnderecoDTOS(pessoaEntity1.getEnderecos().stream()
                                .map(enderecoEntity -> objectMapper.convertValue(enderecoEntity, EnderecoDTO.class))
                                .toList());
                        pessoaDTO.setContatoDTOS(pessoaEntity1.getContatos().stream()
                                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                                .toList());
                        pessoaDTO.setPetDTO(objectMapper.convertValue(pessoaEntity1.getPetEntity(), PetDTO.class));
                        return pessoaDTO;
                    }).toList();
        }
    }
}
