package restaurante.repositorio;

import restaurante.dados.UsuarioGarcom;

public interface IRepositorioGarcom {
    void criar();
    void CadastraGarcom();
    void Demitir();
    UsuarioGarcom Buscar(String l);
    boolean BuscarNome(String n);
    void ListaGarcom();
    void ConsutarGarcom();
    void EditarGarcom();
}
