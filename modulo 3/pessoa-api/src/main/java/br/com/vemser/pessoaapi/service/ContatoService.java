package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.ContatoCreateDTO;
import br.com.vemser.pessoaapi.dto.ContatoDTO;
import br.com.vemser.pessoaapi.entity.Contato;
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
        return contatoRepository.list().stream()
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .toList();
    }

    public List<ContatoDTO> listByIdPessoa(Integer id) throws RegraDeNegocioException { // valida se o idPessoa existe no contato
        pessoaService.findById(id);
        return contatoRepository.list().stream()
                .filter(contato -> contato.getIdPessoa().equals(id))
                .map(contato -> objectMapper.convertValue(contato, ContatoDTO.class))
                .toList();
    }

    public ContatoDTO create(Integer id, ContatoCreateDTO contato) throws RegraDeNegocioException {
        pessoaService.findById(id);
        Contato contatoEntity = objectMapper.convertValue(contato, Contato.class);
        contatoEntity.setIdPessoa(id);
        contatoRepository.create(contatoEntity);
        return objectMapper.convertValue(contatoEntity, ContatoDTO.class);
    }

    public ContatoDTO update(Integer id, ContatoCreateDTO contatoAtualizar) throws RegraDeNegocioException {
        Contato contatoRecuperar = findById(id);
        objectMapper.convertValue(contatoAtualizar, Contato.class);
        pessoaService.findById(contatoAtualizar.getIdPessoa());
        contatoRecuperar.setIdPessoa(contatoAtualizar.getIdPessoa());
        contatoRecuperar.setTipoContato(contatoAtualizar.getTipoContato());
        contatoRecuperar.setNumero(contatoAtualizar.getNumero());
        contatoRecuperar.setDescricao(contatoAtualizar.getDescricao());
        return objectMapper.convertValue(contatoRecuperar, ContatoDTO.class);
    }

    public void delete(Integer id) throws RegraDeNegocioException {
        Contato contatoDeletar = findById(id);
        contatoRepository.list().remove(contatoDeletar);
    }

    public Contato findById(Integer id) throws RegraDeNegocioException {
        Contato contatoRecuperado = contatoRepository.list().stream()
                .filter(contato -> contato.getIdContato().equals(id))
                .findFirst()
                .orElseThrow(() -> new RegraDeNegocioException("Contato não encontrado"));
        return contatoRecuperado;
    }
}
