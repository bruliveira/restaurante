package restaurante.GUI;

import javax.swing.*;

import java.awt.GridLayout;

import restaurante.dados.*;
import restaurante.negocio.*;

public class CategoriaGUI {

    private ICategoria categoriaCrud;

    public CategoriaGUI(ICategoria categoriaCrud) {
        this.categoriaCrud = categoriaCrud;
    }

    public void exibirMenu() {
        String[] opcoes = { "Cadastrar Categoria", "Listar Categorias", "Alterar Categoria", "Excluir Categoria" };

        while (true) {
            int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione uma opção:", "Menu de Categoria",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            switch (opcaoSelecionada) {
                case 0:
                    cadastrarCategoria();
                    break;
                case 1:
                    listarCategorias();
                    break;
                case 2:
                    int codCategoriaAlterar = Integer
                            .parseInt(JOptionPane.showInputDialog("Informe o código da categoria a ser alterada:"));
                    alterarCategoria(codCategoriaAlterar);
                    break;
                case 3:
                    int codCategoriaExcluir = Integer
                            .parseInt(JOptionPane.showInputDialog("Informe o código da categoria a ser excluída:"));
                    excluirCategoria(codCategoriaExcluir);
                    break;
                default:
                    return; // Encerra o método e retorna ao menu de opções
            }
        }
    }

    private void cadastrarCategoria() {
        try {
            int codCategoria = Integer.parseInt(JOptionPane.showInputDialog("Informe o código da categoria:"));
            String tipoCategoria = JOptionPane.showInputDialog("Informe o tipo da categoria:");

            categoriaCrud.cadastrarCategoria(codCategoria, tipoCategoria);

            // Categoria cadastrada
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar categoria: " + e.getMessage());
        }
    }

    private void listarCategorias() {
        categoriaCrud.listarCategorias();
    }

    private void alterarCategoria(int codCategoria) {
        Categoria categoria = categoriaCrud.buscarCategoria(codCategoria);

        if (categoria != null) {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 2));

            JLabel lblCodigoAtual = new JLabel("Código Atual:");
            JTextField txtCodigoAtual = new JTextField(String.valueOf(codCategoria));
            txtCodigoAtual.setEditable(false);

            JLabel lblNovoCodigo = new JLabel("Novo Código:");
            JTextField txtNovoCodigo = new JTextField(10);

            JLabel lblNovoTipo = new JLabel("Novo Tipo:");
            JTextField txtNovoTipo = new JTextField(10);

            panel.add(lblCodigoAtual);
            panel.add(txtCodigoAtual);
            panel.add(lblNovoCodigo);
            panel.add(txtNovoCodigo);
            panel.add(lblNovoTipo);
            panel.add(txtNovoTipo);

            int result = JOptionPane.showConfirmDialog(null, panel, "Alterar Categoria",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                String novoCodigoString = txtNovoCodigo.getText();
                String novoTipo = txtNovoTipo.getText();

                if (!novoCodigoString.isEmpty() && !novoTipo.isEmpty()) {
                    try {
                        int novoCodigo = Integer.parseInt(novoCodigoString);
                        categoriaCrud.alteraCategoria(codCategoria, novoCodigo, novoTipo);
                        // Categoria alterada
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "O novo código deve ser um valor numérico!");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Novo código e novo tipo da categoria devem ser preenchidos!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Categoria não encontrada!");
        }
    }

    private void excluirCategoria(int codCategoria) {
        try {
            categoriaCrud.delCategoria(codCategoria);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir categoria: " + e.getMessage());
        }
    }
}
