import java.util.Scanner;

public class SubstitutionCipher implements MessageEncoder {
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	
	private int shift;
	
	public SubstitutionCipher() {
		this.shift = 1; // Default value
	}
	
	public SubstitutionCipher(int shift) {
		this.shift = shift; // In case it is used some other way
	}
	
	/**
	 * Asks the user for the shift amount and sets it.
	 * 
	 * @return Nothing.
	 */
	public void init() {
		System.out.print("Shift amount: ");
		this.shift = new Scanner(System.in).nextInt();
	}
	
	/**
	 * Shifts the passed character by a certain amount while keeping
	 * spaces and punctuation.
	 * 
	 * @param c Character to shift.
	 * @return char The new character that has been shifted.
	 */
	private char shiftChar(char c) {
		int charPos = ALPHABET.indexOf(c);
		if(charPos == -1) { return c; } // If punctuation/space/etc
		
		return ALPHABET.charAt((charPos + shift) % 26);
	}
	
	/**
	 * Encodes the passed String by using shift() to shift each character
	 * over by a certain amount.
	 * 
	 * @param plainText String to be encoded.
	 * @return String The encoded string.
	 */
	public String encode(String plainText) {
		plainText = plainText.toLowerCase(); // makes it easier
		
		char[] chars = new char[plainText.length()];
		
		for(int i = 0; i < plainText.length(); i++) {
			char shifted = ' ';
			
			if(plainText.charAt(i) != ' ') {
				shifted = shiftChar(plainText.charAt(i));
			}
			
			chars[i] = shifted;
		}
		return new String(chars);
	}
}
