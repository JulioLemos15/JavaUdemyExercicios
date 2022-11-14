package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BlocoFinaly {
	public static void main(String[] args) {
		
		File file = new File("C:\\temp\\in.txt");//File é uma classe que esta no pacote java.io, na instanciação do objeto passa o caminho do arquivo
		Scanner sc = null;
		
		try {//no try fica o código que abre o arquivo e mostra na tela
			sc = new Scanner(file); 
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} 
		catch (IOException e) {//e no bloco catch pega a exeção caso o arquivo não exista
			System.out.println("Error opening file: " + e.getMessage());
		} 
		finally { // e aqui idependente de ter dado certo ou não tem que fechar o scanner, para evitar que o arquivo fique aberto
			if (sc != null) {
				sc.close();
			}
		}
	}
}
