package br.senai.sp.hellospringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.senai.sp.hellospringboot.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
	
	@Query("SELECT p FROM Produto p WHERE p.nome LIKE %:t% OR p.tipo LIKE %:t%")
	public List<Produto> ProcurarProduto(@Param("t") String p);

}
