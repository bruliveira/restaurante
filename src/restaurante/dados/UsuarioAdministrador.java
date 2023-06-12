package restaurante.dados;

import java.util.Scanner;

import restaurante.excecoes.JaExiste;
import restaurante.excecoes.NaoExiste;
import restaurante.excecoes.NumeroNegativo;
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
	
	public void CadastraGarcom(String nome,String login, String senha) throws JaExiste
	{
		if(new GarcomCrud().BuscarNome(login))
		{
			throw new JaExiste();
		}
		else
		{
			UsuarioGarcom g = new UsuarioGarcom(nome,login,senha);
			new GarcomCrud().CadastraGarcom(g);
		}
		
	}

	public String ListaGarcom()
	{
		return new GarcomCrud().ListaGarcom();
	}

	public void EditarProduto(String nomeA, double precoN) throws NaoExiste ,NumeroNegativo
	{
		Produto p = new ProdutoCrud().Buscar(nomeA);
		if(p != null)
		{
			if(precoN <= 0)
			{
				throw new NumeroNegativo();
			 
			}
			else
			{
				new ProdutoCrud().EditarProduto(precoN, p);
			}
		}
		else
		{
			throw new NaoExiste();
		}
		
	}

	public void DemitirGarcom(String loginD) throws NaoExiste 
	{
		UsuarioGarcom g = new GarcomCrud().Buscar(loginD);
		if(g != null)
		{
			new GarcomCrud().Demitir(g);
		}
		else
		{
			throw new NaoExiste();
		}
		
	}

	public void CadastraProduto(String nome, String tipo, Double preco, int quantidade) throws JaExiste, NaoExiste, NumeroNegativo
	{
		if(new ProdutoCrud().BuscarNome(nome))
		{
			throw new JaExiste();
		}
		else
		{
			Categoria c = new CategoriaCrud().Buscar(tipo);
			if(c != null)
			{
				if(preco >= 0 && quantidade >= 0 )
				{
					ProdutoCrud.codigo +=1;
					Produto p = new Produto(nome,c.getCodCategoria(),preco,quantidade,ProdutoCrud.codigo);
					new ProdutoCrud().CadastraProduto(p);
				}
				else
				{
					throw new NumeroNegativo();
				}
			}
			else
			{
				throw new NaoExiste();
			}
		}
	}

	public String ListaProduto(String tipo) throws NaoExiste
	{
		Categoria c = new CategoriaCrud().Buscar(tipo);
		if(c != null)
		{
			return new ProdutoCrud().ListaProduto(c);
		}
		else
		{
			throw new NaoExiste();
		}
	}

	public void EditarGarcom(String loginA, String loginN, String senhaN) throws NaoExiste ,JaExiste
	{
		UsuarioGarcom g = new GarcomCrud().Buscar(loginA);
		if(g != null)
		{
			if(new GarcomCrud().BuscarNome(loginN))
			{
			throw new JaExiste();
			}
			else
			{
				new GarcomCrud().EditarGarcom(loginN, senhaN, g);
			}
		}
		else
		{
			throw new NaoExiste();
		}
		
	}

	public void RemoverProduto(String nome) throws NaoExiste 
	{
		Produto p = new ProdutoCrud().Buscar(nome);
		if(p != null)
		{
			new ProdutoCrud().Removerproduto(p);
		}
		else
		{
			throw new NaoExiste();
		}
		
	}
	
	public void CadastraCategoria(String nome) throws JaExiste
	{
		if(new CategoriaCrud().BuscarNome(nome))
		{
			throw new JaExiste();
		}
		else
		{
			CategoriaCrud.codigo +=1;
			Categoria c = new Categoria(nome, CategoriaCrud.codigo);
			new CategoriaCrud().CadastraCategoria(c);
		}
	}

	public String ListaCategoria()
	{
		return new CategoriaCrud().ListaCategoria();
	}

	public void EditarCategoria(String nomeA, String nomeN) throws NaoExiste ,JaExiste
	{
		Categoria c = new CategoriaCrud().Buscar(nomeN);
		if(c != null)
		{
			if(new CategoriaCrud().BuscarNome(nomeN))
			{
			throw new JaExiste();
			}
			else
			{
				new CategoriaCrud().EditarCategoria(nomeN,c);
			}
		}
		else
		{
			throw new NaoExiste();
		}
		
	}

	public void RemoverCategoria(String nome) throws NaoExiste 
	{
		Categoria c = new CategoriaCrud().Buscar(nome);
		if(c != null)
		{
			new CategoriaCrud().RemoverCategoria(c);
		}
		else
		{
			throw new NaoExiste();
		}
		
	}
}