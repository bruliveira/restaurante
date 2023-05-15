package restaurante.dados;

import java.util.ArrayList;

public class Pedido{
    private int codPedido;
    public ArrayList<Produto> listcodProduto = new ArrayList<Produto>();
    private double total;
    private boolean statusPedido;

    public Pedido(int codPedido, double total, boolean status){
        this.codPedido = codPedido;
        this.total = total;
        this.statusPedido = status;
    }
    @Override
	public String toString() {
		String textoPedidos = "Pedido: " + this.codPedido + 
				" -> Produtos: " + this.listcodProduto +
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