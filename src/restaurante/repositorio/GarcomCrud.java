package restaurante.repositorio;

import java.util.ArrayList;
import java.util.Scanner;

import restaurante.dados.UsuarioGarcom;


public class GarcomCrud {
	
	static Scanner scanner = new Scanner(System.in);
	
	private static ArrayList<UsuarioGarcom> lisGarcom = new ArrayList<UsuarioGarcom>();
	
	public static void criar()
	{
		lisGarcom.add(new UsuarioGarcom("g1","ga1","321"));
		lisGarcom.add(new UsuarioGarcom("g2","ga2","3241"));
		lisGarcom.add(new UsuarioGarcom("g3","ga3","3321"));
		lisGarcom.add(new UsuarioGarcom("g4","ga4","32451"));
	}
	
	public static void CadastraGarcom()
	{
		String nome;
		String login;
		String senha;
		boolean v;
		UsuarioGarcom g;
		
		System.out.println("nome : ");
		nome = scanner.nextLine();
		
		do
		{
			System.out.println("login : ");
			login = scanner.nextLine();
			v = BuscarNome(login);
			
			if(v)
			{
				System.out.println("----- nome indisponivel -----");
			}
		}while(v);
		System.out.println("senha : ");
		senha = scanner.nextLine();
		
		g = new UsuarioGarcom(nome,login,senha);
		lisGarcom.add(g);	
		
	}
	
	public static void Demitir()
	{
		String login;
		UsuarioGarcom g;
		do
		{
			System.out.println("digite login");
			login = scanner.nextLine();
			
			g = Buscar(login);
			if(g != null)
			{
				g.setStatus("demitido");
			}
			else
			{
				System.out.println("----- login invalido -----");
			}
			
			
		}while(g == null);
		
		System.out.println("garcom demitido");
		System.out.println("|id | nome | Acesso|");
		System.out.println("|" + g.getNome() + "|" + g.getLogin() + "|" + g.getStatus() + "|");
		System.out.println("\naperte ENTER para voltar");
		scanner.nextLine();
		
	    
	}
	
	public static UsuarioGarcom Buscar(String l)
	{
		for(UsuarioGarcom g : lisGarcom)
		{
			
			if(l.equals(g.getLogin()))
			{
				return g;
			}
			
		}
		return null;
	}
	
	public static boolean BuscarNome(String n)
	{
		for(UsuarioGarcom g : lisGarcom)
		{
			
			if(n.equals(g.getNome()) && g.getStatus().equals("contratado"))
			{
				return true;
			}
			
		}
		
		return false;
	}
	
	public static void ListaGarcom()
	{	
		System.out.println();
		System.out.println("\t garcons");
		System.out.println("|nome | login | status|");
		for(UsuarioGarcom g : lisGarcom)
		{
			System.out.println("|" + g.getNome() + "|" + g.getLogin() + "|" + g.getStatus() + "|");
			
		}
		System.out.println("\naperte ENTER para voltar");
		scanner.nextLine();
	}
	
	public static void ConsutarGarcom()
	{
		String login;
		UsuarioGarcom g;
		do
		{
			System.out.println("digite login");
			login = scanner.nextLine();
			
			g = Buscar(login);
			if(g == null)
			{
				System.out.println("----- login invalido -----");
			}
			
		}while(g == null);
		
		System.out.println("garcom ");
		System.out.println("|id | nome | Acesso|");
		System.out.println("|" + g.getNome() + "|" + g.getLogin() + "|" + g.getStatus() + "|");
		System.out.println("\naperte ENTER para voltar");
		scanner.nextLine();
	}
	
	public static void EditarGarcom()
	{
		String loginA;
		String login;
		String senha;
		boolean v;
		UsuarioGarcom g;
		
		System.out.println("login atual : ");
		loginA = scanner.nextLine();
		
		g = Buscar(loginA);
		
		if(g != null)
		{
			do
			{
				System.out.println("novo login : ");
				login = scanner.nextLine();
				v = BuscarNome(login);
				
				if(v)
				{
					System.out.println("----- login indisponivel -----");
				}
			}while(v);
			System.out.println("nova senha : ");
			senha = scanner.nextLine();
			
			g.setLogin(login);
			g.setSenha(senha);
		}	
		else
		{
			System.out.println("----- login nao existe -----");
		}
		
	}
}