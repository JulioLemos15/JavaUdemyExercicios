package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCacth {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	try {
		String[] vect = sc.nextLine().split(" "); //vetor de strings, recebe o sc.nextline.split baseado no espa�o em branco. Le varios espa�os na mesma linha separados por espa�o em branco e cada um desses dados vai ser um elemento do vetor
		int position = sc.nextInt(); //faz a leitura da variavel position que � um numero inteiro
		System.out.println(vect[position]);//mostra o vetor na posi�ao que nos informamos na nossa variavel position
	}
		catch (ArrayIndexOutOfBoundsException e) {//caso ocorra uma exe��o e ela seja capturada.
			System.out.println("Invalid position!"); //Posi��o invalida, no caso se a pessoa digitar 3 nomes o array come�a com 0 a posi��o vai de 0 a 2.
	}
		catch (InputMismatchException e) { //caso ocorra uma exe��o em vez da pessoa digitar um numero digitar uma letra o (e) no final � apelido, como se fosse uma variavel temporaria, pode ser qualquer nome que desejar.
			System.out.println("Input error"); 
	}
		System.out.println("End of program");
		sc.close();
	}
}
