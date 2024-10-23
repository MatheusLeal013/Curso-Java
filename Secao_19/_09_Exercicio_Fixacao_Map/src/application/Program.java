package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> candidato = new LinkedHashMap<>();
		
		System.out.print("Enter file full path: ");
		String path = sc.next();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			
			while (line != null) {
				
				String[] fields = line.split(",");
				String candidatoNome = fields[0];
				Integer quantidadeVotos = Integer.parseInt(fields[1]);
				
				if (candidato.containsKey(candidatoNome)) {
					candidato.put(candidatoNome, candidato.get(candidatoNome) + quantidadeVotos);
				} else {
					candidato.put(candidatoNome, quantidadeVotos);
				}
				
				line = br.readLine();
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		/*
		path = "/home/matheus-leal/Documentos/out.csv";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
			for (String key : candidato.keySet()) {
				bw.write(key + ":" + candidato.get(key));
				bw.newLine();
			}
		}
		catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		System.out.print("Registro realizado com sucesso");
		*/
		
		for (String key : candidato.keySet()) {
			System.out.println(key + ": " + candidato.get(key));
		}
	}

}
