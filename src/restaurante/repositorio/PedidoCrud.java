package restaurante.repositorio;

import java.util.ArrayList;
import restaurante.dados.Pedido;
import restaurante.dados.Produto;

public class PedidoCrud{
    public ArrayList<Pedido> listaPedido = new ArrayList<Pedido>();

    public void addPedido(Pedido pedido){
        this.listaPedido.add(pedido);
    }
    public void addPedido(Pedido pedido, Produto produtos){
        double totalPedido = pedido.getTotal() + produtos.getPreco();
        pedido.listcodProduto.add(produtos);
        this.listaPedido.add(pedido);
        
        pedido.setTotal(totalPedido);
    }
    public void listarTodosPedidos(){
        System.out.println("----- Todas os pedidos -----");
        for(Pedido pedidos: listaPedido){
            System.out.println("\n" + pedidos);
        }
    }

}