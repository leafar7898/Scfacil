package modelo;

import to.ClienteTO;
import dao.ClienteDAO;

public class Cliente {
	private int cod_cliente;
	private String nome;
	private String cpf ;
	private String telefone;
	private String endereco;	
	private String cep;
	
	public Cliente() {

	}

	public Cliente(String nome, String cpf, String telefone, String endereco, String cep) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cep = cep;
	}

	public int getCod_cliente() {
		return cod_cliente;
	}
	
	public void setCod_cliente(int cod_cliente) {
		this.cod_cliente = cod_cliente;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public void criar() {
		ClienteDAO dao = new ClienteDAO();
		ClienteTO to = new ClienteTO();
		to.setCod_cliente(cod_cliente);
		to.setNome(nome);
		to.setCpf(cpf);
		to.setTelefone(telefone);
		to.setEndereco(endereco);
		to.setCep(cep);
		dao.incluir(to);
	}

	public void atualizar() {
		ClienteDAO dao = new ClienteDAO();
		ClienteTO to = new ClienteTO();
		to.setCod_cliente(cod_cliente);
		to.setNome(nome);
		to.setCpf(cpf);
		to.setTelefone(telefone);
		to.setEndereco(endereco);
		to.setCep(cep);
		dao.atualizar(to);
	}
	public void excluir() {
		ClienteDAO dao = new ClienteDAO();
		ClienteTO to = new ClienteTO();
		to.setCod_cliente(cod_cliente);
		dao.excluir(to);
	}
	public void carregar() {
		ClienteDAO dao = new ClienteDAO();
		ClienteTO to = dao.carregar(cod_cliente);
	nome 	 =	to.getNome();
	cpf  	 = 	to.getCpf();
	telefone = 	to.getTelefone();
	endereco = 	to.getEndereco();
	cep      =  to.getCep();
				dao.atualizar(to);
	}
	
	@Override
	public String toString() {
		return "Cliente [cod_cliente=" + cod_cliente + ", nome=" + nome + ", CFP=" + cpf + ",Telefone =" + telefone +", Endereço=" + endereco +", CEP=" + cep + "]";
	}
	
}