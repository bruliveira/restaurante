package restaurante.repositorio;

import java.util.ArrayList;
import restaurante.dados.Conta;
import restaurante.dados.Pedido;

public class ContaCrud {
    public ArrayList<Conta> listConta = new ArrayList<Conta>();

    public void addConta(Conta conta, Pedido pedidos){
        double totalConta = conta.getTotal() + pedidos.getTotal();
        Conta contaAdd = null;
        for(Conta contas: listConta){
            if(conta.getCodConta() == contas.getCodConta()){
                contaAdd = contas;
                break;
            }
        }
        if(contaAdd != null){
            conta.listCodPedido.add(pedidos);
            conta.setTotal(totalConta);
        }else{
            conta.listCodPedido.add(pedidos);
            this.listConta.add(conta);
            conta.setTotal(totalConta);
        }
    }
    public void listarTodasConta(){
        System.out.println("----- Todas as contas -----");
        for(Conta contas: listConta){
            System.out.println(contas);
        }
    }
    public void listarTodasContaAbertas(){
        System.out.println("----- Contas em aberto -----");
        for(Conta contas: listConta){
            if(contas.getStatusConta() == true){
                System.out.println(contas);
            }
        }
    }
    public Conta buscarConta(int codConta){
        for(Conta contas: listConta){
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
    public void alterarConta(int codContaAnterior, int codContaNova){
        Conta alteraConta = buscarConta(codContaAnterior);
        if(alteraConta != null){
            System.out.println("Código anterior: " + alteraConta.getCodConta());
            alteraConta.setCodConta(codContaNova);
            System.out.println("Código atual: " + alteraConta.getCodConta());
        }

    }

    public ArrayList<Conta> getListConta() {
        return listConta;
    }
    public void setListConta(ArrayList<Conta> listConta) {
        this.listConta = listConta;
    } 
}
