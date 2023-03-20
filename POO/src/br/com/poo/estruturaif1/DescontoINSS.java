package br.com.poo.estruturaif1;

import java.util.Scanner;

public class DescontoINSS {
	
	public static void main(String[] args) {
		double salario,resultado;
		
		Scanner DescontoINSS = new Scanner(System.in);
		
		System.out.println("Digite o seu sálario:");
		salario = DescontoINSS.nextDouble();
		
		if (salario <= 1302) {
			System.out.println("Seu de desconto é de " + salario*0.075);
		}
		else if (salario <= 2571.29) {
			System.out.println("Seu de desconto é de " + salario*0.09);
		}
		else if (salario <= 3856.94) {
			System.out.println("Seu de desconto é de " + salario*0.12);
		}
		else if (salario >= 7507.49) {
			System.out.println("Seu de desconto é de " + salario*0.14);
		}
		else {
			resultado = 7507.49 * 0.14;
		}
		System.out.println("O desconto do INSS para o seu salário é " +DescontoINSS);
		}
			


}
