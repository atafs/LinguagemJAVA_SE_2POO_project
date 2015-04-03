package control_3CD;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Start_IO_03_inputOutputStream_randomAccess {
	
	public static void main(String[] args) throws IOException {
		
		//create a random-access file
		RandomAccessFile inout = new RandomAccessFile("IO_03_inputOutputStream_randomAccess.dat", "rw");
		
		//clear the file to destroy the old content
		inout.setLength(0);
		
		//write new integers to the file
		for (int i = 0; i < 200; i++) {
			inout.writeInt(i);
		}
		
		//display the current length of the file
		System.out.println("Current file length is " + inout.length());
		
		//retrieve the first number
		inout.seek(0);
		System.out.println("firstNumber: " + inout.readInt());
		
		//retrieve the second number
		inout.seek(1*4);
		System.out.println("secondNumber: " + inout.readInt());
		
		//retrieve the tenth number
		inout.seek(9*4);
		System.out.println("tenthNumber: " + inout.readInt());
		
		//modify the eleventh
		inout.writeInt(555);
		
		//append a new number
		inout.seek(inout.length());
		inout.writeInt(999);
		
		//display the new length
		System.out.println("the new length: " + inout.length());
		
		//retrieve the eleventh number
		inout.seek(10*4);
		System.out.println("eleventhNumber: " + inout.readInt());
		
		inout.close();
	}

}
