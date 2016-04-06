package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Factory.ConnectionFactory;
import dao.ProdutoDAO;
import to.ClienteTO;
import to.ProdutoTO;

public class Venda {

	private int codVenda;
	private Calendar date;
	private ClienteTO cliente;
	private List<ProdutoTO> produtos = new ArrayList<>();
	
	public Venda(Cliente cliente2, Calendar calendar) {
	}

	public Venda(ClienteTO cliente2, Calendar date) {
		this.date = date;
		this.cliente = cliente2;
	}

	public int getCodVenda() {
		return codVenda;
	}

	public void setCodVenda(int codVenda) {
		this.codVenda = codVenda;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public ClienteTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteTO cliente) {
		this.cliente = cliente;
	}
	
	public List<ProdutoTO> getProdutos() {
		return produtos;
	}
	
	public void addProdutos(ProdutoTO produto, Integer quantidade) {
		
		// recupera quantidade de produtos do banco de dados
		int quantidadeBanco = new ProdutoDAO().carregar(produto.getCod_produto()).getQuantidade();
		
		if (produtos.size() > 0) {
			// verificar se produto já está na lista, se nao estiver retorna nulo
			if (getProdutoLista(produto, produtos) != null) {
				if (quantidade + produto.getQuantidade() <= quantidadeBanco) {
					produto.setQuantidade(quantidade + produto.getQuantidade());
				} else {
					throw new IllegalArgumentException("Quantidade insuficiente");
				}
			} else if (quantidade <= quantidadeBanco) {
				produto.setQuantidade(quantidade);
				produtos.add(produto);
			} else {
				throw new IllegalArgumentException("Quantidade insuficiente");
			}

		} else if (quantidade <= quantidadeBanco) {
			produto.setQuantidade(quantidade);
			produtos.add(produto);
		} else {
			throw new IllegalArgumentException("Quantidade insuficiente");
		}
	}
	
	private ProdutoTO getProdutoLista(ProdutoTO produto, List<ProdutoTO> produtos2) {
		// verificar se produto já está na lista
		for (int i = 0; i < produtos2.size(); i++) {
			// se estiver soma a quantidade com a já inserida
			if (produto.getCod_produto() == produtos2.get(i).getCod_produto()) {
				return produto;
			}
		}
		return null;
	}


}
