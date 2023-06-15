package restaurante.fachada;

import java.util.List;

import restaurante.dados.*;
import restaurante.negocio.*;
import restaurante.repositorio.*;

public class ProdutoFacade implements IProduto {
    private ProdutoCrud produtoCrud;
    private CategoriaCrud categoriaCrud;

    public ProdutoFacade(ProdutoCrud produtoCrud, CategoriaCrud categoriaCrud) {
        this.produtoCrud = produtoCrud;
        this.categoriaCrud = categoriaCrud;
    }

    // Implement the methods defined in the IProduto interface

    @Override
    public void cadProduto(int codigo, String nome, double preco, int quantidade, Categoria categoria) {
        produtoCrud.cadProduto(codigo, nome, preco, quantidade, categoria);
    }

    @Override
    public void delProd(int codigo) {
        produtoCrud.delProd(codigo);
    }

    @Override
    public void alteraProd(int codigo) {
        produtoCrud.alteraProd(codigo);
    }

    @Override
    public List<Produto> listaProd() {
        return produtoCrud.listaProd();
    }

    @Override
    public List<Produto> getProdutos() {
        return produtoCrud.getProdutos();
    }

    @Override
    public boolean buscaProd(int codigo, int quantidade) {
        return false;
    }

    @Override
    public String obterTipoCategoria(int codProduto) {
        return categoriaCrud.obterTipoCategoria(codProduto);
    }

    @Override
    public boolean existeProduto(int codigo, int quantidade) {
        return produtoCrud.existeProduto(codigo, quantidade);
    }

    @Override
    public void setProdutos(List<Produto> produtos) {
        // Implement the logic to set the list of products
        // Replace the method body with your own implementation
    }

}