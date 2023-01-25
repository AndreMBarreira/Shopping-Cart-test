package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Classe que representa o carrinho de compras de um cliente.
 */
public class CarrinhoCompras {

	private List<Item> itens;

	/**
	 * Permite a adição de um novo item no carrinho de compras.
	 *
	 * Caso o item já exista no carrinho para este mesmo produto, as seguintes
	 * regras deverão ser seguidas: - A quantidade do item deverá ser a soma da
	 * quantidade atual com a quantidade passada como parâmetro. - Se o valor
	 * unitário informado for diferente do valor unitário atual do item, o novo
	 * valor unitário do item deverá ser o passado como parâmetro.
	 *
	 * Devem ser lançadas subclasses de RuntimeException caso não seja possível
	 * adicionar o item ao carrinho de compras.
	 *
	 * @param produto
	 * @param valorUnitario
	 * @param quantidade
	 */
	public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade) {

		int currentPosition = -1;
		for (int i = 0; i < getItens().size() && currentPosition < 0; i++) {
			Item newItem = itens.get(i);

			if (newItem.getProduto().equals(produto)) {
				currentPosition = i;
			}

		}

		try {
			if (!(currentPosition < 0)) {
				Item newItem = itens.get(currentPosition);
				quantidade = newItem.getQuantidade() + quantidade;
				if (newItem.getValorUnitario() == valorUnitario) {
					valorUnitario = newItem.getValorUnitario();
				}
				Item item = new Item(produto, valorUnitario, quantidade);
				item.setValorT(item.getValorTotal());

				itens.set(currentPosition, item);
			} else {
				Item item = new Item(produto, valorUnitario, quantidade);
				item.setValorT(item.getValorTotal());
				getItens().add(item);
			}
		} catch (RuntimeException e) {
			e.getStackTrace();
		}

	}

	/**
	 * Permite a remoção do item que representa este produto do carrinho de compras.
	 *
	 * @param produto
	 * @return Retorna um boolean, tendo o valor true caso o produto exista no
	 *         carrinho de compras e false caso o produto não exista no carrinho.
	 */
	@SuppressWarnings("unlikely-arg-type")
	public boolean removerItem(Produto produto) {
		int currentPosition = -1;

		for (int i = 0; i < getItens().size() & currentPosition < 0; i++) {
			Item newItem = itens.get(i);

			if (newItem.getProduto().equals(produto)) {
				currentPosition = i;
			}
		}

		if (currentPosition > -1) {
			getItens().remove(currentPosition);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Permite a remoção do item de acordo com a ção. Essa ção deve ser
	 * determinada pela ordem de inclusão do produto na coleção, em que zero
	 * representa o primeiro item.
	 *
	 * @param caoItem
	 * @return Retorna um boolean, tendo o valor true caso o produto exista no
	 *         carrinho de compras e false caso o produto não exista no carrinho.
	 */
	public boolean removerItem(int posicaoItem) {
		try {
			itens.remove(posicaoItem);
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}

	/**
	 * Retorna o valor total do carrinho de compras, que deve ser a soma dos valores
	 * totais de todos os itens que compõem o carrinho.
	 *
	 * @return BigDecimal
	 */
	public BigDecimal getValorTotal() {
		getItens().stream().forEach(s -> s.getValorTotal().plus());
		return (BigDecimal) getItens();

	}

	/**
	 * Retorna a lista de itens do carrinho de compras.
	 *
	 * @return itens
	 */
	public Collection<Item> getItens() {
        if (itens == null) {
            itens = new ArrayList<>();
        }
        return itens;
    }

}