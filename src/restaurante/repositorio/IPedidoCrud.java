package restaurante.repositorio;

import restaurante.dados.Pedido;
import restaurante.dados.Produto;

public interface IPedidoCrud {
    void addPedido(Pedido pedido, Produto produtos);
    void listarTodosPedidos();
}
