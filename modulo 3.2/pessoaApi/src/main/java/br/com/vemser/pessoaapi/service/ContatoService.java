package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.entity.ContatoEntity;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.exception.RegraDeNegocioException;
import br.com.vemser.pessoaapi.repository.ContatoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;
    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private ObjectMapper objectMapper;


    public List<ContatoDTO> listar() {
        return contatoRepository.findAll().stream()
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .toList();
    }

    public List<ContatoDTO> listByIdPessoa(Integer id) throws RegraDeNegocioException { // valida se o idPessoa existe no contato
        pessoaService.findById(id);
        return contatoRepository.findAll().stream()
                .filter(contatoEntity -> contatoEntity.getIdPessoa().equals(id))
                .map(contatoEntity -> objectMapper.convertValue(contatoEntity, ContatoDTO.class))
                .toList();
    }

    public ContatoDTO create(Integer id, ContatoCreateDTO contato) throws RegraDeNegocioException {
        pessoaService.findById(id);
        ContatoEntity contatoEntity = objectMapper.convertValue(contato, ContatoEntity.class);
        contatoEntity.setIdPessoa(id);
        contatoRepository.save(contatoEntity);
        return objectMapper.convertValue(contatoEntity, ContatoDTO.class);
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoAtualizar) throws RegraDeNegocioException {
        ContatoEntity contatoEntity = findById(id);
        pessoaService.findById(contatoAtualizar.getIdPessoa());
        contatoEntity.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoEntity.setTipoContato(contatoAtualizar.getTipoContato());
        contatoEntity.setNumero(contatoAtualizar.getNumero());
        contatoEntity.setDescricao(contatoAtualizar.getDescricao());
        contatoRepository.save(contatoEntity);
        return objectMapper.convertValue(contatoEntity, ContatoDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        contatoRepository.delete(findById(id));
    }

    public ContatoEntity findById(Integer id) throws RegraDeNegocioException {
        return contatoRepository.findById(id)
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
    }
}
