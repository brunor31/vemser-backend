package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.el.ELException;
import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaService pessoaService;

    public List<Endereco> listar() {
        return enderecoRepository.list();
    }
    public Endereco findById(Integer id) {
        Endereco enderecoAtualizar = enderecoRepository.list().stream()
                .filter(x -> x.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new ELException("Endereço não encontrado"));
        return enderecoAtualizar;
    }
    public List<Endereco> listByIdPessoa(Integer id) throws Exception {
        pessoaService.findById(id);
        return enderecoRepository.list().stream()
                .filter(endereco -> endereco.getIdPessoa().equals(id))
                .toList();
    }

    public Endereco create(Endereco endereco, Integer idPessoa) throws Exception {
        pessoaService.findById(idPessoa);
        return enderecoRepository.create(endereco);
    }

    public Endereco update(Integer id, Endereco endereco) {
        Endereco enderecoAtualizar = findById(id);
        enderecoAtualizar.setIdPessoa(endereco.getIdPessoa());
        enderecoAtualizar.setTipo(endereco.getTipo());
        enderecoAtualizar.setLogradouro(endereco.getLogradouro());
        enderecoAtualizar.setNumero(endereco.getNumero());
        enderecoAtualizar.setComplemento(endereco.getComplemento());
        enderecoAtualizar.setCep(endereco.getCep());
        enderecoAtualizar.setCidade(endereco.getCidade());
        enderecoAtualizar.setEstado(endereco.getEstado());
        enderecoAtualizar.setPais(endereco.getPais());
        return enderecoAtualizar;
    }

    public void delete(Integer id) throws Exception {
        Endereco enderecoDeletar = findById(id);
        enderecoRepository.list().remove(enderecoDeletar);
    }
}
