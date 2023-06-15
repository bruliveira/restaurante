package restaurante.repositorio;

import restaurante.dados.*;
import restaurante.negocio.*;
import java.util.*;

import javax.swing.JOptionPane;

public class PedidoCrud implements IPedido {

    private Map<Integer, List<Pedido>> pedidos;
    private List<Produto> produtos;
    IProduto produtoCrud;
    IUsuario usuarioCrud;

    public PedidoCrud(ProdutoCrud produtoCrud, Conta conta, IUsuario usuarioCrud) {
        pedidos = new HashMap<>();
        produtos = produtoCrud.getProdutos();
        this.produtoCrud = produtoCrud;
        this.usuarioCrud = usuarioCrud;
    }

    @Override
    public void anotarPedido(int codPedido) {
        // Check if there are registered products before taking the order
        if (produtos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não há produtos cadastrados!");
            return;
        }

        // Obtain the product code and desired quantity
        List<Produto> itens = new ArrayList<>();
        while (true) {
            String inputCodProduto = JOptionPane
                    .showInputDialog("Digite o código do produto / Selecione sair para realizar o pedido:");
            if (inputCodProduto == null || inputCodProduto.equalsIgnoreCase("Sair")) {
                break;
            }

            if (inputCodProduto.isEmpty()) {
                JOptionPane.showMessageDialog(null, "O código do produto não pode ser vazio!");
                continue;
            }

            int codProdutoEscolhido;
            try {
                codProdutoEscolhido = Integer.parseInt(inputCodProduto);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Codigo de produto inválido!");
                continue;
            }

            Produto produtoEscolhido = null;
            for (Produto produto : produtos) {
                if (produto.getCodProduto() == codProdutoEscolhido) {
                    produtoEscolhido = produto;
                    break;
                }
            }

            if (produtoEscolhido == null) {
                JOptionPane.showMessageDialog(null, "Produto não encontrado!");
                continue;
            }

            String inputQuantidade = JOptionPane.showInputDialog("Digite a quantidade:");
            if (inputQuantidade == null || inputQuantidade.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Quantidade não pode ser vazia!");
                continue;
            }

            int quantidade;
            try {
                quantidade = Integer.parseInt(inputQuantidade);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Quantidade inválida!");
                continue;
            }

            if (quantidade <= 0) {
                JOptionPane.showMessageDialog(null, "Quantidade deve ser maior que zero!");
                continue;
            }

            int qtdProdutoDisponivel = produtoEscolhido.getQtdProduto();
            if (quantidade > qtdProdutoDisponivel) {
                JOptionPane.showMessageDialog(null,
                        "Quantidade não disponivel para este produto. Quantidade em estoque é: "
                                + qtdProdutoDisponivel);
                continue;
            }

            produtoEscolhido.setQtdProduto(qtdProdutoDisponivel - quantidade);

            boolean produtoJaExiste = false;
            for (Produto item : itens) {
                if (item.getCodProduto() == produtoEscolhido.getCodProduto()) {
                    item.setQtdProduto(item.getQtdProduto() + quantidade);
                    produtoJaExiste = true;
                    break;
                }
            }

            if (!produtoJaExiste) {
                Produto item = new Produto(produtoEscolhido.getCodProduto(), produtoEscolhido.getCodCategoria(),
                        produtoEscolhido.getNomeProduto(), produtoEscolhido.getPrecoProduto(), quantidade);
                itens.add(item);
            }
        }

        // Check if any products were added to the order
        if (itens.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pedido vazio!");
            return;
        }

        // Check if the order code already exists
        if (pedidos.containsKey(codPedido)) {
            int resposta = JOptionPane.showConfirmDialog(null,
                    "Codigo da Mesa já existente! Deseja adicionar os produtos mesmo assim?");
            if (resposta == JOptionPane.YES_OPTION) {
                List<Pedido> pedidosList = pedidos.get(codPedido);
                Pedido pedidoExistente = pedidosList.get(0);
                for (Produto item : itens) {
                    boolean produtoJaExiste = false;
                    for (Produto produtoExistente : pedidoExistente.getItens()) {
                        if (produtoExistente.getCodProduto() == item.getCodProduto()) {
                            produtoExistente.setQtdProduto(produtoExistente.getQtdProduto() + item.getQtdProduto());
                            produtoJaExiste = true;
                            break;
                        }
                    }
                    if (!produtoJaExiste) {
                        pedidoExistente.getItens().add(item);
                    }
                }
                JOptionPane.showMessageDialog(null, "Itens adicionados ao pedido existente!");
            } else {
                JOptionPane.showMessageDialog(null, "Pedido não alterado!");
            }
            return;
        }

        List<Pedido> pedidosList = new ArrayList<>();
        Pedido pedido = new Pedido(codPedido);
        pedido.setCodPedido(codPedido);
        pedido.setItens(itens);
        pedidosList.add(pedido);
        pedidos.put(codPedido, pedidosList);
        JOptionPane.showMessageDialog(null, "Pedido realizado!");
    }

    @Override
    public void finalizarPedido(int codPedido, double valorPago) {
        // Implementação omitida
    }

    @Override
    public void listarPedido(int codPedido) {
        // Implementação omitida
    }

    @Override
    public void listarTodosPedidos() {
        // Implementação omitida
    }

    public List<Produto> getProdutos() {
        return produtoCrud.getProdutos();
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
