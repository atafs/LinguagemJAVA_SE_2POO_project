package control_3CD;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class Start_IO_01_outputStream {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		//create an output stream value for file object.dat
		//ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("object.dat"));
		/* to improve performance */
		ObjectOutputStream output = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("IO_01_inputStream.dat")));

		
		//write a string, double value and object to the file
		output.writeUTF("Americo");
		output.writeDouble(19.8);
		output.writeObject(new Date());
		
		//close outputStream
		output.close();
	}
}
