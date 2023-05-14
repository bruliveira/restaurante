package Repositorios;

import java.util.ArrayList;
import java.util.Scanner;

import Dados.*;

public class ProdutoCrud {
	
	static int codigo = 0;
	static Scanner scanner = new Scanner(System.in);
	
	private static ArrayList<Produto> lisProduto= new ArrayList<Produto>();
	
	public static void Criar()
	{
		lisProduto.add(new Produto("laranja",23,12,15,64));
	}
	
	public static void CadastraProduto()
	{
		String nome;
		String tipo;
		double preco;
		int quantidade;
		boolean v;
		Produto p;
		Categoria c;
		
		do
		{
			System.out.println("nome : ");
			nome = scanner.nextLine();
			v = BuscarNome(nome);
			
			if(v)
			{
				System.out.println("----- nome indisponivel -----");
			}
		}while(v);
		
		do
		{
			System.out.println("tipo : ");
			tipo = scanner.nextLine();
			c = CategoriaCrud.Buscar(tipo);
			
			if(c == null)
			{
				System.out.println("----- tipo indisponivel -----");
			}
		}while(c == null);
		
		do
		{
			try
			{
				System.out.println("preco : ");
				preco = scanner.nextDouble();
			}catch(Exception e)
			{
				preco = -1;
				scanner.next();
			}
		}while(preco < 0);
		
		do
		{
			try
			{
				System.out.println("quantidade : ");
				quantidade = scanner.nextInt();
			}catch(Exception e)
			{
				quantidade = -1;
				scanner.next();
			}
		}while(quantidade < 1);
		
		codigo +=1;
		p = new Produto(nome,c.getCodCategoria(),preco,quantidade,codigo);
		lisProduto.add(p);	
		
	}
	
	public static void Removerproduto()
	{
		String nome;
		Produto p;
		do
		{
			System.out.println("nome");
			nome = scanner.nextLine();
			
			p = Buscar(nome);
			if(p != null)
			{
				lisProduto.remove(p);
			}
			else
			{
				System.out.println("----- nome invalido -----");
			}
			
			
		}while(p == null);
		
	    
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
	
	public static void ListaProduto()
	{	
		String categ;
		Categoria c;
		do
		{
			System.out.println("categoria : ");
			categ = scanner.nextLine();
			scanner.nextLine();
			c = CategoriaCrud.Buscar(categ);
			
			if(c == null)
			{
				System.out.println("----- tipo indisponivel -----");
			}
		}while(c == null);
		
		System.out.println();
		System.out.println("\t Produto");
		System.out.println("|codigo categoria |codigo produto |nome |quantidade |preco|");
		for(Produto p : lisProduto)
		{
			if(c.getCodCategoria() == p.getCodigoCategoria())
			{
				System.out.println("|" + p.getCodigoCategoria() + "|" + p.getCodigo() + "|" + p.getNome() + "|" + p.getQuantidade() + "|"+ p.getPreco() + "|");
			}
			
		}
		System.out.println("\naperte ENTER para voltar");
		scanner.nextLine();
	}
	
	public static void ConsutarTipo()
	{
		String nome;
		 Produto p;
		do
		{
			System.out.println("digite o nome");
			nome = scanner.nextLine();
			
			p = Buscar(nome);
			if(p == null)
			{
				System.out.println("----- nome invalido -----");
			}
			
		}while(p == null);
		
		System.out.println("|codigo categoria |codigo produto |nome |quantidade |preco|");
		System.out.println("|" + p.getCodigoCategoria() + "|" + p.getCodigo() + "|" + p.getNome() + "|" + p.getQuantidade() + "|"+ p.getPreco() + "|");
		System.out.println("\naperte ENTER para voltar");
		scanner.nextLine();
	}
	
	
	public static void EditarProduto()
	{
		String nomeA;
		String nome;
		double preco;
		int quantidade;
		boolean v;
		Produto p;
		
		System.out.println("nomeA: ");
		nomeA = scanner.nextLine();
		p = Buscar(nomeA);
		
		if(p != null)
		{
			do
			{
				System.out.println("novo nome : ");
				nome = scanner.nextLine();
				v = BuscarNome(nome);
				if(v)
				{
					System.out.println("----- nome indisponivel -----");
				}
			}while(v);
			
			do
			{
				try
				{
					System.out.println("preco : ");
					preco = scanner.nextDouble();
				}catch(Exception e)
				{
					preco = -1;
					scanner.next();
				}
			}while(preco < 0);
			
			do
			{
				try
				{
					System.out.println("quantidade : ");
					quantidade = scanner.nextInt();
				}catch(Exception e)
				{
					quantidade = -1;
					scanner.next();
				}
			}while(quantidade < 1);
				
			p.setNome(nome);
			p.setPreco(preco);
			p.setQuantidade(quantidade);
		}
		else
		{
			System.out.println("----- nome nao existe -----");
		}
	}
}