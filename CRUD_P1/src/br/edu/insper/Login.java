package br.edu.insper;

public class Login {
	
	private Integer id;
	private String name;
	private String senha;
	private String confirma_senha;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getConfirmaSenha() {
		return confirma_senha;
	}
	public void setConfirmaSenha(String confirma_senha) {
		this.confirma_senha = confirma_senha;
	}
	
}
