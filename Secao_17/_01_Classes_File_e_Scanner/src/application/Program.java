package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		// Objeto file encapsula todo o processo de acessar o arquivo
		File file = new File("C:\\Users\\mathe\\OneDrive\\Documentos\\in.txt");
		Scanner sc = null;
		// No momento de abertura do arquivo pode ser gerada uma exceção
		try {
			sc = new Scanner(file);
			// Testa se ainda exista uma nova linha no arquivo
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		// Boa prática
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

	}

}
