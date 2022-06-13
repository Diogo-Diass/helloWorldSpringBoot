package br.senai.sp.hellospringboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.senai.sp.hellospringboot.model.Animal;
import br.senai.sp.hellospringboot.model.Cliente;
import br.senai.sp.hellospringboot.repository.AnimalRepository;
import br.senai.sp.hellospringboot.repository.ClienteRepository;

@Controller
public class AnimalController {
	
	@Autowired
	ClienteRepository repCliente;
	@Autowired
	AnimalRepository repAnimal;
	
	@RequestMapping("formAnimal")
	public String form(Model model) {
		model.addAttribute("clientes", repCliente.findAll());
		
		return "animal/formAnimal";
	}
	@RequestMapping("salvarAnimal")
	public String salvarAnimal(Animal animal) {
		repAnimal.save(animal);
		
		return "redirect:listarAnimal";
	}
	@RequestMapping("listarAnimal")
	public String listarAnimal(Model model) {
		model.addAttribute("animal", repAnimal.findAll());
		
		return "animal/listarAnimal";
		
	}
	@RequestMapping("alterarAnimal")
	public String alterarAnimal(Model model, Long id) {
		
		Animal animal = repAnimal.findById(id).get();
		
		model.addAttribute("animais", animal);
		
		return "forward:formAnimal";
	}
	@RequestMapping("excluirAnimal")
	public String excluirAnimal(Long id) {
			repAnimal.deleteById(id);
		
		return "redirect:listarAnimal";
	}
	@RequestMapping("verAnimal")
	public String verAnimal(Long id, Model model) {
		
		model.addAttribute("animal", repAnimal.verAnimal(id));
		
		
		return "animal/listarAnimal";
	}
	

}
