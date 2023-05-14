package restaurante.repositorio;

import java.util.ArrayList;
import restaurante.dados.Conta;

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
    
    public void addConta(Conta conta){
        this.listConta.add(conta);
    }
    public void listarTodasConta(){
        System.out.println("----- Todas as contas -----");
        for(Conta contas: listConta){
            System.out.println("\n" + contas);
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
            finalizaConta.setStatusConta(false);
        }else{
            System.out.println("-> Conta não encontrada no sistema ");
        }
    }
    
    public ArrayList<Conta> getListConta() {
        return listConta;
    }
    public void setListConta(ArrayList<Conta> listConta) {
        this.listConta = listConta;
    } 
}
