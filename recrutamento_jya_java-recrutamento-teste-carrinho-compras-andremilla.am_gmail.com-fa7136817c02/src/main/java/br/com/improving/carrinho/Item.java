package br.com.improving.carrinho;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Classe que representa um item no carrinho de compras.
 */
public class Item implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Produto produto;
	private BigDecimal valorUnitario;
	private int quantidade;
	private BigDecimal valorT;

	/**
	 * Construtor da classe Item.
	 * 
	 * @param produto
	 * @param valorUnitario
	 * @param quantidade
	 */

	public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
		super();
		this.produto = produto;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
	}

	/**
	 * Retorna o produto.
	 *
	 * @return Produto
	 */
	public Produto getProduto() {
		return produto;
	}

	/**
	 * Retorna o valor unitário do item.
	 *
	 * @return BigDecimal
	 */
	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	/**
	 * Retorna a quantidade dos item.
	 *
	 * @return int
	 */
	public int getQuantidade() {
		return quantidade;
	}


	/**
	 * Retorna o valor total do item.
	 *
	 * @return BigDecimal
	 */
    public BigDecimal getValorTotal() {
        BigDecimal bd = new BigDecimal(quantidade);
        return this.valorUnitario.multiply(bd);
    }

	public BigDecimal getValorT() {
		return valorT;
	}

	public void setValorT(BigDecimal valorT) {
		this.valorT = valorT;
	}

}
