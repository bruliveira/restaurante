package restaurante.repositorio;

import restaurante.dados.*;
import restaurante.negocio.*;
import java.util.*;
import javax.swing.*;

public class CategoriaCrud implements ICategoria {

	private List<Categoria> categorias;

	public CategoriaCrud() {
		categorias = new ArrayList<>();
	}

	@Override
	public void cadastrarCategoria(int codCategoria, String tipoCategoria) {
		if (codCategoria <= 0 || tipoCategoria == null || tipoCategoria.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Código ou tipo de categoria inválido!");
		} else if (verificarExistencia(codCategoria, tipoCategoria)) {
			JOptionPane.showMessageDialog(null, "Já existe uma categoria com o mesmo código ou nome!");
		} else {
			Categoria novaCategoria = new Categoria(codCategoria, tipoCategoria);
			categorias.add(novaCategoria);
			JOptionPane.showMessageDialog(null, "Categoria cadastrada com sucesso!");
		}
	}

	@Override
	public void listarCategorias() {
		if (categorias.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Nenhuma categoria cadastrada!");
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("Lista de Categorias:\n");

			for (Categoria categoria : categorias) {
				int codCategoria = categoria.getCodCategoria();
				String tipoCategoria = categoria.getTipoCategoria();

				sb.append("Código: ").append(codCategoria).append("\n");
				sb.append("Tipo: ").append(tipoCategoria).append("\n\n");
			}

			JOptionPane.showMessageDialog(null, sb.toString());
		}
	}

	@Override
	public void alteraCategoria(int codCategoria, int novoCodCateg, String novoTipoCategoria) {
		Categoria categoria = buscarCategoria(codCategoria);

		if (categoria != null) {
			int codAnterior = categoria.getCodCategoria();
			String tipoAnterior = categoria.getTipoCategoria();

			if (codAnterior != novoCodCateg || !tipoAnterior.equalsIgnoreCase(novoTipoCategoria)) {
				if (!verificarExistencia(novoCodCateg, novoTipoCategoria)) {
					categoria.setCodCategoria(novoCodCateg);
					categoria.setTipoCategoria(novoTipoCategoria);
					JOptionPane.showMessageDialog(null, "Categoria alterada com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Já existe uma categoria com o mesmo codigo ou tipo!");
				}
			} else {
				JOptionPane.showMessageDialog(null, "O novo tipo da categoria deve ser diferente do tipo atual!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Categoria não encontrada!");
		}
	}

	@Override
	public void delCategoria(int codCategoria) {
		Categoria categoria = buscarCategoria(codCategoria);

		if (categoria != null) {
			categorias.remove(categoria);
			JOptionPane.showMessageDialog(null, "Categoria excluída com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Categoria não encontrada!");
		}
	}

	@Override
	public void atualizarListaCategorias() {
		// Atualização da interface gráfica, se necessário
	}

	public boolean verificarExistencia(int codCategoria, String tipoCategoria) {
		for (Categoria categoria : categorias) {
			if (categoria.getCodCategoria() == codCategoria
					|| categoria.getTipoCategoria().equalsIgnoreCase(tipoCategoria)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Categoria buscarCategoria(int codCategoria) {
		for (Categoria categoria : categorias) {
			if (categoria.getCodCategoria() == codCategoria) {
				return categoria;
			}
		}
		return null;
	}

	@Override
	public String obterTipoCategoria(int codCategoria) {
		Categoria categoria = buscarCategoria(codCategoria);

		if (categoria != null) {
			return categoria.getTipoCategoria();
		} else {
			return null; // ou uma mensagem indicando que a categoria não foi encontrada
		}
	}

	@Override
	public void delCateg(int codCategoria) {
		delCategoria(codCategoria);
	}

	public void verificarCateg(int codCategoria, String tipoCategoria) {
		verificarExistencia(codCategoria, tipoCategoria);
	}

	@Override
	public List<Categoria> getCategorias() {
		return categorias;
	}

}
