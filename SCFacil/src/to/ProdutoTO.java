package to;

public class ProdutoTO {

	private int cod_produto;
	private String nome;
	private int quantidade;
	private double valorCusto;
	private double valorVenda;
	
	public int getCod_produto() {
		return cod_produto;
	}
	public void setCod_produto(int cod_produto) {
		this.cod_produto = cod_produto;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValorCusto() {
		return valorCusto;
	}
	public void setValorCusto(double valorCusto) {
		this.valorCusto = valorCusto;
	}
	public double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}
	public  double getValorTotal() {
		return valorVenda * quantidade;
	}
	
	
	
}
