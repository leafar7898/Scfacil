package modelo;

import dao.ClienteDAO;
import dao.ProdutoDAO;
import to.ClienteTO;
import to.ProdutoTO;
//import java.awt.Component;

public class Produto {

	private int cod_produto;
	private String nome;
	private int quantidade;
	private double valorCusto;
	private double valorVenda;
	
	public Produto(){
		
	}

	public Produto(String nome, int quantidade, double valorCusto, double valorVenda) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.valorCusto = valorCusto;
		this.valorVenda = valorVenda;
	}

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
	

	public Double getValorTotal() {
		return valorVenda * quantidade;
	}
	
	public void criar() {
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = new ProdutoTO();
		to.setCod_produto(cod_produto);
		to.setNome(nome);
		to.setQuantidade(quantidade);
		to.setValorCusto(valorCusto);
		to.setValorVenda(valorVenda);
		dao.incluir(to);
	}

	public void atualizar() {
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = new ProdutoTO();
		to.setCod_produto(cod_produto);
		to.setNome(nome);
		to.setQuantidade(quantidade);
		to.setValorCusto(valorCusto);
		to.setValorVenda(valorVenda);
		dao.atualizar(to);
	}
	public void excluir() {
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = new ProdutoTO();
		to.setCod_produto(cod_produto);
		dao.excluir(to);
	}
	public void carregar() {
		ProdutoDAO dao = new ProdutoDAO();
		ProdutoTO to = dao.carregar(cod_produto);
	nome = 	to.getNome();
	quantidade = 	to.getQuantidade();
	valorCusto = 	to.getValorCusto();
	valorVenda =	to.getValorVenda();
					dao.atualizar(to);
	}
	
	@Override
	public String toString() {
		return "Cliente [cod_produto=" + cod_produto + ", nome=" + nome + ", Quantidade=" + quantidade + ",ValorCusto=" + valorCusto +", ValorVenda=" + valorVenda + "]";
	}
	

}
