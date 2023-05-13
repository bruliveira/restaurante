package Dados;


public class Garcom extends Usuario {
	private String status;
	
	public Garcom(String nome, String login, String senha)
	{
		super(nome,login,senha);
		this.status = "contratado";
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}