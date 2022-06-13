package br.senai.sp.hellospringboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.senai.sp.hellospringboot.model.Cliente;
import br.senai.sp.hellospringboot.repository.AnimalRepository;
import br.senai.sp.hellospringboot.repository.ClienteRepository;

@Controller
public class ClienteController {
	
	
	@Autowired
	private ClienteRepository repository;
	@Autowired
	private AnimalRepository aniRep;
	
	@RequestMapping(value = "formCliente", method = RequestMethod.GET)
	public String formCliente() {
		
		return "cliente/form";
	}
	@RequestMapping(value = "formCliente", method = RequestMethod.POST)
	public String salvarCliente(Cliente cliente) {
			repository.save(cliente);
			
		return "redirect:listarCliente";
	}
	@RequestMapping("listarCliente")
	public String listarCliente(Model model) {
										//find all é a parte de listar(trabalho passado)
		model.addAttribute("clientes", repository.findAll());
		return "cliente/listaCliente";
		
	}
	@RequestMapping("alterarCliente")
	public String alterarCliente(Model model, Long  id) {
		
		Cliente cliente = repository.findById(id).get();
		model.addAttribute("cliente", cliente);
		return "forward:formCliente";
		
	}
	@RequestMapping("excluirCliente")
	public String excluirCliente(Long id) {
		repository.deleteById(id);
		
		//redirect:ele redireciona vc para o request mapping do seu formulario que esta no return, nesse caso o listarCliente
		return "redirect:listarCliente";
	}
	
	@RequestMapping("formBusca")
	public String formBusca() {
		return "cliente/formuNomeCpf";
	}
	
	@RequestMapping("buscarPorCpf")
	public String buscarPorCpf(String cpf, Model model, RedirectAttributes att) {
		Cliente cliente = repository.findByCpf(cpf);
		if (cliente == null) {
			att.addFlashAttribute("msg", "Cliente não encontrado.");
			return "redirect:formBusca";
			
		}
		model.addAttribute("cliente", cliente);
		
		return "forward:formCliente";
		
	}
	@RequestMapping("buscarPorNome")
	public String buscarPeloNome(String nome, Model model) {
		model.addAttribute("clientes", repository.procurarPeloNome(nome));
		
		return "cliente/listaCliente";
	}
	
}
