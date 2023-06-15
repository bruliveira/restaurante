package restaurante.teste;

import java.util.*;
import javax.swing.*;

import restaurante.GUI.*;
import restaurante.dados.*;
import restaurante.fachada.*;
import restaurante.negocio.ICategoria;
import restaurante.repositorio.*;

public class Main {

    public static void main(String[] args) {
        MenuPrincipal();
    }

    public static void MenuPrincipal() {
        CategoriaCrud categoria = new CategoriaCrud();
        CategoriaGUI categoriaGUI = new CategoriaGUI(categoria);
        UsuarioCrud user = new UsuarioCrud();
        ICategoria categoriaCrud = new CategoriaCrud();
        CategoriaFacade categoriaFacade = new CategoriaFacade(categoriaCrud);
        ProdutoGUI produtoGUI = new ProdutoGUI(categoriaFacade);
        PedidoGUI pedidoGUI = new PedidoGUI(null);

        String[] opcoes = { "Usuários", "Categorias", "Produtos", "Pedidos", "Sair" };

        try {
            int escolha = JOptionPane.showOptionDialog(null, "Selecione uma opção:", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            while (escolha != opcoes.length - 1) {
                trataOpcao(escolha, user, categoriaFacade, categoriaGUI, produtoGUI, pedidoGUI);
                escolha = JOptionPane.showOptionDialog(null, "Selecione uma opção:", "Menu",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void trataOpcao(int escolha, UsuarioCrud user, CategoriaFacade categoriaFacade,
            CategoriaGUI categoriaGUI, ProdutoGUI produtoGUI, PedidoGUI pedidoGUI) { // Update the parameter type
        switch (escolha) {
            case 0:
                if (verificarAcesso(user)) {
                    UsuarioGUI usuarioGUI = new UsuarioGUI(user);
                    usuarioGUI.exibirMenu();
                }
                break;

            case 1:
                categoriaGUI.exibirMenu();
                break;

            case 2:
                produtoGUI.exibirMenu();
                break;

            case 3:
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opção inválida. Tente novamente.");
                break;
        }
    }

    public static boolean verificarAcesso(UsuarioCrud user) {
        return user.acesso();
    }
}
