package br.senai.sp.hellospringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.senai.sp.hellospringboot.model.Animal;

public interface AnimalRepository extends CrudRepository<Animal, Long>{

	@Query("SELECT a FROM Animal a WHERE a.cliente.id =:id ")
	public List<Animal> verAnimal(@Param("id") Long Parametro);
}
