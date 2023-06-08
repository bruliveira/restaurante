package restaurante.repositorio;

import restaurante.dados.Produto;

public interface IRepositorioProduto {
    void Criar();
    void CadastraProduto();
    void Removerproduto();
    Produto Buscar(String l);
    boolean BuscarNome(String n);
    void ListaProduto();
    void ConsutarTipo();
    void EditarProduto();

}
