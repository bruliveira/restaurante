package restaurante.negocio;

import java.util.List;

import restaurante.dados.Usuario;

public interface IUsuario {

    List<Usuario> getUsuarios();

    boolean acesso();

    void cadUsuario(String nome, String login, String senha, boolean userGerente, boolean userGarcom);

    boolean verificaCred(String login, String senha);

    void listaUser();

    void delUser(String login);

    void alterarCredenciais(String login);
}
