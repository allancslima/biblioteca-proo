package br.edu.ifal.biblioteca.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Biblioteca {
	
	private ArrayList<Material> materiais = new ArrayList<>();
	private ArrayList<Locacao> locacoes = new ArrayList<>();
	private HashMap<Material, Integer> mapMateriais = new HashMap<>();
	
	public ArrayList<Material> getMateriais () {
		return materiais;
	}
	
	public void cadastrarMaterial (Material material, int quantidade) {
		materiais.add(material);
		mapMateriais.put(material, quantidade);
	}
	
	public void adicionarLocacao (Locacao locacao) throws Exception {
		Material material = locacao.getMaterial();
		int quantidade = getQuantidadeMaterial(material);
		
		if (quantidade > 0) {
			locacoes.add(locacao);
			mapMateriais.put(material, quantidade - 1);
		} else {
			throw new Exception("Estoque insuficiente");
		}
	}
	
	public int getQuantidadeMaterial (Material material) {
		if (mapMateriais.get(material) == null)
			return 0;
		return mapMateriais.get(material);
	}
}