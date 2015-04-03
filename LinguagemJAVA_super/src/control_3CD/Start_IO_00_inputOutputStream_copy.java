package control_3CD;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Start_IO_00_inputOutputStream_copy {
	
	public static void main(String[] args) throws IOException {
		
		//checks command-line parameter usage
		if(args.length != 2) {
			System.out.println("MESSAGE TO COPY/SEND...");
			System.exit(0);
		}
		
		//checks whether sourceFile existes
		File sourceFile = new File(args[0]);
		if(!sourceFile.exists()) {
			System.out.println("SourceFile " + args[0] + " not exists!");
			System.exit(0);
		}
		
		//checks whether target file exists
		File targetFile = new File(args[1]);
		if(targetFile.exists()) {
			System.out.println("targetFile " + args[1] + "already exists!!!");
		}
		
		//create an input stream
		BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile));
		//create an output stream
		BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile));
		
		//continuously read a byte from input and write it from output
		int r = 0; int numberOfByteCopied = 0;
		while ((r = input.read()) != -1) {
			output.write ((byte)r);
			numberOfByteCopied++;
		}
		
		//close stream
		input.close();
		output.close();
		
		//display the file size
		System.out.println(numberOfByteCopied + " bytes copied");
	}
}
