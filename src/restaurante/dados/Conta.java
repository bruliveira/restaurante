package restaurante.dados;

import java.util.ArrayList;

public class Conta {
    public int codConta;
    public double total;
    public boolean statusConta;
    public ArrayList<Clube> listCodPedido = new ArrayList<Clube>();

    public Conta(){
    }
    public Conta(int codConta, double total, boolean statusConta){
        this.codConta = codConta;
        this.total = total;
        this.statusConta = statusConta;
    }
    @Override
	public String toString() {
		String textoContas = "-> Conta " + this.codConta + 
				"\nPedidos: " + this.listCodPedido + 
                "\nTotal: " + this.total + 
                "\nStatus da conta: " + this.statusConta;
		return textoContas;
	}

    public int getCodConta() {
        return codConta;
    }
    public void setCodConta(int codConta) {
        this.codConta = codConta;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public boolean getStatusConta() {
        return statusConta;
    }
    public void setStatusConta(boolean statusConta) {
        this.statusConta = statusConta;
    }
    public ArrayList<Clube> getListCodPedido() {
        return listCodPedido;
    }
    public void setListCodPedido(ArrayList<Clube> listCodPedido) {
        this.listCodPedido = listCodPedido;
    }
}