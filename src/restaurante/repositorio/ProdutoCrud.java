package restaurante.repositorio;

import restaurante.dados.*;
import restaurante.negocio.*;

import javax.swing.*;
import java.util.*;

public class ProdutoCrud implements IProduto {

	private List<Produto> produtos;
	private ICategoria categoriaCrud;

	public ProdutoCrud(ICategoria categoriaCrud) {
		produtos = new ArrayList<>();
		this.categoriaCrud = categoriaCrud;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	@Override
	public void cadProduto(int codProduto, String nomeProduto, double precoProduto, int qtdProduto,
			Categoria categoria) {
		List<Categoria> categorias = categoriaCrud.getCategorias();
		if (categorias == null || categorias.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nenhuma categoria cadastrada!");
			return;
		}

		String[] opcoesCategorias = categorias.stream().map(Categoria::getTipoCategoria).toArray(String[]::new);

		String selectedCategoria = (String) JOptionPane.showInputDialog(
				null,
				"Selecione a categoria:",
				"Cadastro de Produto",
				JOptionPane.PLAIN_MESSAGE,
				null,
				opcoesCategorias,
				opcoesCategorias[0]);

		if (selectedCategoria != null) {
			Categoria categoriaSelecionada = categorias.stream()
					.filter(c -> c.getTipoCategoria().equals(selectedCategoria))
					.findFirst()
					.orElse(null);

			if (categoriaSelecionada != null) {
				int codCategoria = categoriaSelecionada.getCodCategoria();

				if (!existeProduto(codProduto, codCategoria)) {
					Produto novoProduto = new Produto(codProduto, codCategoria, nomeProduto, precoProduto, qtdProduto);
					produtos.add(novoProduto);
				} else {
					JOptionPane.showMessageDialog(null, "Já existe um produto com o mesmo código e mesma categoria!");
				}
			}
		}
	}

	@Override
	public boolean existeProduto(int codProduto, int codCategoria) {
		return produtos.stream()
				.anyMatch(
						produto -> produto.getCodProduto() == codProduto && produto.getCodCategoria() == codCategoria);
	}

	@Override
	public List<Produto> listaProd() {
		return produtos;
	}

	@Override
	public void delProd(int codProduto) {
		Optional<Produto> produtoEncontrado = produtos.stream()
				.filter(produto -> produto.getCodProduto() == codProduto)
				.findFirst();

		if (produtoEncontrado.isPresent()) {
			produtos.remove(produtoEncontrado.get());
			JOptionPane.showMessageDialog(null, "Produto removido com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Produto não encontrado!");
		}
	}

	@Override
	public void alteraProd(int codProduto) {
		Optional<Produto> produtoEncontrado = produtos.stream()
				.filter(produto -> produto.getCodProduto() == codProduto)
				.findFirst();

		if (produtoEncontrado.isPresent()) {
			Produto produto = produtoEncontrado.get();

			String codP = JOptionPane.showInputDialog("Novo código do produto: ");
			int newCodP = Integer.parseInt(codP);
			String newNome = JOptionPane.showInputDialog("Novo nome do produto: ");
			String priceP = JOptionPane.showInputDialog("Novo valor do produto: ");
			double newPriceP = Double.parseDouble(priceP.replace(",", "."));
			String nqp = JOptionPane.showInputDialog("Nova quantidade do produto: ");
			int newQtdProd = Integer.parseInt(nqp);

			List<Categoria> categorias = categoriaCrud.getCategorias();
			String[] opcoesCategorias = categorias.stream().map(Categoria::getTipoCategoria).toArray(String[]::new);
			String selectedCategoria = (String) JOptionPane.showInputDialog(
					null,
					"Selecione a nova categoria:",
					"Alteração de Produto",
					JOptionPane.PLAIN_MESSAGE,
					null,
					opcoesCategorias,
					opcoesCategorias[0]);

			if (newNome != null && !newNome.isEmpty() &&
					priceP != null && !priceP.isEmpty() &&
					nqp != null && !nqp.isEmpty() &&
					selectedCategoria != null) {

				int newCodCategoria = categorias.stream()
						.filter(c -> c.getTipoCategoria().equals(selectedCategoria))
						.mapToInt(Categoria::getCodCategoria)
						.findFirst()
						.orElse(-1);

				if (!existeProduto(newCodP, newCodCategoria)) {
					produto.setCodProduto(newCodP);
					produto.setNomeProduto(newNome);
					produto.setPrecoProduto(newPriceP);
					produto.setQtdProduto(newQtdProd);
					produto.setCodCategoria(newCodCategoria);
					JOptionPane.showMessageDialog(null, "Dados do produto foram alterados com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Já existe um produto com o mesmo código e mesma categoria!");
				}
				return;
			}
		}
		JOptionPane.showMessageDialog(null, "Produto não encontrado ou algum dado foi inserido incorretamente...");
	}

	@Override
	public boolean buscaProd(int codProduto, int codCategoria) {
		for (Produto produto : produtos) {
			if (produto.getCodProduto() == codProduto && produto.getCodCategoria() == codCategoria) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String obterTipoCategoria(int codCategoria) {
		return categoriaCrud.obterTipoCategoria(codCategoria);
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
}
