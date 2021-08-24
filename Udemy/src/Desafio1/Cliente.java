package Desafio1;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	
	final String nome;
	final List<Compra> compra = new ArrayList<>();
	
	
	
	public Cliente(String nome) {
		this.nome = nome;
	}

	void adicionar(Compra compra) {
		this.compra.add(compra);
	}

	double ValorTotalCompra() {
		double valorTotal = 0;
		for(Compra compra: this.compra) {
			valorTotal += compra.obterValorTotal();
		}
		return valorTotal;
	}
}
