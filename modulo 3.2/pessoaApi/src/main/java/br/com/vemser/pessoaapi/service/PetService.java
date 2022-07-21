package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.*;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.entity.PetEntity;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.PetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository petRepository;
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private ObjectMapper objectMapper;

    public List<PetGetDTO> list() {
        return petRepository.findAll().stream()
                .map(petEntity -> {
                    PetGetDTO petGetDTO = objectMapper.convertValue(petEntity, PetGetDTO.class);
                    petGetDTO.setPessoaPetDTO(objectMapper.convertValue(petEntity.getPessoaEntity(), PessoaPetDTO.class));
                    return petGetDTO;
                })
                .toList();
    }

    public PetDTO create(PetCreateDTO pet) throws RegraDeNegocioException {
        PetEntity petEntity = objectMapper.convertValue(pet, PetEntity.class);
        PessoaEntity pessoaEntity = pessoaService.findById(pet.getIdPessoa());
        if (pessoaEntity.getPetEntity() == null){
            petEntity.setPessoaEntity(pessoaEntity);
            petRepository.save(petEntity);
            return objectMapper.convertValue(petEntity, PetDTO.class);
        } else {
            throw new RegraDeNegocioException("Pessoa já possuí pet");
        }
    }

    public PetDTO update(Integer id, PetCreateDTO pet) throws RegraDeNegocioException {
        PetEntity petEntity = findById(id);
        PessoaEntity pessoaEntity = pessoaService.findById(pet.getIdPessoa());
        if (pessoaEntity.getPetEntity() == null) {
            petEntity.setPessoaEntity(pessoaEntity);
            petEntity.setNome(pet.getNome());
            petEntity.setTipo(pet.getTipo());
            petRepository.save(petEntity);
            return objectMapper.convertValue(petEntity, PetDTO.class);
        } else {
        throw new RegraDeNegocioException("Pessoa já possuí pet");
    }

}

    public void delete(Integer id) throws RegraDeNegocioException {
        PetEntity petEntity = findById(id);
        petRepository.delete(petEntity);
    }

    public PetEntity findById(Integer id) throws RegraDeNegocioException {
        return petRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Pet não encontrado"));
    }
}
