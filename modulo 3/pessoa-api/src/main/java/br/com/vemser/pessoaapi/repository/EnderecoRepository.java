package br.com.vemser.pessoaapi.repository;


import br.com.vemser.pessoaapi.entity.Endereco;
import br.com.vemser.pessoaapi.entity.TipoEndereco;
import org.springframework.stereotype.Repository;
import javax.el.ELException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class EnderecoRepository {

    private static List<Endereco> listaenderecos = new ArrayList<>();

    private AtomicInteger COUNTER = new AtomicInteger();

    public EnderecoRepository() {
        listaenderecos.add(new Endereco(COUNTER.incrementAndGet(), 1, TipoEndereco.RESIDENCIAL, "Street 1th", 123
                , "Downtown", "00014-140", "Igrejinha", "RS", "BR"));
        listaenderecos.add(new Endereco(COUNTER.incrementAndGet(), 2, TipoEndereco.COMERCIAL, "Street 2th", 174
                , "Downtown", "00014-152", "Três Coroas", "RS", "BR"));
        listaenderecos.add(new Endereco(COUNTER.incrementAndGet(), 3, TipoEndereco.RESIDENCIAL, "Street 3th", 521
                , "Downtown", "00014-789", "Taquara", "RS", "BR"));
        listaenderecos.add(new Endereco(COUNTER.incrementAndGet(), 4, TipoEndereco.COMERCIAL, "Street 4th", 199
                , "Downtown", "00014-741", "Parobé", "RS", "BR"));
        listaenderecos.add(new Endereco(COUNTER.incrementAndGet(), 5, TipoEndereco.RESIDENCIAL, "Street 5th", 200
                , "Downtown", "00014-000", "Gramado", "RS", "BR"));

    }

    public List<Endereco> list() {
        return listaenderecos;
    }

    public Endereco create(Endereco endereco) {
        endereco.setIdEndereco(COUNTER.incrementAndGet());
        listaenderecos.add(endereco);
        return endereco;
    }

    public Endereco update(Integer id, Endereco endereco) {
        Endereco enderecoAtualizar = listaenderecos.stream()
                .filter(x -> x.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new ELException("Endereço não encontrado"));
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
        Endereco enderecoDeletar = listaenderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .findFirst()
                .orElseThrow(() -> new Exception("Pessoa não encontrada"));
        listaenderecos.remove(enderecoDeletar);
    }

    public List<Endereco> listById(Integer id) {
        return listaenderecos.stream()
                .filter(endereco -> endereco.getIdEndereco().equals(id))
                .toList();
    }

    public List<Endereco> listByIdPessoa(Integer id){
        return listaenderecos.stream()
                .filter(endereco -> endereco.getIdPessoa().equals(id))
                .toList();
    }
}
