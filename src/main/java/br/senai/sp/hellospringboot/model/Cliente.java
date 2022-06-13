package br.senai.sp.hellospringboot.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

//faz com q nao necessite gerar get e set...
@Data
//fala que a classe cliente é uma tabela no banco de dados
@Entity
public class Cliente {
	
	//dizendo que o id é um primary key, o generate diz que ele é um valor auto increment, só o generate sem o strategy ele cria uma tabela de ids 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "VARCHAR(100)")
	private String nome;
	
	//unique diz que o cpf é um cpf unico, ou seja não pode ter outro igual
	@Column(unique = true, length = 11)
	private String cpf;
	
	private String email;
					
}
