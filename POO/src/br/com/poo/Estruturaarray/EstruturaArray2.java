package br.com.poo.Estruturaarray;

public class EstruturaArray2 {
	
	public static void main(String[] args) {
		
		int [] numeros = {10,23,5,6,8,12,18,15,147,35,66,68,62,34};
		
		for (int i = 0 ; i <numeros.length ; i++) {
			if ( numeros [1] % 2 == 0) {
				System.out.println(numeros[1]);
			}
		}
	}

}
