package modules.enums;

public enum MainStrings {
	STRING_ONE("One"), STRING_TWO("Two");

	// ATTRIBUTES
	private final String text;

	// CONSTRUCTOR
	private MainStrings(final String text) {
		this.text = text;
	}

	// TOSTRING
	@Override
	public String toString() {
		return "STRING: " + text;
	}

	// MAIN FOR TESTS
	public static void main(String[] args) throws InterruptedException {
		System.out.println(STRING_ONE);
		Thread.sleep(350); // pause
		System.err.println(STRING_TWO);
	}
}
