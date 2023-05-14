package restaurante.teste;

import restaurante.dados.Clube;
import restaurante.dados.Conta;
import restaurante.repositorio.ContaCrud;

public class Teste{
    public static void main(String[] args) {
        System.out.println("\n---------- RESTAURANTE ----------");
        
        //Testando conta
        Conta conta1 = new Conta(1, 70, true);
        conta1.listCodPedido.add(pedido1);
        Conta conta2 = new Conta(3, 10, true);
        Conta conta3 = new Conta(6, 5, true);
        Conta conta4 = new Conta(8, 3, true);

        ContaCrud contas = new ContaCrud();
        contas.addConta(conta1);
        contas.addConta(conta2);
        contas.addConta(conta4);
        contas.addConta(conta3);

        contas.listarTodasConta();
        System.out.println(contas.buscarConta(1));
        contas.removerConta(6);
        contas.listarTodasConta();
    }
}