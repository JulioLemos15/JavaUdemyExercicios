package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCacth {
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	try {
		String[] vect = sc.nextLine().split(" "); //vetor de strings, recebe o sc.nextline.split baseado no espaço em branco. Le varios espaços na mesma linha separados por espaço em branco e cada um desses dados vai ser um elemento do vetor
		int position = sc.nextInt(); //faz a leitura da variavel position que é um numero inteiro
		System.out.println(vect[position]);//mostra o vetor na posiçao que nos informamos na nossa variavel position
	}
		catch (ArrayIndexOutOfBoundsException e) {//caso ocorra uma exeção e ela seja capturada.
			System.out.println("Invalid position!"); //Posição invalida, no caso se a pessoa digitar 3 nomes o array começa com 0 a posição vai de 0 a 2.
	}
		catch (InputMismatchException e) { //caso ocorra uma exeção em vez da pessoa digitar um numero digitar uma letra o (e) no final é apelido, como se fosse uma variavel temporaria, pode ser qualquer nome que desejar.
			System.out.println("Input error"); 
	}
		System.out.println("End of program");
		sc.close();
	}
}
