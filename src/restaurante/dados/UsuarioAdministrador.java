package restaurante.dados;

import java.util.Scanner;

import restaurante.repositorio.CategoriaCrud;
import restaurante.repositorio.GarcomCrud;
import restaurante.repositorio.ProdutoCrud;


public class UsuarioAdministrador extends Usuario {
	Scanner scanner = new Scanner(System.in);

	//GarcomCrud contas = new GarcomCrud();

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
				GarcomCrud.CadastraGarcom();
				break;
				
			case 2:
				GarcomCrud.ListaGarcom();
				 
				break;
			
			case 3:
				GarcomCrud.EditarGarcom();
				break;
				
			case 4:
				GarcomCrud.Demitir();
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
				ProdutoCrud.CadastraProduto();
				break;
				
			case 2:
				ProdutoCrud.ListaProduto();
				 
				break;
			
			case 3:
				ProdutoCrud.EditarProduto();
				break;
				
			case 4:
				ProdutoCrud.Removerproduto();
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
				CategoriaCrud.CadastraCategoria();
				break;
				
			case 2:
				CategoriaCrud.ListaCategorias();
				 
				break;
			
			case 3:
				CategoriaCrud.EditarCategoria();
				break;
				
			case 4:
				CategoriaCrud.RemoverCategoria();
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