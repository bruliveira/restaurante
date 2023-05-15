package restaurante.teste;

import restaurante.dados.Conta;
import restaurante.dados.Pedido;
import restaurante.dados.Produto;
import restaurante.dados.Usuario;
import restaurante.repositorio.ContaCrud;
import restaurante.repositorio.GarcomCrud;
import restaurante.repositorio.PedidoCrud;

public class Teste {
    public static void main(String[] args) {
        System.out.println("\n---------- RESTAURANTE ----------");

        Usuario usuario1 = new Usuario("pedro", "pedro123", "123");

        GarcomCrud garc = new GarcomCrud();

        new Produto("Suco de laranja", 12, 5, 5, 34);
        Produto produto1 = new Produto("Suco de laranja", 12, 5, 5, 34);
        Produto produto2 = new Produto("Suco de manga", 12, 5, 5, 34);

        // Pedido
        Pedido pedido1 = new Pedido(1, 2, 0, false);
        Pedido pedido2 = new Pedido(2, 2, 20, false);
        // pedido1.listcodProduto.add(produto2);

        System.out.println("Pedidos");
        PedidoCrud pedidos = new PedidoCrud();

        pedidos.addPedidoZero(pedido1, produto1);
        pedidos.addPedido(pedido1, produto2);
        pedidos.listarTodosPedidos();

        System.out.println("\nConta");
        Conta conta1 = new Conta(1, 0, true);

        // conta1.listCodPedido.add(pedido1);

        ContaCrud contas = new ContaCrud();

        contas.addContaPrimeira(conta1, pedido1);
        contas.addConta(conta1, pedido2);

        contas.listarTodasConta();

        contas.finalizarConta(1);
        contas.listarTodasConta();
    }
}
/*
 * //Testando conta
 * System.out.println("\nConta");
 * Conta conta1 = new Conta(1, 70, true);
 * 
 * //conta1.listCodPedido.add(pedido1);
 * 
 * ContaCrud contas = new ContaCrud();
 * 
 * contas.addConta(conta1, pedido1);
 * 
 * contas.listarTodasConta();
 * 
 * 
 * Conta conta1 = new Conta(1, 70, true);
 * //conta1.listCodPedido.add(pedido1);
 * Conta conta2 = new Conta(3, 10, true);
 * Conta conta3 = new Conta(6, 5, true);
 * Conta conta4 = new Conta(8, 3, true);
 * 
 * ContaCrud contas = new ContaCrud();
 * contas.addConta(conta1);
 * contas.addConta(conta2);
 * contas.addConta(conta4);
 * contas.addConta(conta3);
 * 
 * contas.listarTodasConta();
 * System.out.println(contas.buscarConta(1));
 * contas.removerConta(6);
 * contas.listarTodasConta();
 * 
 * 
 */