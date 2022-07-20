package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {

    List<PessoaEntity> findByNomeContainsIgnoreCase(String nome);
    PessoaEntity findByCpf(String cpf);
}
