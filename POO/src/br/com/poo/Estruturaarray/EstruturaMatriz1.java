package br.com.poo.Estruturaarray;

public class EstruturaMatriz1 {

	public static void main(String[] args) {
		
		String[][] listaprodutos = {
				
				{"Nome","Marca","Preço"},
				{"Blusa","Levi","R$ 60,00"},
				{"Calça","Democrata","R$ 150,00"}
		};
		
		for(int lin = 0; lin < listaprodutos.length ; lin++) {
			for(int col = 0; col < listaprodutos[0].length; col++) {
				System.out.print(listaprodutos[lin][col]+ "\t");
			}
			System.out.println();
		}
	}

}
