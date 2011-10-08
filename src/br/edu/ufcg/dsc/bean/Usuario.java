package br.edu.ufcg.dsc.bean;

public class Usuario {
	private String login, senha;
	
	public Usuario(String login, String senha) {
		if (login == null || senha == null || login.trim().isEmpty() || senha.trim().isEmpty()){
			throw new IllegalArgumentException("Nome de Usuario e/ou senha invalido(s)");
		}
		this.login = login;
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		if (login == null || login.trim().isEmpty()){
			throw new IllegalArgumentException("Nome de Usuario invalido");
		}
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		if (senha == null || senha.trim().isEmpty()){
			throw new IllegalArgumentException("Senha invalida");
		}
		this.senha = senha;
	}
	
	
}
