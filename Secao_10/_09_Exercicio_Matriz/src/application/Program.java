package application;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int[][] mat = new int[M][N];
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		int X = sc.nextInt();
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(X == mat[i][j]) {
					System.out.println("Position " + i + "," + j);
					if(j - 1 >= 0) {
						System.out.println("Left: " + mat[i][j - 1]);
					}
					if(i - 1 >= 0) {
						System.out.println("Up: " + mat[i - 1][j]);
					}
					if(j + 1 < N){
						System.out.println("Right: " + mat[i][j + 1]);
					}
					if(i + 1 < M) {
						System.out.println("Down: " + mat[i + 1][j]);
					}
				}
			}
		}
		
		sc.close();
	}

}
