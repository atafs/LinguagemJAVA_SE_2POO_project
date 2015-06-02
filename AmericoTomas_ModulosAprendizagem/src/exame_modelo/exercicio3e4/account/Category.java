package exame_modelo.exercicio3e4.account;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Category {
	
	//ATTRIBUTES
	private String nome;
	private List<String> lists;
	private List<String> subcategorias;
	
	//CONSTRUCTOR
	public Category(String nome, List<String> lists, List<String> subcategorias) {
		this.nome = nome;
		this.lists = lists;
		this.subcategorias = subcategorias;
	}
	
	public Category() {
		this.nome = "";
		lists = new ArrayList<String>();
		subcategorias = new ArrayList<String>();
	}
	
	//TOSTRING
	@Override
	public String toString() {
		String toReturn = "";
		toReturn += "NOME -> " + nome;
		System.out.println("----------lists-----------");
		for (String string : lists) {
			toReturn += "\nelemento -> " + string;
		}
		System.out.println("----------subcategorias-----------");
		for (String string : subcategorias) {
			toReturn += "\nelemento -> " + string;
		}
		return toReturn;
	}
	
	//READ AND WRITE (IO)
	/** Read from file receiving as params a String */
	public void leFicheiro(String nomeFicheiro){
		try {
			Scanner scanner = new Scanner(new File(nomeFicheiro));
			try {
				
				String nome = "";
				String string1 = "";
				String string2 = "";
				int contador = 0;
				
				while(scanner.hasNextLine()){
					if(contador == 0){
						nome = scanner.nextLine();
						this.nome = nome;
						
					} else if(contador == 1){
						string1 = scanner.nextLine();
						lists.add(string1);
						
					} else if(contador == 2){
						string2 = scanner.nextLine();
						lists.add(string2);

						
					} else if(contador == 3){
						scanner.nextLine();
						
						//Aluno aluno = new Aluno(numero, nome, nota);
						//lista.add(aluno);
						
						nome = "";
						string1 = "";
						string2 = "";
						contador = -1;
					}
					
					contador++;
				}
			} finally {
				scanner.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/** Write to file receiving as params a String */
	public void escreveFicheiro(String nomeFicheiro) {
		try {
			PrintWriter writer = new PrintWriter(new File(nomeFicheiro));
			try {
				for (String string : lists) {
					System.out.println("string -> " + string);
					writer.println(this.getNome());
					writer.println();
				}
			} finally {
				writer.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	

	//GETTERS AND SETTERS
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<String> getLists() {
		return lists;
	}

	public void setLists(List<String> lists) {
		this.lists = lists;
	}

	public List<String> getSubcategorias() {
		return subcategorias;
	}

	public void setSubcategorias(List<String> subcategorias) {
		this.subcategorias = subcategorias;
	}
}
