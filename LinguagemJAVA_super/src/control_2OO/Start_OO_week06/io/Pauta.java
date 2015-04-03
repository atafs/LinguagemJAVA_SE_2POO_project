package control_2OO.Start_OO_week06.io;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Pauta {

	//ATTRIBUTES
	private ArrayList<Aluno> lista;
	
	//CONSTRUCTOR
	public Pauta() {
		lista = new ArrayList<Aluno>();
	}
	
	//TOSTRING
	@Override
	public String toString() {
		String toReturn = "";
		
		for (Aluno aluno : lista) {
			toReturn += aluno.toString() + "\n";
		}
		
		return toReturn;
	}
	
	
	/** Add a student to a List (ArrayList) receiving as params a Student */
	public void adicionaAluno(Aluno aluno) {
		lista.add(aluno);
	}
	
	/** Read from file receiving as params a String */
	public void leFicheiro(String nomeFicheiro){
		try {
			Scanner scanner = new Scanner(new File(nomeFicheiro));
			try {
				
				int numero = -1;
				String nome = "";
				String nota = "";
				int contador = 0;
				
				while(scanner.hasNextLine()){
					if(contador == 0){
						nome = scanner.nextLine();
						
					} else if(contador == 1){
						numero = scanner.nextInt();
						scanner.nextLine();
						
					} else if(contador == 2){
						nota = scanner.nextLine();
						
					} else if(contador == 3){
						scanner.nextLine();
						
						Aluno aluno = new Aluno(numero, nome, nota);
						lista.add(aluno);
						
						numero = -1;
						nome = "";
						nota = "";
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
				for (Aluno aluno : lista) {
					writer.println(aluno.getNome());
					writer.println(aluno.getNumero());
					writer.println(aluno.getNota());
					writer.println();
				}
			} finally {
				writer.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
