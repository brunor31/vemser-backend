package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.dto.EnderecoDTO;
import br.com.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Integer> {

    @Query(" select e " +
            "  from ENDERECO_PESSOA e")
    Page<EnderecoEntity> lisByCep(Pageable pageable);

    @Query(" select e " +
            "  from ENDERECO_PESSOA e " +
            " where (:pais = e.pais)")
    Page<EnderecoEntity> findByPaisIgnoreCase(@RequestParam("pais") String pais, Pageable pageable);
}
