package Dados;

public class Produto {
	private String nome;
	private int codigo;
	private int codigoCategoria;
	private double preco;
	private int quantidade;
	
	public Produto(String nome, int codigoCategoria,double preco,int quantidade ,int codigo)
	{
		this.nome = nome;
		this.codigo = codigo;
		this.codigoCategoria = codigoCategoria;
		this.preco = preco;
		this.quantidade = quantidade;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigoCategoria() {
		return codigoCategoria;
	}

	public void setCodigoCategoria(int codigoCategoria) {
		this.codigoCategoria = codigoCategoria;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}