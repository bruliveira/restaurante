package restaurante.dados;


public class UsuarioGarcom extends Usuario {
	private String status;
	
	public UsuarioGarcom(String nome, String login, String senha)
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