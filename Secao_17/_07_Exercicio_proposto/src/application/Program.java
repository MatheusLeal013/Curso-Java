package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Item;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Item> list = new ArrayList<>();
		
		System.out.println("Insira o caminho do arquivo .csv: ");
		String caminhoArquivoString = sc.nextLine();
		
		File caminhoArquivo = new File(caminhoArquivoString);
		
		String caminhoPastaString = caminhoArquivo.getParent();
				
		boolean success = new File(caminhoPastaString + "\\out").mkdir();
		
		String arquivoDestinoString = caminhoPastaString + "\\out\\summary.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
			
			String itemCsv = br.readLine();
			while (itemCsv != null) {
				
				String[] fields = itemCsv.split(",");
				String nome = fields[0];
				double precoUnitario = Double.parseDouble(fields[1]);
				int quantidade = Integer.parseInt(fields[2]);
				
				list.add(new Item(nome, precoUnitario, quantidade));
				
				itemCsv = br.readLine();
			}
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivoDestinoString))) {
				
				for (Item item : list) {
					bw.write(item.getNome() + "," + String.format("%.2f", item.valorTotal()));
					bw.newLine();
				}
				
				System.out.println(arquivoDestinoString + "CRIADO");
			}
			catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}
		}
		catch (IOException e) {
			System.out.println("Error writing file:" + e.getMessage());
		}
		
		sc.close();
	}

}
