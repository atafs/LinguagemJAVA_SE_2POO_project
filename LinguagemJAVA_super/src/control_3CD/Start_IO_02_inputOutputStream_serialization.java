package control_3CD;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Start_IO_02_inputOutputStream_serialization {

	public static void main(String[] args) throws FileNotFoundException,
			IOException, ClassNotFoundException {

		// variaveis
		int[] numbers = { 1, 2, 3, 4, 5 };
		String[] strings = { "Americo", "Tomas", "Fernandes" };

		// create an outputStream
		ObjectOutputStream output = new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream("IO_02_inputOutputStream_serialization.dat", true)));

		// writes arrays to the object stream
		output.writeObject(numbers);
		output.writeObject(strings);

		// close stream
		output.close();

		// create an input stream for file
		@SuppressWarnings("resource")
		ObjectInputStream input = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream("IO_02_inputOutputStream_serialization.dat")));

		// keep in a newFiles
		int[] newNumbers = (int[]) (input.readObject());
		String[] newStrings = (String[]) (input.readObject());

		// display arrays
		for (int i = 0; i < newNumbers.length; i++) {
			System.out.print(newNumbers[i] + " ");
		}
		System.out.println();

		for (int i = 0; i < newStrings.length; i++) {
			System.out.print(newStrings[i] + " ");
		}

	}

}
