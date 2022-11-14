package application;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class LendoArquivoTxt {
	
	public static void main(String[] args) {
	File file = new File("C:\\temp\\in.txt");// caminho do arquivo \ é prefixo de caracteres especial, e para poder indicar que você quer 1 barra invertida, é preciso colocar duas \\.
	Scanner sc = null;
	
	try {
		sc = new Scanner(file);//instanciando o scanner para instanciar o file
		while (sc.hasNextLine()) {//testa se ainda existe uma nova linha no arquivo e manda imprimir
			System.out.println(sc.nextLine());
		}
		} 
		catch (IOException e) {//para tratar uma possivel exeção
			System.out.println("Error: " + e.getMessage());
		} 
		finally {//pra fechar o fechamando do recurso, e o finally pq ele executa idependente se o bloco try vai funcionar ou não
			if (sc != null) {//e ele só da um close se for diferente de nulo
				sc.close();
			}
		}
	}
}
