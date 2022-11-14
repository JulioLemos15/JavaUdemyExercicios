package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BlocoFinaly {
	public static void main(String[] args) {
		
		File file = new File("C:\\temp\\in.txt");//File � uma classe que esta no pacote java.io, na instancia��o do objeto passa o caminho do arquivo
		Scanner sc = null;
		
		try {//no try fica o c�digo que abre o arquivo e mostra na tela
			sc = new Scanner(file); 
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} 
		catch (IOException e) {//e no bloco catch pega a exe��o caso o arquivo n�o exista
			System.out.println("Error opening file: " + e.getMessage());
		} 
		finally { // e aqui idependente de ter dado certo ou n�o tem que fechar o scanner, para evitar que o arquivo fique aberto
			if (sc != null) {
				sc.close();
			}
		}
	}
}
