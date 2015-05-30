package modules.enums;

import java.util.Scanner;

public class MainColorCheck {
	
	// ATTRIBUTES
	private enum Color{
		RED("The color is Red"), BLACK("The color is Black"), OTHERS("That color does not exist");
		
		// ATTRIBUTES ENUM
		private final String text;

		// CONSTRUCTOR ENUM
		private Color(final String text) {
			this.text = text;
		}

		// TOSTRING ENUM
		@Override
		public String toString() {
			return "STRING: " + text;
		}
	};
	
	// METHOD
	/** write on the console red or black to get a result of the selection */
	@SuppressWarnings("resource")
	public Color getColorGuess() {
		
		// USER INPUT
		System.out.println("INPUT COLOR: (choose red, black or others)\n");
		Scanner in = new Scanner(System.in); 
		
		// SELECTION
		while (in.hasNextLine()) {
			// .toUpperCase() lets you type "red" or "RED" and still match
			String line = in.nextLine().toUpperCase();
			try {
				// Enum.valueOf() throws an exception if the input is not valid
				Color guess = Color.valueOf(line);

				switch (guess) {
				case RED:
					System.out.println("\nSUCCESS:");
					return guess; 

				case BLACK:
					System.out.println("\nSUCCESS:");
					return guess;
				case OTHERS: 
					System.out.println("\nNOT SUCCESSFULL:");
					return guess;
				}
			} catch (IllegalArgumentException e) {
				System.out.println("Invalid color selection!");
			}
		}
		return null;
	}
	
	//MAIN
	public static void main(String[] args) {
		//INSTANTIATE AND PRINT
		MainColorCheck test = new MainColorCheck();
		System.out.println(test.getColorGuess().toString());
	}
}
