package br.senai.sp.hellospringboot.controller;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.senai.sp.hellospringboot.model.Produto;
import br.senai.sp.hellospringboot.repository.ProdutoRepository;

@Controller
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRe;
	
	@RequestMapping(value = "formProduto", method = RequestMethod.GET)
	public String formProduto() {		
		
		return "produto/formProduto";
	}
	@RequestMapping(value = "formProduto", method = RequestMethod.POST)
	public String salvarProduto(Produto produto) {
		produtoRe.save(produto);
		
		return "redirect:listarProduto";
	}
	
	@RequestMapping("listarProduto")
	public String listarProduto(Model model) {
		model.addAttribute("produto", produtoRe.findAll());
		
		return "produto/listarProduto";
	}
	@RequestMapping("alterarProduto")
	public String alterarproduto(Model model, Long id) {
		Produto produto = produtoRe.findById(id).get();
		model.addAttribute("produtos", produto);
			
		return "forward:formProduto";
		
	}
	@RequestMapping("excluirProduto")
	public String excluirProduto(Long id) {
		produtoRe.deleteById(id);
		return "redirect:listarProduto";
	}
	
	@RequestMapping("formBuscaProduto")
	public String formBuscaProduto() {
		
		return "produto/buscarProduto";
	}
	@RequestMapping("buscarProduto")
	public String buscarProduto(String p, Model model) {
		model.addAttribute("produto", produtoRe.ProcurarProduto(p));
		
		
		return "produto/listarProduto";
	}
}
