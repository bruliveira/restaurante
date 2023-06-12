package restaurante.repositorio;

import restaurante.dados.UsuarioGarcom;

public interface IGarcomCrud {
    void criar();
    void CadastraGarcom(UsuarioGarcom g);
    boolean BuscarNome(String n);
    String ListaGarcom();
    void EditarGarcom(String loginN, String senhaN, UsuarioGarcom g);
    void Demitir(UsuarioGarcom g);
    UsuarioGarcom Buscar(String l);
}
