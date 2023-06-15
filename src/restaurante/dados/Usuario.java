package restaurante.dados;

public class Usuario {

	protected String nome;
	protected String login;
	protected String senha;

	public Usuario(String nome, String login, String senha) {
		this.nome = nome;
		this.login = login;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	// Retorna a qual tipo o usuário pertence (gerente ou garçom)
	public String getTipo() {
		return "Usuário";
	}
}
