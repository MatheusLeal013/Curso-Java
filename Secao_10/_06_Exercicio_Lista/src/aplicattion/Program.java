package aplicattion;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
				
		System.out.print("How many employees will be registered? ");
		int N = sc.nextInt();	
		
		System.out.println();
		
		Employee[] employee = new Employee[N];
		
		System.out.println("Emplyoee #1:");
		
		System.out.print("Id: ");
		int id = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Name: ");
		String nome = sc.nextLine();
		
		System.out.print("Salary: ");
		double salario = sc.nextDouble();
		
		System.out.println();
		
		employee[0] = new Employee(id, nome, salario);
		
		List<Employee> list = new ArrayList<>();
		
		list.add(0, employee[0]);
		
		for(int i = 1; i < N; i++) {
			
			System.out.printf("Emplyoee #%d:\n", i + 1);
			System.out.print("Id: ");
			id = sc.nextInt();
			
			for(int j = i - 1; j >= 0; j--) {
				while(id == employee[j].getId()) {
					System.out.println("\nExisting id. Please enter again.");
					System.out.printf("Emplyoee #%d:\n", i + 1);
					System.out.print("Id: ");
					id = sc.nextInt();
				}
			}
			
			sc.nextLine();
			
			System.out.print("Name: ");
			nome = sc.nextLine();
			
			System.out.print("Salary: ");
			salario = sc.nextDouble();
			
			System.out.println();
			
			employee[i] = new Employee(id, nome, salario);
		}
				
		System.out.print("Enter the employee id that will have salary increase: ");
		id = sc.nextInt();
		
		for(int i = 0; i < N; i++) {
			if(id == employee[i].getId()) {
				System.out.print("Enter the percentage: ");
				double porcentagem = sc.nextDouble();
				employee[i].salaryIncrease(porcentagem);
				break;
			} else {
				System.out.println("This id does not exist!");
				break; // Para o for por inteiro
			}
		}
		
		System.out.println();
		
		System.out.println("List of employees");
		
		for(Employee x : employee) {
			System.out.println(x);
		}
		
		sc.close();
						
	}

}
