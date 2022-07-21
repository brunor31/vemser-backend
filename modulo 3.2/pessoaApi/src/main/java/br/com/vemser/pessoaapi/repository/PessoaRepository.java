package br.com.vemser.pessoaapi.repository;

import br.com.vemser.pessoaapi.dto.RelatorioDTO;
import br.com.vemser.pessoaapi.entity.PessoaEntity;
import br.com.vemser.pessoaapi.entity.TipoContato;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Integer> {
    List<PessoaEntity> findByNomeContainsIgnoreCase(String nome);
    PessoaEntity findByCpf(String cpf);

    @Query(" select p " +
            "  from PESSOA p " +
            "  join p.contatos c " +
            " where c.tipoContato = :tipoContato")
    List<PessoaEntity> listPessoasPorTipoContato(@Param("tipoContato")TipoContato tipoContato);


    @Query(value = "select new br.com.vemser.pessoaapi.dto.RelatorioDTO(" +
            "p.idPessoa, " +
            "p.nome, " +
            "p.email, " +
            "c.numero, " +
            "e.cep, " +
            "e.cidade, " +
            "e.estado, " +
            "e.pais, " +
            "pE.nome" +
            ") " +
            "from PESSOA p " +
            "left join p.contatos c " +
            "left join p.enderecos e " +
            "left join p.petEntity pE " +
            "where (:idPessoa is null OR p.idPessoa = :idPessoa)")
    List<RelatorioDTO> relatorioPessoa(@Param("idPessoa") Integer idPessoa);
}
