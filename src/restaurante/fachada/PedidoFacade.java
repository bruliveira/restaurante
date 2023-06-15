package restaurante.fachada;

import restaurante.repositorio.*;

public class PedidoFacade {
    private PedidoCrud pedidoCrud;

    public PedidoFacade(PedidoCrud pedidoCrud) {
        this.pedidoCrud = pedidoCrud;
    }

    public void anotarPedido(int codPedido) {
        pedidoCrud.anotarPedido(codPedido);
    }

    public void finalizarPedido(int codPedido, double valorPago) {
        pedidoCrud.finalizarPedido(codPedido, valorPago);
    }

    public void listarPedido(int codPedido) {
        pedidoCrud.listarPedido(codPedido);
    }

    public void listarTodosPedidos() {
        pedidoCrud.listarTodosPedidos();
    }
}
