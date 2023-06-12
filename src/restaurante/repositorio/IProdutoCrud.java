package restaurante.repositorio;

import restaurante.dados.Categoria;
import restaurante.dados.Produto;

public interface IProdutoCrud {
    void Criar();
    void CadastraProduto(Produto p);
    void Removerproduto(Produto p);
    Produto Buscar(String l);
    boolean BuscarNome(String n);
    String ListaProduto(Categoria c);
    void EditarProduto(double preco, Produto p);
}
