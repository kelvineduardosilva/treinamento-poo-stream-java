package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Program {

    public static void main(String[] args) {

        String caminho = "C:/Users/kelvi/OneDrive/Documentos/exfiles/produtos.csv.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {

            String line = br.readLine();

            Map<String, Integer> votos = new HashMap<>();
            while (line != null) {
            	String[] candidatos = line.split(",");
            	String nome = candidatos[0];
            	int quantidade = Integer.parseInt(candidatos[1]);
            	
            	votos.put(nome, votos.getOrDefault(nome, 0) + quantidade);

                line = br.readLine();
            }
            for (String nome : votos.keySet()) {
                System.out.println(nome + ": " + votos.get(nome));
            }

        } catch (IOException e) {
            System.out.println("Erro ao acessar o arquivo: " + e.getMessage());
        }
    }
}