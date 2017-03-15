package br.com.balasecia.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.balasecia.model.Produto;
import br.com.balasecia.service.ProdutoService;

@RestController
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;
	
	@RequestMapping(method=RequestMethod.GET, value="/listar", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Produto>> listar(){
		Collection<Produto> produtosBuscados = produtoService.buscarTodos();
		
		return new ResponseEntity<>(produtosBuscados, HttpStatus.OK);
	}
		
	@RequestMapping(method=RequestMethod.POST, value="/cadastrar")
	public Produto cadastrar(@RequestBody Produto produto){
		return produtoService.cadastrar(produto);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/buscar/{id}")
	public Produto buscarPorId(@PathVariable Integer id){
		return produtoService.buscarPorId(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/alterar/{id}")
	public ResponseEntity<Produto> alterar(@RequestBody Produto produto, @PathVariable Integer id){		
		produto.setId(id);
		Produto produtoAlterado = produtoService.alterar(produto);
		
		return new ResponseEntity<>(produtoAlterado, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deletar/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Produto> deletar(@PathVariable Integer id){
		Produto produto = produtoService.buscarPorId(id);
		produtoService.excluir(produto);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
