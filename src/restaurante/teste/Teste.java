package restaurante.teste;

import restaurante.dados.Conta;
import restaurante.dados.Pedido;
import restaurante.dados.Produto;
import restaurante.repositorio.ContaCrud;
import restaurante.repositorio.PedidoCrud;

public class Teste{
    public static void main(String[] args) {
        System.out.println("\n---------- RESTAURANTE ----------");

        //Produtos
        Produto produto1 = new Produto("Suco de laranja", 12, 5, 5, 1);
        Produto produto2 = new Produto("Suco de manga", 12, 10, 5, 2);
        Produto produto3 = new Produto("Arroz", 12, 5, 1, 3);
        Produto produto4 = new Produto("Feijão", 12, 5, 2, 4);
        
        //Pedidos
        Pedido pedido1 = new Pedido(1,  10, false);
        Pedido pedido2 = new Pedido(2, 20, false);
        Pedido pedido3 = new Pedido(3, 50, false);
        Pedido pedido4 = new Pedido(4, 20, false);
        
        PedidoCrud pedidos = new PedidoCrud();
        //pedidos.addPedidoZero(pedido1, produto1);
        pedidos.addPedido(pedido1, produto2);
        pedidos.addPedido(pedido1, produto1);
        pedidos.addPedido(pedido2, produto1);
        pedidos.addPedido(pedido2, produto1);
        pedidos.listarTodosPedidos();

        System.out.println("Pedidos busca: ");

        System.out.println("\nConta");
        Conta conta1 = new Conta(1, 0, true);
        Conta conta2 = new Conta(2, 0, true);
        Conta conta3 = new Conta(3, 0, true);


        ContaCrud contas = new ContaCrud();
        contas.addConta(conta1, pedido1);
        contas.addConta(conta1, pedido2);
        contas.addConta(conta2, pedido2);
        contas.addConta(conta2, pedido1);
        contas.addConta(conta3, pedido1);
        contas.addConta(conta3, pedido4);

        contas.listarTodasConta();

        contas.finalizarConta(3);
        contas.alterarConta(1, 8);
        contas.listarTodasContaAbertas();
       

    }
}
