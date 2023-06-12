package restaurante.repositorio;

import restaurante.dados.Categoria;

public interface ICategoriaCrud {
    void Criar();
    void CadastraCategoria(Categoria c);
    void RemoverCategoria(Categoria c);
    Categoria Buscar(String l);
    boolean BuscarNome(String n);
    String ListaCategoria();
    void EditarCategoria(String nome, Categoria c);
}
