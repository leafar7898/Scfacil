package to;

import modelo.Venda;
import to.ClienteTO;
import to.ProdutoTO;

public class CaixaTO {
	private Venda venda;
	private ProdutoTO produto;
	private Integer quantidade;
	
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	public ProdutoTO getProduto() {
		return produto;
	}
	public void setProduto(ProdutoTO produto) {
		this.produto = produto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
