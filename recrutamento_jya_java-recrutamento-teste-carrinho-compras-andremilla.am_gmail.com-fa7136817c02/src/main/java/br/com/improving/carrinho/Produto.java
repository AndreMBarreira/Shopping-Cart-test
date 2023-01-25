package br.com.improving.carrinho;

import java.io.Serializable;
import java.util.Objects;

/**
 * Classe que representa um produto que pode ser adicionado como item ao
 * carrinho de compras.
 *
 * Importante: Dois produtos são considerados iguais quando ambos possuem o
 * mesmo código.
 */
public class Produto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long codigo;
	private String descricao;
	
	
	public Produto() {
		super();
	}

	/**
	 * Construtor da classe Produto.
	 *
	 * @param codigo
	 * @param descricao
	 */

	public Produto(Long codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}

	/**
	 * Retorna o código da produto.
	 *
	 * @return Long
	 */
	public Long getCodigo() {
		return codigo;
	}

	/**
	 * Retorna a descrição do produto.
	 *
	 * @return String
	 */
	public String getDescricao() {
		return descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(codigo, other.codigo);
	}

}