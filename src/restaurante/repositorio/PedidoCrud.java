package restaurante.repositorio;

import java.util.ArrayList;

import restaurante.dados.Categoria;
import restaurante.dados.Pedido;
import restaurante.dados.Produto;

public class PedidoCrud implements IPedidoCrud{
    public ArrayList<Pedido> listaPedido = new ArrayList<Pedido>();

    Produto produto1 = new Produto("laranja",23,12,15,64);
    Pedido pedido1 = new Pedido(1, 10, true);
    
    @Override
    public void criar()
	{
        addPedido(pedido1, produto1);
	}
    @Override
    public void addPedido(Pedido pedido, Produto produtos){
        double totalPedido = pedido.getTotal() + (produtos.getQuantidade() * produtos.getPreco());
        Pedido pedidoAdd = null;
        for(Pedido pedidos: listaPedido){
            if(pedido.getCodPedido() == pedidos.getCodPedido()){
                pedidoAdd = pedidos;
                break;
            }
        }
        if(pedidoAdd != null){
            pedido.listcodProduto.add(produtos);
            pedido.setTotal(totalPedido);
        }else{
            pedido.listcodProduto.add(produtos);
            this.listaPedido.add(pedido);
            pedido.setTotal(totalPedido);
        }
    }
    @Override
    public void listarTodosPedidos(){
        System.out.println("----- Todas os pedidos -----");
        for(Pedido pedidos: listaPedido){
            System.out.println("\n" + pedidos);
        }
    }
}