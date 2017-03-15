package br.com.balasecia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.balasecia.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
