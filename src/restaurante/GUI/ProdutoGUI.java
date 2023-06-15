package restaurante.GUI;

import javax.swing.*;

import java.awt.GridLayout;
import java.util.List;

import restaurante.dados.*;
import restaurante.fachada.*;
import restaurante.negocio.*;
import restaurante.repositorio.*;

public class ProdutoGUI {

    private IProduto produtoFacade;
    private CategoriaFacade categoriaFacade;
    private ProdutoCrud produtoCrud;

    public ProdutoGUI() {
        // Initialize the ProdutoFacade and CategoriaFacade instances
        CategoriaCrud categoriaCrud = new CategoriaCrud();
        ProdutoCrud produtoCrud = new ProdutoCrud(categoriaCrud); // Provide required arguments
        categoriaFacade = new CategoriaFacade(categoriaCrud);
        produtoFacade = new ProdutoFacade(produtoCrud, categoriaCrud);
    }

    public ProdutoGUI(CategoriaFacade categoriaFacade) {
        this.categoriaFacade = categoriaFacade;
    }

    public void exibirMenu() {
        String[] opcoes = { "Cadastrar Produto", "Listar Produtos", "Excluir Produto", "Alterar Produto" };

        while (true) {
            int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione uma opção:", "Menu de Produto",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            switch (opcaoSelecionada) {
                case 0:
                    cadastrarProduto();
                    break;
                case 1:
                    listarProdutos();
                    break;
                case 2:
                    excluirProduto();
                    break;
                case 3:
                    alterarProduto();
                    break;
                default:
                    return; // Encerra o método e retorna ao menu de opções
            }
        }
    }

    private void cadastrarProduto() {
        List<Categoria> categorias = categoriaFacade.getCategorias();
        if (categorias.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma categoria cadastrada!");
            return;
        }

        // Criação do painel para o cadastro do produto
        JPanel panel = new JPanel(new GridLayout(0, 2));

        JTextField codProdutoField = new JTextField();
        panel.add(new JLabel("Código do Produto:"));
        panel.add(codProdutoField);

        JTextField nomeProdutoField = new JTextField();
        panel.add(new JLabel("Nome do Produto:"));
        panel.add(nomeProdutoField);

        JTextField precoProdutoField = new JTextField();
        panel.add(new JLabel("Preço do Produto:"));
        panel.add(precoProdutoField);

        JTextField qtdProdutoField = new JTextField();
        panel.add(new JLabel("Quantidade do Produto:"));
        panel.add(qtdProdutoField);

        JComboBox<Categoria> categoriaComboBox = new JComboBox<>(categorias.toArray(new Categoria[0]));
        panel.add(new JLabel("Categoria do Produto:"));
        panel.add(categoriaComboBox);

        int option = JOptionPane.showOptionDialog(null, panel, "Cadastro de Produto",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

        if (option == JOptionPane.OK_OPTION) {
            String codProdutoStr = codProdutoField.getText();
            String nomeProduto = nomeProdutoField.getText();
            String precoProdutoStr = precoProdutoField.getText();
            String qtdProdutoStr = qtdProdutoField.getText();

            if (codProdutoStr.trim().isEmpty() || nomeProduto.trim().isEmpty() ||
                    precoProdutoStr.trim().isEmpty() || qtdProdutoStr.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
            } else {
                int codProduto = Integer.parseInt(codProdutoStr);
                double precoProduto = Double.parseDouble(precoProdutoStr);
                int qtdProduto = Integer.parseInt(qtdProdutoStr);
                Categoria categoriaSelecionada = (Categoria) categoriaComboBox.getSelectedItem();
                produtoFacade.cadProduto(codProduto, nomeProduto, precoProduto, qtdProduto, categoriaSelecionada);
            }
        }
    }

    private void listarProdutos() {
        List<Produto> produtos = produtoFacade.listaProd();
        exibirListaProdutos(produtos);
    }

    private void excluirProduto() {
        String codProdutoStr = JOptionPane.showInputDialog(null, "Digite o código do produto:");

        if (codProdutoStr != null) {
            int codProduto = Integer.parseInt(codProdutoStr);
            produtoFacade.delProd(codProduto);
        } else {
            JOptionPane.showMessageDialog(null, "Digite um código válido!");
        }
    }

    private void alterarProduto() {
        String codProdutoStr = JOptionPane.showInputDialog(null, "Digite o código do produto:");

        if (codProdutoStr != null) {
            int codProduto = Integer.parseInt(codProdutoStr);
            produtoFacade.alteraProd(codProduto);
        } else {
            JOptionPane.showMessageDialog(null, "Digite um código válido!");
        }
    }

    private void exibirListaProdutos(List<Produto> produtos) {
        StringBuilder lista = new StringBuilder("Lista de Produtos:\n");
        for (Produto produto : produtos) {
            String tipoCategoria = categoriaFacade.obterTipoCategoria(produto.getCodCategoria());
            lista.append("Codigo do Produto: ").append(produto.getCodProduto())
                    .append(" | Tipo de Categoria: ").append(tipoCategoria)
                    .append(" | Nome: ").append(produto.getNomeProduto())
                    .append(" | Preço: ").append(produto.getPrecoProduto())
                    .append(" | Quantidade: ").append(produto.getQtdProduto()).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString());
    }

    public ProdutoGUI(ProdutoCrud produtoCrud) {
        this.produtoCrud = produtoCrud;
    }

}
