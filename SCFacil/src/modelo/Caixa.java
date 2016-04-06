package modelo;

import dao.CaixaDAO;
import dao.ClienteDAO;
import to.CaixaTO;
import to.ClienteTO;
import to.ProdutoTO;

public class Caixa {

	private Venda venda;
	private ProdutoTO produto;
	private Integer quantidade;
	
	public Caixa() {
	}

	public Caixa(Venda venda, ProdutoTO produto, Integer quantidade) {
		this.venda = venda;
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public ProdutoTO getProduto() {
		return produto;
	}

	public void setProduto(ProdutoTO produtoTO) {
		this.produto = produtoTO;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public void criar() {
		CaixaDAO dao = new CaixaDAO();
		CaixaTO to = new CaixaTO();
		to.setVenda(venda);
		to.setProduto(produto);
		to.setQuantidade(quantidade);
		dao.incluir(to);
	}
	

}
