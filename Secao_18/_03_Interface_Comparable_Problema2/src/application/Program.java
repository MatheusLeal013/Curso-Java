package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import entities.Employee;

public class Program {
	public static void main(String[] args) {
		
		List<Employee> list = new ArrayList<>();
		
		String path = "C:\\Users\\mathe\\OneDrive\\Documentos\\problema2.txt";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String employeeCsv = br.readLine();
			while (employeeCsv != null) {
				String[] fields = employeeCsv.split(",");
				// Converter para double
				list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
				employeeCsv = br.readLine();
			}
			// Só pode ordenar a lista de tipo <T> se esse <T> for do tipo Comparable
			Collections.sort(list);
			for (Employee emp : list) {
				System.out.println(emp.getName() + ", " + emp.getSalary());
			}
		} 
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}