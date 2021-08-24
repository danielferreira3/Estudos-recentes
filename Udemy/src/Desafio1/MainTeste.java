package Desafio1;



public class MainTeste {
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente("Daniel Ferreira");
		Compra compra1 = new Compra();
		compra1.adicionarItem("caneta", 9.67, 100);
		compra1.adicionarItem(new Produto("notebook", 4000), 2);
		
		Compra compra2 = new Compra();
		compra2.adicionarItem("caderno", 9.67, 1);
		compra2.adicionarItem(new Produto("camisa", 100), 2);
		
		cliente.adicionar(compra1);
		cliente.adicionar(compra2);
		
		System.out.println(cliente.ValorTotalCompra());
	}
}
