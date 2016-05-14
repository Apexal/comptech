import java.util.Scanner;

public class ShuffleCipher implements Coder {
	private int shuffleAmount;
	
	public void init() {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter shuffle amount: ");
		shuffleAmount = input.nextInt();
	}
	
	/**
	 * This method encodes a String by splitting it in half and swapping
	 * characters from each half alternately (shuffling it).
	 * 
	 * @param plainText The String to be shuffled.
	 * @return String The shuffled String.
	 */
	private String shuffle(String plainText) {
		// Round the length so the left half gets the extra char if length is not even
		int halfIndex = Math.round((float)plainText.length() / 2);
		
		String[] halves = {plainText.substring(0, halfIndex), plainText.substring(halfIndex)};
		
		int lLength = halves[0].length();
		int rLength = halves[1].length();
		
		String encoded = "";
		for(int i = 0; i < Math.max(lLength, rLength); i++) {
			// Make sure the character in each half exists since one side may be longer than the other
			char leftChar = (i < lLength ? halves[0].charAt(i) : ' ');
			char rightChar = (i < rLength ? halves[1].charAt(i) : ' ');
			
			encoded += leftChar;
			encoded += rightChar;
		}
		return encoded;
	}
	
	/**
	 * This method takes the passed String and shuffles it based on the
	 * previously set shuffleAmount.
	 * 
	 * @return String The encoded String.
	 */
	public String encode(String plainText) {
		for(int i = 0; i < shuffleAmount; i++) {
			plainText = shuffle(plainText);
		}
		return plainText;
	}
	
	public String decode(String cipherText) {
		throw new UnsupportedOperationException("Not yet implemented!");
	}
}
