package restaurante.repositorio;

import java.util.ArrayList;
import java.util.Scanner;

import restaurante.dados.UsuarioGarcom;


public class GarcomCrud implements IGarcomCrud{
	
	static Scanner scanner = new Scanner(System.in);
	
	private static ArrayList<UsuarioGarcom> lisGarcom = new ArrayList<UsuarioGarcom>();
	
	public void criar()
	{
		lisGarcom.add(new UsuarioGarcom("g1","ga1","321"));
		lisGarcom.add(new UsuarioGarcom("g2","ga2","3241"));
		lisGarcom.add(new UsuarioGarcom("g3","ga3","3321"));
		lisGarcom.add(new UsuarioGarcom("g4","ga4","32451"));
	}
	
	public void CadastraGarcom(UsuarioGarcom g)
	{
		lisGarcom.add(g);	
	}

	public boolean BuscarNome(String n)
	{
		for(UsuarioGarcom g : lisGarcom)
		{
			
			if(n.equals(g.getLogin()) && g.getStatus().equals("contratado"))
			{
				return true;
			}
			
		}
		
		return false;
	}

	public String ListaGarcom()
	{
		String lista = "";

		for(UsuarioGarcom g : lisGarcom)
		{
			lista = lista + "|" + g.getNome() + "|" + g.getLogin() + "|" + g.getStatus() + "| \n" ;
		
		}
		
		return lista;
	}
	
	public void EditarGarcom(String loginN, String senhaN, UsuarioGarcom g)
	{
			
		g.setLogin(loginN);
		g.setSenha(senhaN);
		
	}

	public void Demitir(UsuarioGarcom g)
	{
		g.setStatus("demitido");
	}
	
	public UsuarioGarcom Buscar(String l)
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
	/* 
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
		System.out.println("|nome | login | status|");
		System.out.println("|" + g.getNome() + "|" + g.getLogin() + "|" + g.getStatus() + "|");
		System.out.println("\naperte ENTER para voltar");
		scanner.nextLine();
	}*/
	
}