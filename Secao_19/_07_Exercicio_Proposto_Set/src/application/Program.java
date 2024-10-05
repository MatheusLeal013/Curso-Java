package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Set<Integer> a = new HashSet<>();
		Set<Integer> b = new HashSet<>();
		Set<Integer> c = new HashSet<>();
		
		System.out.print("How many students for course A? ");
		int aStudents = sc.nextInt();
		for (int i = 0; i < aStudents; i++) {
			a.add(sc.nextInt());
		}
		
		System.out.print("How many students for course B? ");
		int bStudents = sc.nextInt();
		for (int i = 0; i < bStudents; i++) {
			b.add(sc.nextInt());
		}
		
		System.out.print("How many students for course C? ");
		int cStudents = sc.nextInt();
		for (int i = 0; i < cStudents; i++) {
			c.add(sc.nextInt());
		}
		
		Set<Integer> totalStudents = new HashSet<Integer>();
		
		totalStudents.addAll(a);
		totalStudents.addAll(b);
		totalStudents.addAll(c);
		
		System.out.println("Total students: " + totalStudents.size());
		
		sc.close();
	}

}
