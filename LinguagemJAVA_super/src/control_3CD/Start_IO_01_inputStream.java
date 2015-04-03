package control_3CD;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

public class Start_IO_01_inputStream {
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		//create an inputStream for file
		ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(new FileInputStream("IO_01_inputStream.dat")));
		
		//write a string, a doubleValue and an object
		String name = input.readUTF();
		double score = input.readDouble();
		Date date = (Date)(input.readObject());
		System.out.println("[" + name + "], [" + score + "], [" + date + "]!!!");
		
		//close inputStream
		input.close();
	}

}
