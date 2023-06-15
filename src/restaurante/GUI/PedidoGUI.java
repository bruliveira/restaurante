package restaurante.GUI;

import javax.swing.*;
import java.awt.GridLayout;

import restaurante.negocio.IPedido;

public class PedidoGUI {

    IPedido pedidoFacade;

    JPanel pedidoPanel;

    public PedidoGUI(IPedido pedidoFacade) {
        this.pedidoFacade = pedidoFacade;
        pedidoPanel = new JPanel(new GridLayout(0, 1));
    }

    public void exibirMenu() {
        String[] opcoes = { "Anotar Pedido", "Finalizar Pedido", "Listar Pedido", "Listar Todos os Pedidos" };

        while (true) {
            int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione uma opção:", "Menu de Pedidos",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            switch (opcaoSelecionada) {
                case 0:
                    anotarPedido();
                    break;
                case 1:
                    finalizarPedido();
                    break;
                case 2:
                    listarPedido();
                    break;
                case 3:
                    listarTodosPedidos();
                    break;
                default:
                    return; // Encerra o método e retorna ao menu de opções
            }
        }
    }

    private void anotarPedido() {
        String codPedidoStr = JOptionPane.showInputDialog(null, "Digite o código do pedido:");

        if (codPedidoStr != null) {
            int codPedido = Integer.parseInt(codPedidoStr);
            pedidoFacade.anotarPedido(codPedido);
        } else {
            JOptionPane.showMessageDialog(null, "Digite um código válido!");
        }
    }

    private void finalizarPedido() {
        String codPedidoStr = JOptionPane.showInputDialog(null, "Digite o código do pedido:");
        String valorPagoStr = JOptionPane.showInputDialog(null, "Digite o valor pago:");

        if (codPedidoStr != null && valorPagoStr != null) {
            int codPedido = Integer.parseInt(codPedidoStr);
            double valorPago = Double.parseDouble(valorPagoStr);
            pedidoFacade.finalizarPedido(codPedido, valorPago);
        } else {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
        }
    }

    private void listarPedido() {
        String codPedidoStr = JOptionPane.showInputDialog(null, "Digite o código do pedido:");

        if (codPedidoStr != null) {
            int codPedido = Integer.parseInt(codPedidoStr);
            pedidoFacade.listarPedido(codPedido);
        } else {
            JOptionPane.showMessageDialog(null, "Digite um código válido!");
        }
    }

    private void listarTodosPedidos() {
        pedidoFacade.listarTodosPedidos();
    }

    public void exibirPedido(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
}
