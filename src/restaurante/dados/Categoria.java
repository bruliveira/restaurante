package Dados;

public class Categoria {
	private int codCategoria;
	private String tipo;
	
	public Categoria(String tipo, int cod)
	{
		this.tipo = tipo;
		this.codCategoria = cod;
	}
	

	public int getCodCategoria() {
		return codCategoria;
	}

	public void setCodCategoria(int codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}