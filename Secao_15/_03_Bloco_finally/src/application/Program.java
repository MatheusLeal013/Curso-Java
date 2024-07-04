package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		
		File file = new File("C:\\temp\\in.txt");
		Scanner sc = null;
		
		try {
			// Classe scanner pode também apontar para arquivos
			sc = new Scanner(file);
			// percorrer arquivo
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (IOException e) {
			System.out.println("Error opening file: " + e.getMessage()); // mensagem padrão quando arquivo não é encontrado
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}
}