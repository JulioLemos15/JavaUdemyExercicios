package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PilhaChamadaMetodos {

	public static void main(String[] args) {
		method1();//chama metodo 1
		System.out.println("End of program");
	}
	
	public static void method1() {
		System.out.println("***METHOD1 START***");//Começo meteodo 1
		method2();//chamado de metodo 2
		System.out.println("***METHOD1 END***");//Fim metodo 1
	}
	
	public static void method2() {
		System.out.println("***METHOD2 START***");//marca o inicio da execução do método 2
		Scanner sc = new Scanner(System.in);
		try {
			String[] vect = sc.nextLine().split(" ");//vetor de strings, recebe o sc.nextline.split baseado no espaço em branco. Le varios espaços na mesma linha separados por espaço em branco e cada um desses dados vai ser um elemento do vetor
			int position = sc.nextInt();//faz a leitura da variavel position que é um numero inteiro
			System.out.println(vect[position]);//mostra o vetor na posiçao que nos informamos na nossa variavel position
		}
		catch (ArrayIndexOutOfBoundsException e) {//caso ocorra uma exeção e ela seja capturada
			System.out.println("Invalid position!");//Posição invalida, no caso se a pessoa digitar 3 nomes o array começa com 0 a posição vai de 0 a 2.
			e.printStackTrace();// imprimi na tela o rastreamento do stack, ele imprimi o tipo da exeção e imprimi a sequencia de chamadas que imprimiu essa exeção, mostra toda chamada de metodo.
			sc.next();//pra esperar digitar algo
		}
		catch (InputMismatchException e) {//caso ocorra uma exeção em vez da pessoa digitar um numero digitar uma letra o (e) no final é apelido, como se fosse uma variavel temporaria, pode ser qualquer nome que desejar.
			System.out.println("Input error");
		}
		sc.close();
		System.out.println("***METHOD2 END***");//marca o termino da execução do método 2
		
	}
}
