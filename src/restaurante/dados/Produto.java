package restaurante.dados;
public class Produto{
    private int codProduto;
    private int codCategoria;
    private String nome;
    private double preco;
    private int quantidade;

    
    public Produto(int codproduto, int codcategoria, String nome, double preco, int quantidade){
		this.codProduto = codproduto;
        this.codCategoria = codcategoria;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
	}

    @Override
	public String toString() {
		String pro = "Código: " + this.codProduto + 
				"\nCódigo categoria: " + this.codCategoria + 
                "\nNome: " + this.nome + 
                "\nPreço: " + this.preco + 
                "\nQuantidade: " + this.quantidade;
		return pro;
	}

    //Get's e Set's
    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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