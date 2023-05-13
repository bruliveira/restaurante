/*public class Usuario{
    public String nome;
    public int cpf;
    public String email;
    public String login;
    public String senha;

    

}*/

package Dados;

public class Usuario {
	
	protected String nome;
	protected String login;
	protected String senha;
	
	public Usuario(String nome, String login, String senha)
	{
		this.nome = nome;
		this.senha = senha;
		this.login = login;
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