package restaurante.fachada;

import restaurante.repositorio.*;

public class UsuarioFacade {
    private UsuarioCrud usuarioCrud;

    public UsuarioFacade() {
        usuarioCrud = new UsuarioCrud();
    }

    public boolean acesso() {
        return usuarioCrud.acesso();
    }

    public void cadUsuario(String nome, String login, String senha, boolean userGerente, boolean userGarcom) {
        usuarioCrud.cadUsuario(nome, login, senha, userGerente, userGarcom);
    }

    public boolean verificaCred(String login, String senha) {
        return usuarioCrud.verificaCred(login, senha);
    }

    public void listaUser() {
        usuarioCrud.listaUser();
    }

    public void delUser(String login) {
        usuarioCrud.delUser(login);
    }

    public void alterarCredenciais(String login) {
        usuarioCrud.alterarCredenciais(login);
    }
}
