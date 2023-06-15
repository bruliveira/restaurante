package restaurante.negocio;

import restaurante.dados.*;
import java.util.List;

public interface ICategoria {

    void cadastrarCategoria(int codCategoria, String tipoCategoria);

    List<Categoria> getCategorias();

    void listarCategorias();

    void alteraCategoria(int codCategoria, int novoCodCateg, String novoTipoCategoria);

    void delCateg(int codCategoria);

    void atualizarListaCategorias();

    Categoria buscarCategoria(int codCategoria);

    void delCategoria(int codCategoria);

    boolean verificarExistencia(int codCategoria, String tipoCategoria);

    String obterTipoCategoria(int codCategoria);
}
