package restaurante.fachada;

import restaurante.negocio.*;
import restaurante.dados.*;

import java.util.List;

public class CategoriaFacade {
    private ICategoria categoriaCrud;

    public CategoriaFacade(ICategoria categoriaCrud) {
        this.categoriaCrud = categoriaCrud;
    }

    public void cadastrarCategoria(int codCategoria, String tipoCategoria) {
        categoriaCrud.cadastrarCategoria(codCategoria, tipoCategoria);
    }

    public void listarCategorias() {
        categoriaCrud.listarCategorias();
    }

    public void alterarCategoria(int codCategoria, int novoCodCateg, String novoTipoCategoria) {
        categoriaCrud.alteraCategoria(codCategoria, novoCodCateg, novoTipoCategoria);
    }

    public void excluirCategoria(int codCategoria) {
        categoriaCrud.delCategoria(codCategoria);
    }

    public String obterTipoCategoria(int codCategoria) {
        return categoriaCrud.obterTipoCategoria(codCategoria);
    }

    public List<Categoria> getCategorias() {
        return categoriaCrud.getCategorias();
    }
}
