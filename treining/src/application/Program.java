package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Funcionario;

public class Program {

    public static void main(String[] args) {

        String caminho = "C:/Users/kelvi/OneDrive/Documentos/exfiles/produtos.csv.txt";
        Scanner entrada = new Scanner(System.in);

        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
        	List<Funcionario> lista = new ArrayList<>();
            String line = br.readLine();
    
            System.out.println("Digite o salário referência: ");
            Double salarioRef = entrada.nextDouble();
            entrada.nextLine();
            
            while (line != null) {
            	String[] funcionarios = line.split(",");
            	String nome = funcionarios[0];
            	String email = funcionarios[1];
            	Double salario = Double.parseDouble(funcionarios[2]);
            	
            	Funcionario func = new Funcionario(nome, email, salario);
            	lista.add(func);
            
                line = br.readLine();
            }
            
            List<String> emails = lista.stream().filter(f  -> f.getSalario() > salarioRef).map(Funcionario::getEmail).sorted().toList();
            
            Double soma = lista.stream().filter(f -> f.getNome().charAt(0) == 'M').mapToDouble(f -> f.getSalario()).sum();
            
            System.out.println("Emails cujo salário seja maior que " + salarioRef + ": ");
            
            for(int i = 0; i < emails.size(); i++) {
            
            	String email = emails.get(i);
            	System.out.println(email);
            }
            System.out.println("Soma dos salários cujo nome começa com a letra M " + String.format("%.2f", soma));

        } catch (IOException e) {
            System.out.println("Erro ao acessar o arquivo: " + e.getMessage());
        }
    }
}