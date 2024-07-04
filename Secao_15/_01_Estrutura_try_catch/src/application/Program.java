package application;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// Uma aplicação comercial não termina quando acontece uma exceção
		// essa exceção é tratada
		try {
			String[] vect = sc.nextLine().split(" "); // ler uma linha de entrada do usuário e dividi-la em partes separadas por espaços
			int position = sc.nextInt();
			System.out.println(vect[position]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid position!");
		} catch (InputMismatchException e) {
			System.out.println("Input error");
		}
		
		System.out.println("End of program");
		
		sc.close();
	}
}
