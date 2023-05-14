package Dados;

import java.util.Scanner;

import Repositorios.*;

public class UsuarioAdministrador extends Usuario {
	Scanner scanner = new Scanner(System.in);

	public UsuarioAdministrador(String nome, String login, String senha)
	{
		super(nome,login,senha);
	}
	
	public void TelaAdministrador()
	{
int opcao;
		
		do
		{
			try
			{
				System.out.println("_____________________________________");
				System.out.println("escolha um numero");
				System.out.println("-------------------------------------");
				System.out.println("1 cadastro garcom \n2 cadastro produto \n3 cadastro categoria  \n4 voltar");
				System.out.println("_____________________________________");
				opcao = scanner.nextInt();
			}
			catch(Exception e)
			{
				scanner.next();
				opcao = 0;
			}
			switch(opcao)
			{
			case 1:
				CadastroGarcom();
				break;
				
			case 2:
				CadastroProduto();
				break;
				
			case 3:
				CadastroCategoria();
				break;
				
			case 4:
				break;
				
			default :
				System.out.println("----- numero invalido -----");
				break;
			}
			
		}while(opcao != 4);
	}
	
	void CadastroGarcom()
	{
		int opcao;
		do
		{
			try
			{
				System.out.println("_____________________________________");
				System.out.println("escolha um numero");
				System.out.println("-------------------------------------");
				System.out.println("1 add garcom \n2 lista de garcons \n3 editar garcom \n4 demitir garcom \n5 voltar");
				opcao = scanner.nextInt();
				System.out.println("_____________________________________");
			}
			catch(Exception e)
			{
				scanner.next();
				opcao = 0;
			}
			switch(opcao)
			{
			case 1:
				RepositorioGarcom.CadastraGarcom();
				break;
				
			case 2:
				RepositorioGarcom.ListaGarcom();
				 
				break;
			
			case 3:
				RepositorioGarcom.EditarGarcom();
				break;
				
			case 4:
				RepositorioGarcom.Demitir();
				break;
				
			case 5:
				System.out.println("voltar");
				break;
				
			default :
				
				System.out.println("----- numero invalido -----");
				break;
			}
			
		}while(opcao != 5);
	}
	
	void CadastroProduto()
	{
		int opcao;
		do
		{
			try
			{
				System.out.println("_____________________________________");
				System.out.println("escolha um numero");
				System.out.println("-------------------------------------");
				System.out.println("1 add produto \n2 lista de produto \n3 editar produto \n4 remover produto \n5 voltar");
				opcao = scanner.nextInt();
				System.out.println("_____________________________________");
			}
			catch(Exception e)
			{
				scanner.next();
				opcao = 0;
			}
			switch(opcao)
			{
			case 1:
				RepositorioProduto.CadastraProduto();
				break;
				
			case 2:
				RepositorioProduto.ListaProduto();
				 
				break;
			
			case 3:
				RepositorioProduto.EditarProduto();
				break;
				
			case 4:
				RepositorioProduto.Removerproduto();
				break;
				
			case 5:
				System.out.println("voltar");
				break;
				
			default :
				
				System.out.println("----- numero invalido -----");
				break;
			}
			
		}while(opcao != 5);
	}
	
	void CadastroCategoria()
	{
		int opcao;
		do
		{
			try
			{
				System.out.println("_____________________________________");
				System.out.println("escolha um numero");
				System.out.println("-------------------------------------");
				System.out.println("1 add categoria \n2 lista de categorias \n3 editar categoria \n4 remover categoria \n5 voltar");
				opcao = scanner.nextInt();
				System.out.println("_____________________________________");
			}
			catch(Exception e)
			{
				scanner.next();
				opcao = 0;
			}
			switch(opcao)
			{
			case 1:
				RepositorioCategoria.CadastraCategoria();
				break;
				
			case 2:
				RepositorioCategoria.ListaCategorias();
				 
				break;
			
			case 3:
				RepositorioCategoria.EditarCategoria();
				break;
				
			case 4:
				RepositorioCategoria.RemoverCategoria();
				break;
				
			case 5:
				System.out.println("voltar");
				break;
				
			default :
				
				System.out.println("----- numero invalido -----");
				break;
			}
			
		}while(opcao != 5);
	}
}