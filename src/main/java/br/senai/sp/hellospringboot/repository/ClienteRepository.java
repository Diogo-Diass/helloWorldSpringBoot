package br.senai.sp.hellospringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.senai.sp.hellospringboot.model.Cliente;
//inclui as logicas de inserção, update, //chama o Long do id
public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	
	//faz uma busca no banco de dados buscando o cpf da pessoa
	public Cliente findByCpf(String cpf);
	
	//select * from cliente where nome like ''
	public List<Cliente> findByNomeLike(String nome);
	
	
	//te permite fazer uma consulta com toda liberdade do sql, porem usando o jsql...
	
	//aqui vc pode ter mais de um nome, diferentemente do cpf onde cada cpf é unico
	@Query("SELECT c FROM Cliente c WHERE c.nome LIKE %:n%")
	public List<Cliente> procurarPeloNome(@Param("n") String nome);
}
