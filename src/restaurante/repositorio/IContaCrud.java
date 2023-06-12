package restaurante.repositorio;

import restaurante.dados.Conta;
import restaurante.dados.Pedido;

public interface IContaCrud {
    void criar();
    void addConta(Conta conta, Pedido pedidos);
    void listarTodasConta();
    void listarTodasContaAbertas();
    Conta buscarConta(int codConta);
    void removerConta(int codConta);
    void finalizarConta(int codConta);
    void alterarConta(int codContaAnterior, int codContaNova);
}
