package br.com.balasecia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.balasecia.model.Produto;
import br.com.balasecia.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	public List<Produto> buscarTodos() {
		return produtoRepository.findAll();
	}
	
	public Produto cadastrar(Produto produto) {
		return produtoRepository.save(produto);
	}

	public Produto buscarPorId(Integer id) {
		return produtoRepository.findOne(id);
	}
	
	public Produto alterar(Produto produto) {
		return produtoRepository.save(produto);
	}
	
	public void excluir(Produto produto) {
		produtoRepository.delete(produto);
	}



	

}
