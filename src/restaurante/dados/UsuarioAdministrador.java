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
		if(GarcomCrud.BuscarNome(login))
		{
			throw new JaExiste();
		}
		else
		{
			UsuarioGarcom g = new UsuarioGarcom(nome,login,senha);
			GarcomCrud.CadastraGarcom(g);
		}
		
	}

	public String ListaGarcom()
	{
		return GarcomCrud.ListaGarcom();
	}

	public void EditarProduto(String nomeA, double precoN) throws NaoExiste ,NumeroNegativo
	{
		Produto p = ProdutoCrud.Buscar(nomeA);
		if(p != null)
		{
			if(precoN <= 0)
			{
				throw new NumeroNegativo();
			 
			}
			else
			{
				ProdutoCrud.EditarProduto(precoN, p);
			}
		}
		else
		{
			throw new NaoExiste();
		}
		
	}

	public void DemitirGarcom(String loginD) throws NaoExiste 
	{
		UsuarioGarcom g = GarcomCrud.Buscar(loginD);
		if(g != null)
		{
			GarcomCrud.Demitir(g);
		}
		else
		{
			throw new NaoExiste();
		}
		
	}

	public void CadastraProduto(String nome, String tipo, Double preco, int quantidade) throws JaExiste, NaoExiste, NumeroNegativo
	{
		if(ProdutoCrud.BuscarNome(nome))
		{
			throw new JaExiste();
		}
		else
		{
			Categoria c = CategoriaCrud.Buscar(tipo);
			if(c != null)
			{
				if(preco >= 0 && quantidade >= 0 )
				{
					ProdutoCrud.codigo +=1;
					Produto p = new Produto(nome,c.getCodCategoria(),preco,quantidade,ProdutoCrud.codigo);
					ProdutoCrud.CadastraProduto(p);
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
		Categoria c = CategoriaCrud.Buscar(tipo);
		if(c != null)
		{
			return ProdutoCrud.ListaProduto(c);
		}
		else
		{
			throw new NaoExiste();
		}
	}

	public void EditarGarcom(String loginA, String loginN, String senhaN) throws NaoExiste ,JaExiste
	{
		UsuarioGarcom g = GarcomCrud.Buscar(loginA);
		if(g != null)
		{
			if(GarcomCrud.BuscarNome(loginN))
			{
			throw new JaExiste();
			}
			else
			{
				GarcomCrud.EditarGarcom(loginN, senhaN, g);
			}
		}
		else
		{
			throw new NaoExiste();
		}
		
	}

	public void RemoverProduto(String nome) throws NaoExiste 
	{
		Produto p = ProdutoCrud.Buscar(nome);
		if(p != null)
		{
			ProdutoCrud.Removerproduto(p);
		}
		else
		{
			throw new NaoExiste();
		}
		
	}
	///////////////////////////////////////////////////////////////////////////////////////
	
	public void CadastraCategoria(String nome) throws JaExiste
	{
		if(CategoriaCrud.BuscarNome(nome))
		{
			throw new JaExiste();
		}
		else
		{
			CategoriaCrud.codigo +=1;
			Categoria c = new Categoria(nome, CategoriaCrud.codigo);
			CategoriaCrud.CadastraCategoria(c);
		}
	}

	public String ListaCategoria()
	{
		return CategoriaCrud.ListaCategoria();
	}

	public void EditarCategoria(String nomeA, String nomeN) throws NaoExiste ,JaExiste
	{
		Categoria c = CategoriaCrud.Buscar(nomeN);
		if(c != null)
		{
			if(CategoriaCrud.BuscarNome(nomeN))
			{
			throw new JaExiste();
			}
			else
			{
				CategoriaCrud.EditarCategoria(nomeN,c);
			}
		}
		else
		{
			throw new NaoExiste();
		}
		
	}

	public void RemoverCategoria(String nome) throws NaoExiste 
	{
		Categoria c = CategoriaCrud.Buscar(nome);
		if(c != null)
		{
			CategoriaCrud.RemoverCategoria(c);
		}
		else
		{
			throw new NaoExiste();
		}
		
	}
}