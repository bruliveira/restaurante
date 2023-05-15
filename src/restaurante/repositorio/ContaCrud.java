package restaurante.repositorio;

import java.util.ArrayList;
import restaurante.dados.Conta;
import restaurante.dados.Pedido;

public class ContaCrud {
    public ArrayList<Conta> listConta = new ArrayList<Conta>();

    
    //Login - Depois modificar daqui
    public void login(int cod, double tota){
        //Conta nomeLogin = null;
        for(Conta contas: listConta){
            if(cod == contas.getCodConta()){
                if(tota == contas.getTotal()){
                    System.out.println("\n-> Senha e login encontradas com sucesso");
                }else{
                    System.out.println("\n-> Senha incorreta");
                }
            }
        }
    }
    public void addContaPrimeira(Conta conta, Pedido pedidos){
        double totalConta = conta.getTotal() + pedidos.getTotal();
        conta.listCodPedido.add(pedidos);
        this.listConta.add(conta);
        conta.setTotal(totalConta);
    }

    public void addConta(Conta conta, Pedido pedidos){
        double totalConta = conta.getTotal() + pedidos.getTotal();
        for(Conta contas: listConta){
            //System.out.println("\n" + contas);
            if(conta.getCodConta() == contas.getCodConta()){
                //this.listaPedido.add(pedido);
                conta.listCodPedido.add(pedidos);
                conta.setTotal(totalConta);
            }else{
                conta.listCodPedido.add(pedidos);
                this.listConta.add(conta);
                conta.setTotal(totalConta);
            }
        }
    }
    public void listarTodasConta(){
        System.out.println("----- Todas as contas -----");
        for(Conta contas: listConta){
            System.out.println(contas);
        }
    }
    public Conta buscarConta(int codConta){
        for(Conta contas: listConta){
            //System.out.println("\n" + contas);
            if(codConta == contas.getCodConta()){
                return contas;
            }
        }
        return null;
    }
    public void removerConta(int codConta){
        Conta removeConta = buscarConta(codConta);
        if(removeConta != null){
            listConta.remove(removeConta);
        }else{
            System.out.println("-> Conta não encontrada no sistema ");
        }
    }
    public void finalizarConta(int codConta){
        Conta finalizaConta = buscarConta(codConta);
        if(finalizaConta != null){
            double totalPagar = finalizaConta.getTotal();
            System.out.println("\n-> Total da conta a ser pagar: " + totalPagar);
            finalizaConta.setStatusConta(false);
        }else{
            System.out.println("\n-> Conta não encontrada no sistema ");
        }
    }
    
    public ArrayList<Conta> getListConta() {
        return listConta;
    }
    public void setListConta(ArrayList<Conta> listConta) {
        this.listConta = listConta;
    } 
}
