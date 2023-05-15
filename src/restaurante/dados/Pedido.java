package restaurante.dados;

import java.util.ArrayList;

public class Pedido{
    private int codPedido;
    private int codMesa;
    public ArrayList<Produto> listcodProduto = new ArrayList<Produto>();
    private double total;
    private boolean statusPedido;

    public Pedido(int codPedido, int codMesa, double total, boolean status){
        this.codPedido = codPedido;
        this.codMesa = codMesa;
        this.total = total;
        this.statusPedido = status;
    }
    @Override
	public String toString() {
		String textoPedidos = "Pedido: " + this.codPedido + 
				" -> Produtos: " + this.listcodProduto + 
                " -> Mesa: " + this.codMesa + 
                " -> Total: " + this.total + 
                " -> Status do Pedido: " + this.statusPedido ;
		return textoPedidos;
	}

    public int getCodPedido() {
        return codPedido;
    }
    public void setCodPedido(int codPedido) {
        this.codPedido = codPedido;
    }
    public int getCodMesa() {
        return codMesa;
    }
    public void setCodMesa(int codMesa) {
        this.codMesa = codMesa;
    }
    public ArrayList<Produto> getListcodProduto() {
        return listcodProduto;
    }
    public void setListcodProduto(ArrayList<Produto> listcodProduto) {
        this.listcodProduto = listcodProduto;
    }
    public double getTotal() {
        return total;
    }
    public void setTotal(double total) {
        this.total = total;
    }
    public boolean isStatusPedido() {
        return statusPedido;
    }
    public void setStatusPedido(boolean statusPedido) {
        this.statusPedido = statusPedido;
    }
}