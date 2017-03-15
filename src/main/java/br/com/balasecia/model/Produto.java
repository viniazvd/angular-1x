package br.com.balasecia.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO) 
	//@Getter 
	//@Setter
	private Integer id;
	
	//@Getter @Setter
	private String nome;
	
	//@Getter @Setter
	private Integer valor;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

}
