import java.util.Scanner;
import java.util.Random;

public class CallHandler {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		ServiceRequests sr = new ServiceRequests();
		
		String[] names = {"Doug", "Nancy", "John", "Frank", "Sally"};
		
		for(int i = 0; i < 12; i++){
			try {
				String name = names[new Random().nextInt(names.length)];
				sr.addName(name);
				System.out.println(sr.getName(i+1));
			} catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("There are only a max of 10 users!");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}
