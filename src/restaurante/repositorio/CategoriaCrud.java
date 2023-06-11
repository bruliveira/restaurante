package restaurante.repositorio;

import java.util.ArrayList;
import java.util.Scanner;

import restaurante.dados.Categoria;



public class CategoriaCrud {
	public static int codigo = 0;
	static Scanner scanner = new Scanner(System.in);
	
	private static ArrayList<Categoria> lisCategoria = new ArrayList<Categoria>();
	
	public static void Criar()
	{
		lisCategoria.add(new Categoria("suco",23));
	}
	
	public static void CadastraCategoria(Categoria c)
	{

		lisCategoria.add(c);	
		
	}
	
	public static void RemoverCategoria(Categoria c)
	{
		
		lisCategoria.remove(c);
	  
	}
	
	public static Categoria Buscar(String l)
	{
		for(Categoria c : lisCategoria)
		{
			
			if(l.equals(c.getTipo()))
			{
				return c;
			}
			
		}
		return null;
	}
	
	public static boolean BuscarNome(String n)
	{
		for(Categoria c : lisCategoria)
		{
			
			if(n.equals(c.getTipo()))
			{
				return true;
			}
			
		}
		
		return false;
	}
	
	public static String ListaCategoria()
	{	
		String lista = "";
		
		for(Categoria c :lisCategoria)
		{
			lista = "|" +c.getCodCategoria() + "|" + c.getTipo() + "|\n" ;
			
		}
		return lista;
	}
	
	public static void EditarCategoria(String nome, Categoria c)
	{
	
		c.setTipo(nome);
	}
}