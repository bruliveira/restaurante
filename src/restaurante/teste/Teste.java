package restaurante.teste;
import restaurante.dados.*;
import restaurante.repositorio.CategoriaCrud;
import restaurante.repositorio.GarcomCrud;
import restaurante.repositorio.ProdutoCrud;


public class Teste{

    public static void main(String[] args) {
        System.out.println("\n---------- RESTAURANTE ----------");

        //cadastros
        UsuarioAdministrador adm = new UsuarioAdministrador("eu","eu","123");
        new ProdutoCrud().Criar();
        new GarcomCrud().criar();
        new CategoriaCrud().Criar();
        //menu
        Menu menu = new Menu();
        menu.TelaAdministrador(adm);
    }
}
