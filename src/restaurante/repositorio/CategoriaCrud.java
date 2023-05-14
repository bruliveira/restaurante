package Repositorios;

import java.util.ArrayList;
import java.util.Scanner;

import Dados.*;

public class CategoriaCrud {
	static int codigo = 0;
	static Scanner scanner = new Scanner(System.in);
	
	private static ArrayList<Categoria> lisCategoria = new ArrayList<Categoria>();
	
	public static void Criar()
	{
		lisCategoria.add(new Categoria("suco",23));
	}
	
	public static void CadastraCategoria()
	{
		String tipo;
		boolean v;
		Categoria c;
		
		do
		{
			System.out.println("tipo : ");
			tipo = scanner.nextLine();
			v = BuscarNome(tipo);
			
			if(v)
			{
				System.out.println("----- tipo indisponivel -----");
			}
		}while(v);
		codigo +=1;
		c = new Categoria(tipo,codigo);
		lisCategoria.add(c);	
		
	}
	
	public static void RemoverCategoria()
	{
		String tipo;
		Categoria c;
		do
		{
			System.out.println("digite tipo");
			tipo = scanner.nextLine();
			
			c = Buscar(tipo);
			if(c != null)
			{
				lisCategoria.remove(c);
			}
			else
			{
				System.out.println("----- login invalido -----");
			}
			
			
		}while(c == null);
		
	    
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
	
	public static void ListaCategorias()
	{	
		System.out.println();
		System.out.println("\t Categoria");
		System.out.println("|codigo | tipo |");
		for(Categoria c :lisCategoria)
		{
			System.out.println("|" +c.getCodCategoria() + "|" + c.getTipo() + "|" );
			
		}
		System.out.println("\naperte ENTER para voltar");
		scanner.nextLine();
	}
	
	public static void ConsutarTipo()
	{
		String tipo;
		Categoria c;
		do
		{
			System.out.println("digite o tipo");
			tipo = scanner.nextLine();
			
			c = Buscar(tipo);
			if(c == null)
			{
				System.out.println("----- tipo invalido -----");
			}
			
		}while(c == null);
		
		System.out.println("|codigo | tipo |");
		System.out.println("|" +c.getCodCategoria() + "|" + c.getTipo() + "|" );
		System.out.println("\naperte ENTER para voltar");
		scanner.nextLine();
	}
	
	public static void EditarCategoria()
	{
		String tipoA;
		String tipo;
		boolean v;
		Categoria c;
		
		System.out.println("tipo : ");
		tipoA = scanner.nextLine();
		c = Buscar(tipoA);
		if(c != null)
		{
			
		}
		else
		{
			System.out.println("----- tipo nao existe -----");
		}
		
		do
		{
			System.out.println("novo nome : ");
			tipo = scanner.nextLine();
			v = BuscarNome(tipo);
			
			if(v)
			{
				System.out.println("----- tipo indisponivel -----");
			}
		}while(v);
		
		c.setTipo(tipo);
		
	}
}