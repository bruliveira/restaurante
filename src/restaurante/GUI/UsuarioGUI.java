package restaurante.GUI;

import restaurante.negocio.*;
import restaurante.dados.*;

import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class UsuarioGUI {

    private IUsuario usuarioCrud;

    public UsuarioGUI(IUsuario usuarioCrud) {
        this.usuarioCrud = usuarioCrud;
    }

    public void exibirMenu() {
        String[] opcoes = { "Cadastrar Usuário", "Listar Usuários", "Remover Usuário", "Alterar Credenciais" };

        while (true) {
            int opcaoSelecionada = JOptionPane.showOptionDialog(null, "Selecione uma opção:", "Menu de Usuário",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            switch (opcaoSelecionada) {
                case 0:
                    cadastrarUsuario();

                    break;
                case 1:
                    listarUsuarios();
                    break;
                case 2:
                    String delLogin = JOptionPane.showInputDialog("Login do usuário a ser removido:");
                    usuarioCrud.delUser(delLogin);
                    break;
                case 3:
                    String altLogin = JOptionPane.showInputDialog("Login do usuário a ter as credenciais alteradas:");
                    usuarioCrud.alterarCredenciais(altLogin);
                    break;
                default:
                    return; // Encerra o método e retorna ao menu de opções
            }
        }
    }

    private boolean cadastrarUsuario() {
        while (true) {
            try {
                // Criação do painel para o cadastro do usuário
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

                JTextField nomeField = new JTextField(10);
                panel.add(new JLabel("Nome:"));
                panel.add(nomeField);

                JTextField loginField = new JTextField(10);
                panel.add(new JLabel("Login:"));
                panel.add(loginField);

                JPasswordField senhaField = new JPasswordField(10);
                panel.add(new JLabel("Senha:"));
                panel.add(senhaField);

                JCheckBox mostrarSenhaCheckBox = new JCheckBox("Ver senha");
                mostrarSenhaCheckBox.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        senhaField.setEchoChar(mostrarSenhaCheckBox.isSelected() ? '\0' : '*');
                    }
                });
                panel.add(mostrarSenhaCheckBox);

                ButtonGroup tipoUsuarioGroup = new ButtonGroup();
                JRadioButton gerenteRadioButton = new JRadioButton("Gerente");
                JRadioButton garcomRadioButton = new JRadioButton("Garçom");
                tipoUsuarioGroup.add(gerenteRadioButton);
                tipoUsuarioGroup.add(garcomRadioButton);
                panel.add(new JLabel("Tipo de Usuário:"));
                panel.add(gerenteRadioButton);
                panel.add(garcomRadioButton);

                int option = JOptionPane.showOptionDialog(null, panel, "Cadastro de Usuário",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null);

                if (option == JOptionPane.OK_OPTION) {
                    String nome = nomeField.getText();
                    String login = loginField.getText();
                    String senha = new String(senhaField.getPassword());

                    if (nome.trim().isEmpty() || login.trim().isEmpty() || senha.isEmpty()) {
                        int opcao = JOptionPane.showConfirmDialog(null, "Existem campos em branco. Deseja continuar?",
                                "Cadastro de Usuário", JOptionPane.YES_NO_OPTION);
                        if (opcao == JOptionPane.NO_OPTION) {
                            return false; // Encerra o loop e retorna ao menu de opções
                        }
                    } else {
                        boolean isGerente = gerenteRadioButton.isSelected();
                        boolean isGarcom = garcomRadioButton.isSelected();

                        usuarioCrud.cadUsuario(nome, login, senha, isGerente, isGarcom);

                        return true; // Usuário cadastrado com sucesso, encerra o loop
                    }
                } else {
                    return false; // Encerra o loop e retorna ao menu de opções
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário: " + e.getMessage());
                int opcao = JOptionPane.showConfirmDialog(null, "Deseja tentar cadastrar novamente?",
                        "Cadastro de Usuário", JOptionPane.YES_NO_OPTION);
                if (opcao == JOptionPane.NO_OPTION) {
                    return false; // Encerra o loop e retorna ao menu de opções
                }
            }
        }
    }

    private void listarUsuarios() {
        List<Usuario> usuarios = usuarioCrud.getUsuarios();

        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Usuários:\n");

        for (Usuario usuario : usuarios) {
            String nome = usuario.getNome();
            String login = usuario.getLogin();
            String tipo = (usuario instanceof Gerente) ? "Gerente" : "Garçom";

            sb.append("Nome: ").append(nome).append("\n");
            sb.append("Login: ").append(login).append("\n");
            sb.append("Tipo: ").append(tipo).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, sb.toString());
    }
}
