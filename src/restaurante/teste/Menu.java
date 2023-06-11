package restaurante.teste;
import restaurante.dados.*;
import java.util.Scanner;
import restaurante.excecoes.*;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    UsuarioAdministrador adm;

    public void  TelaAdministrador(UsuarioAdministrador adm)
	{
        this.adm = adm;
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
            
                 String nome;
                 String login;
                 String senha;

                 scanner.nextLine();
                 System.out.println("nome : ");
                 nome = scanner.nextLine();
            
                 System.out.println("login : ");
                 login = scanner.nextLine();
           
                 System.out.println("senha : ");
                 senha = scanner.nextLine();

                 try {
                    adm.CadastraGarcom(nome,login,senha);
                 } catch (Exception e) {
                    System.out.println("-----LOGIN JA EXISTE -----");
                    break;
                 }
                 System.out.println("----- GARCOM ADD -----");
				 break;
				
			case 2:
                String lista;
                lista = adm.ListaGarcom();
                System.out.println();
		        System.out.println("\t garcons");
		        System.out.println("|nome | login | status|");
                System.out.println(lista);
                System.out.println("\naperte ENTER para voltar");
                scanner.nextLine();
		        scanner.nextLine();
				 
				break;
			
			case 3:
                String loginA;
                String loginN;
                String senhaN;
            
                scanner.nextLine();
                System.out.println("login atual : ");
                loginA = scanner.nextLine();
                
                System.out.println("novo login : ");
                loginN = scanner.nextLine();
                
                System.out.println("nova senha : ");
                senhaN = scanner.nextLine();

                try {
                    adm.EditarGarcom(loginA, loginN, senhaN);
                } catch (NaoExiste e) {
                    System.out.println("-----LOGIN NAO EXISTE -----");
                    break;
                }
                catch (JaExiste ex) {

                    System.out.println("-----LOGIN JA EXISTE -----");
                    break;
                
                }
                System.out.println("----- GARCOM EDITADO -----");
				break;
				
			case 4:
                String loginD;

                scanner.nextLine();
			    System.out.println("digite login");
			    loginD = scanner.nextLine();
			
                try {
                    adm.DemitirGarcom(loginD);
                } catch (Exception e) {
                    System.out.println("-----LOGIN NAO EXISTE -----");
                    break;
                }

                System.out.println("----- GARCOM DEMITIDO -----");
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

                String nome;
                String tipo;
                Double preco;
                int quantidade;

                scanner.nextLine();
                System.out.println("nome : ");
                nome = scanner.nextLine();
       
                System.out.println("tipo : ");
                tipo = scanner.nextLine();
      
                System.out.println("preco : ");
                try {
                    preco = scanner.nextDouble();
                } catch (Exception e) {
                    System.out.println("----- DIGITE UM NUMERO -----");
                    scanner.nextLine();
                    break;
                }

                System.out.println("quantidade : ");
                try {
                    quantidade = scanner.nextInt();
                } catch (Exception e) {
                    System.out.println("----- DIGITE UM NUMERO -----");
                    scanner.nextLine();
                    break;
                }

                try {
                   adm.CadastraProduto(nome, tipo, preco, quantidade);
                } catch (JaExiste e) {
                   System.out.println("----- NOME JA EXISTE -----");
                   break;
                }
                catch (NaoExiste e) {
                    System.out.println("----- CATEGORIA NAO EXISTE -----");
                    break;
                 }
                catch (NumeroNegativo e) {
                    System.out.println("----- NUMERO INVALIDA -----");
                    break;
                 }
                System.out.println("----- PRODUTO ADD -----");
                break;

			case 2:
                String lista = "";
                String tipoB;

                scanner.nextLine();
                System.out.println("tipo : ");
                tipoB = scanner.nextLine();
                try {
                  lista = adm.ListaProduto(tipoB);
                } catch (Exception e) {
                    System.out.println("----- CATEGORIA NAO EXISTE -----");
                    break;
                }
                System.out.println();
		        System.out.println("\t Produto");
		        System.out.println("|codigo categoria |codigo produto |nome |quantidade |preco|");
                System.out.println(lista);
                System.out.println("\naperte ENTER para voltar");
		        scanner.nextLine();
				 
				break;
			
			case 3:
                String nomeA;
                double precoN;
        
                scanner.nextLine();
                System.out.println("nome atual : ");
                nomeA = scanner.nextLine();
            
                System.out.println("novo preco : ");
                try {
                    precoN = scanner.nextDouble();
                } catch (Exception e) {
                    System.out.println("----- DIGITE UM NUMERO -----");
                    scanner.nextLine();
                    break;
                }

                try {
                    adm.EditarProduto(nomeA, precoN);
                } catch (NaoExiste e) {
                    System.out.println("----- NOME NAO EXISTE -----");
                    break;
                }
                catch (NumeroNegativo ex) {

                    System.out.println("----- NUMERO INVALIDO -----");
                    break;
            
                }
                System.out.println("----- PRODUTO EDITADO -----");
                break;
				
			case 4:
                String nomeD;

                scanner.nextLine();
                System.out.println("digite o nome");
                nomeD = scanner.nextLine();
        
                try {
                    adm.RemoverProduto(nomeD);
                } catch (Exception e) {
                    System.out.println("----- NOME NAO EXISTE -----");
                    break;
                }

                System.out.println("----- PRODUTO REMOVIDO -----");
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
                String nome;

                scanner.nextLine();
                System.out.println("nome : ");
                nome = scanner.nextLine();

                try {
                   adm.CadastraCategoria(nome);
                } catch (Exception e) {
                   System.out.println("-----CATEGORIA JA EXISTE -----");
                   break;
                }
                System.out.println("----- CATEGORIA ADD -----");
                break;
				
			case 2:
                String lista;
                lista = adm.ListaCategoria();
                System.out.println();
		        System.out.println("\t Categoria");
		        System.out.println("|codigo | tipo |");
                System.out.println(lista);
                System.out.println("\naperte ENTER para voltar");
                scanner.nextLine();
                scanner.nextLine();
             
                break;
			
			case 3:
                String nomeA;
                String nomeN;
        
                scanner.nextLine();
                System.out.println("nome atual : ");
                nomeA = scanner.nextLine();
            
                System.out.println("novo nome : ");
                nomeN = scanner.nextLine();

                try {
                    adm.EditarCategoria(nomeA, nomeN);
                } catch (NaoExiste e) {
                    System.out.println("-----NOME NAO EXISTE -----");
                    break;
                }
                catch (JaExiste ex) {

                    System.out.println("-----NOME JA EXISTE -----");
                    break;
            
                }
                System.out.println("----- CATEGORIA EDITADO -----");
                break;
				
			case 4:
                String nomeR;

                scanner.nextLine();
                System.out.println("nome");
                nomeR = scanner.nextLine();
        
            try {
                adm.CadastraCategoria(nomeR);
            } catch (Exception e) {
                System.out.println("-----NOME NAO EXISTE -----");
                break;
            }

            System.out.println("----- CATEGORIA REMOVIDA -----");
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
