package restaurante.repositorio;

import java.util.ArrayList;
import java.util.Scanner;

import restaurante.dados.Categoria;
import restaurante.dados.Produto;




public class ProdutoCrud {
	
	public static int codigo = 0;
	static Scanner scanner = new Scanner(System.in);
	
	private static ArrayList<Produto> lisProduto= new ArrayList<Produto>();
	
	public static void Criar()
	{
		lisProduto.add(new Produto("laranja",23,12,15,64));
	}
	
	public static void CadastraProduto(Produto p)
	{
		lisProduto.add(p);	
		
	}
	
	public static void Removerproduto(Produto p)
	{
		
		lisProduto.remove(p);

	}
	
	public static Produto Buscar(String l)
	{
		for(Produto p : lisProduto)
		{
			
			if(l.equals(p.getNome()))
			{
				return p;
			}
			
		}
		return null;
	}
	
	public static boolean BuscarNome(String n)
	{
		for(Produto p : lisProduto)
		{
			
			if(n.equals(p.getNome()))
			{
				return true;
			}
			
		}
		
		return false;
	}
	
	public static String ListaProduto(Categoria c)
	{	
		String lista= "";
		
		for(Produto p : lisProduto)
		{
			if(c.getCodCategoria() == p.getCodigoCategoria())
			{
				lista += "|" + p.getCodigoCategoria() + "|" + p.getCodigo() + "|" + p.getNome() + "|" + p.getQuantidade() + "|"+ p.getPreco() + "|\n";
			}
			
		}

		return lista;
		
	}
	
	
	public static void EditarProduto(double preco, Produto p)
	{
		p.setPreco(preco);
		
	}
}