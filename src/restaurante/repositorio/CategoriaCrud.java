package restaurante.repositorio;

import java.util.ArrayList;
import java.util.Scanner;
import restaurante.dados.Categoria;

public class CategoriaCrud implements ICategoriaCrud{
	public static int codigo = 0;
	static Scanner scanner = new Scanner(System.in);
	
	private static ArrayList<Categoria> lisCategoria = new ArrayList<Categoria>();
	
	@Override
	public void Criar()
	{
		lisCategoria.add(new Categoria("suco",23));
	}
	
	@Override
	public void CadastraCategoria(Categoria c)
	{

		lisCategoria.add(c);	
		
	}

	@Override
	public void RemoverCategoria(Categoria c)
	{
		
		lisCategoria.remove(c);
	  
	}
	
	@Override
	public Categoria Buscar(String l)
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

	@Override
	public boolean BuscarNome(String n)
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
	
	@Override
	public String ListaCategoria()
	{	
		String lista = "";
		
		for(Categoria c :lisCategoria)
		{
			lista = "|" +c.getCodCategoria() + "|" + c.getTipo() + "|\n" ;
			
		}
		return lista;
	}
	
	@Override
	public void EditarCategoria(String nome, Categoria c)
	{
	
		c.setTipo(nome);
	}
}