package restaurante.negocio;

import java.util.List;
import restaurante.dados.*;

public interface IProduto {

    void cadProduto(int codProduto, String nomeProduto, double precoProduto, int qtdProduto,
            Categoria categoria);

    boolean buscaProd(int codProduto, int codCategoria);

    List<Produto> listaProd();

    void delProd(int codProduto);

    void alteraProd(int codProduto);

    String obterTipoCategoria(int codCategoria);

    boolean existeProduto(int codProduto, int codCategoria);

    List<Produto> getProdutos();

    void setProdutos(List<Produto> produtos);
}
