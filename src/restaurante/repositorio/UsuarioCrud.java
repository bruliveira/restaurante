package restaurante.repositorio;

import restaurante.dados.*;
import restaurante.negocio.*;
import restaurante.teste.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class UsuarioCrud implements IUsuario {

    private List<Usuario> usuarios;

    @Override
    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public UsuarioCrud() {
        usuarios = new ArrayList<>();
    }

    @Override
    public boolean acesso() {
        boolean isAdmin = false;
        boolean isGerente = false;

        String adminLogin = "admin";
        String adminSenha = "admin";

        // Tela de acesso
        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("Login:"));
        JTextField loginField = new JTextField(10);
        panel.add(loginField);
        panel.add(new JLabel("Senha:"));
        JPasswordField senhaField = new JPasswordField(10);
        panel.add(senhaField);

        JOptionPane optionPane = new JOptionPane(panel, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
        JDialog dialog = optionPane.createDialog(null, "Acesso");

        // Adicionar listener para tratar o fechamento do diálogo
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); // Impede que o botão "X" feche o diálogo
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Retornar ao menu principal
                Main.MenuPrincipal();
                dialog.dispose();
            }
        });

        dialog.setVisible(true);

        // Verificar o resultado do diálogo
        int result = (Integer) optionPane.getValue();

        if (result == JOptionPane.OK_OPTION) {
            // Obter o login e a senha digitados
            String login = loginField.getText();
            String senha = new String(senhaField.getPassword());

            if (adminLogin.equals(login) && adminSenha.equals(senha)) {
                isAdmin = true;
            } else {
                for (Usuario usuario : usuarios) {
                    if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                        if (usuario instanceof Gerente) {
                            isGerente = true;
                            break;
                        }
                    }
                }
            }

            if (isAdmin || isGerente) {
                dialog.dispose(); // Fechar a tela de acesso
                return true; // Acesso concedido
            } else {
                JOptionPane.showMessageDialog(null, "Credenciais incorretas. Acesso negado!");
                return false; // Acesso negado
            }
        } else {
            Main.MenuPrincipal();
            dialog.dispose(); // Fechar a tela de acesso
            return false; // Acesso negado
        }
    }

    @Override
    public void cadUsuario(String nome, String login, String senha, boolean userGerente, boolean userGarcom) {
        if (!userGerente && !userGarcom) {
            JOptionPane.showMessageDialog(null, "Tipo de usuário inválido!");
            return; // Finalizar o cadastro
        }

        // Verificar se o usuário já foi cadastrado antes de adicionar
        boolean usuarioJaCadastrado = verificaUsuarioCadastrado(login);
        if (usuarioJaCadastrado) {
            JOptionPane.showMessageDialog(null, "Usuário já cadastrado com o login informado!");
            return; // Finalizar o cadastro
        }

        // Criar e adicionar o novo usuário
        if (userGerente) {
            Gerente gerente = new Gerente(nome, login, senha);
            usuarios.add(gerente);
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        }
        if (userGarcom) {
            Garcom garcom = new Garcom(nome, login, senha);
            usuarios.add(garcom);
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
        }
    }

    @Override
    public boolean verificaCred(String login, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                return true; // Credenciais corretas
            }
        }
        return false; // Credenciais incorretas
    }

    @Override
    public void listaUser() {
        StringBuilder lista = new StringBuilder("Lista de Usuários:\n");
        for (Usuario usuario : usuarios) {
            lista.append(usuario.getNome()).append(" - ").append(usuario.getLogin()).append(" - ")
                    .append(usuario.getTipo()).append("\n");
        }
        JOptionPane.showMessageDialog(null, lista.toString());
    }

    @Override
    public void delUser(String login) {
        Usuario usuarioRemover = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                usuarioRemover = usuario;
                break;
            }
        }

        if (usuarioRemover != null) {
            usuarios.remove(usuarioRemover);
            JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
        }
    }

    @Override
    public void alterarCredenciais(String login) {
        Usuario usuarioAlterar = null;
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                usuarioAlterar = usuario;
                break;
            }
        }

        if (usuarioAlterar != null) {
            // Painel para editar as credenciais
            JPanel panel = new JPanel(new GridBagLayout());
            GridBagConstraints constraints = new GridBagConstraints();
            constraints.fill = GridBagConstraints.HORIZONTAL;
            constraints.insets = new Insets(5, 5, 5, 5);

            // Novo nome
            JLabel nomeLabel = new JLabel("Novo Nome:");
            JTextField nomeField = new JTextField(10);
            constraints.gridx = 0;
            constraints.gridy = 0;
            panel.add(nomeLabel, constraints);
            constraints.gridx = 1;
            panel.add(nomeField, constraints);

            // Novo login
            JLabel novoLoginLabel = new JLabel("Novo Login:");
            JTextField novoLoginField = new JTextField(10);
            constraints.gridx = 0;
            constraints.gridy = 1;
            panel.add(novoLoginLabel, constraints);
            constraints.gridx = 1;
            panel.add(novoLoginField, constraints);

            // Nova senha
            JLabel novaSenhaLabel = new JLabel("Nova Senha:");
            JPasswordField novaSenhaField = new JPasswordField(10);
            constraints.gridx = 0;
            constraints.gridy = 2;
            panel.add(novaSenhaLabel, constraints);
            constraints.gridx = 1;
            panel.add(novaSenhaField, constraints);

            // Mostrar senha
            JCheckBox mostrarSenhaCheckbox = new JCheckBox("Mostrar senha");
            constraints.gridx = 1;
            constraints.gridy = 3;
            constraints.anchor = GridBagConstraints.WEST;
            panel.add(mostrarSenhaCheckbox, constraints);

            // Opções de seleção para tipo de usuário
            String[] tiposUsuario = { "Gerente", "Garçom" };
            ButtonGroup tipoGroup = new ButtonGroup();
            JPanel tipoPanel = new JPanel();
            tipoPanel.setBorder(BorderFactory.createTitledBorder("Tipo de Usuário"));
            tipoPanel.setLayout(new BoxLayout(tipoPanel, BoxLayout.Y_AXIS));
            for (String tipo : tiposUsuario) {
                JRadioButton tipoButton = new JRadioButton(tipo);
                tipoGroup.add(tipoButton);
                tipoPanel.add(tipoButton);
            }
            constraints.gridx = 0;
            constraints.gridy = 4;
            constraints.gridwidth = 2;
            constraints.anchor = GridBagConstraints.CENTER;
            panel.add(tipoPanel, constraints);

            JOptionPane optionPane = new JOptionPane(panel, JOptionPane.PLAIN_MESSAGE, JOptionPane.OK_CANCEL_OPTION);
            JDialog dialog = optionPane.createDialog(null, "Editar Credenciais");

            // Adicionar listener para tratar o fechamento do diálogo
            dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE); // Impede que o botão "X" feche o diálogo
            dialog.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    dialog.dispose();
                }
            });

            // Listener para mostrar/ocultar a senha
            mostrarSenhaCheckbox.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (mostrarSenhaCheckbox.isSelected()) {
                        novaSenhaField.setEchoChar((char) 0);
                    } else {
                        novaSenhaField.setEchoChar('*');
                    }
                }
            });

            // Preencher os campos com os dados atuais do usuário
            nomeField.setText(usuarioAlterar.getNome());
            novoLoginField.setText(usuarioAlterar.getLogin());
            novaSenhaField.setText(usuarioAlterar.getSenha());

            dialog.setVisible(true);

            // Verificar o resultado do diálogo
            int result = (Integer) optionPane.getValue();

            if (result == JOptionPane.OK_OPTION) {
                // Obter os novos valores dos campos
                String novoNome = nomeField.getText();
                String novoLogin = novoLoginField.getText();
                String novaSenha = new String(novaSenhaField.getPassword());

                // Verificar se algum campo está vazio
                if (novoNome.isEmpty() || novoLogin.isEmpty() || novaSenha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Nenhum campo pode ficar vazio!");
                    return;
                }

                // Verificar o tipo de usuário selecionado
                int tipoIndex = -1;
                Enumeration<AbstractButton> tipoButtons = tipoGroup.getElements();
                List<AbstractButton> tipoButtonList = new ArrayList<>();
                while (tipoButtons.hasMoreElements()) {
                    AbstractButton tipoButton = tipoButtons.nextElement();
                    tipoButtonList.add(tipoButton);
                }

                for (int i = 0; i < tipoButtonList.size(); i++) {
                    if (tipoButtonList.get(i).isSelected()) {
                        tipoIndex = i;
                        break;
                    }
                }

                if (tipoIndex == -1) {
                    JOptionPane.showMessageDialog(null, "Selecione o tipo de usuário!");
                    return;
                }

                // Atualizar os dados do usuário
                usuarioAlterar.setNome(novoNome);
                usuarioAlterar.setLogin(novoLogin);
                usuarioAlterar.setSenha(novaSenha);

                // Verificar o tipo selecionado e atualizar o objeto de acordo
                if (tipoIndex == 0) {
                    if (!(usuarioAlterar instanceof Gerente)) {
                        Gerente novoGerente = new Gerente(novoNome, novoLogin, novaSenha);
                        usuarios.set(usuarios.indexOf(usuarioAlterar), novoGerente);
                    }
                } else if (tipoIndex == 1) {
                    if (!(usuarioAlterar instanceof Garcom)) {
                        Garcom novoGarcom = new Garcom(novoNome, novoLogin, novaSenha);
                        usuarios.set(usuarios.indexOf(usuarioAlterar), novoGarcom);
                    }
                }

                JOptionPane.showMessageDialog(null, "Credenciais alteradas com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Edição de credenciais cancelada!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
        }
    }

    public boolean verificaUsuarioCadastrado(String login) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                return true; // Usuário já cadastrado
            }
        }
        return false; // Usuário não cadastrado
    }
}
