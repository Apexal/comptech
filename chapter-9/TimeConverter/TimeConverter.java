import java.util.Scanner;

public class TimeConverter {
	public static String convert(String twentyFourHour) throws TimeFormatException {
		if(!twentyFourHour.matches("\\d{2}:\\d{2}"))
			throw new TimeFormatException();
		
		String[] parts = twentyFourHour.split(":");
		int hours = Integer.parseInt(parts[0]);
		int minutes = Integer.parseInt(parts[1]);
		
		String period = "AM";
		
		if(hours >= 12)
			period = "PM";
			
		if(hours > 12)
			hours -= 12;
		
		if(hours == 0)
			hours = 12;
		
		String minutesStr = (minutes < 10 ? "0" : "") + minutes;
		
		return hours + ":" + minutesStr + " " + period;
	}
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		boolean cont = true;
		
		while(cont) {
			System.out.print("Enter 24 hour time: ");
			String twentyFourHour = input.next();
			try {
				System.out.println(convert(twentyFourHour));
			} catch (TimeFormatException e) {
				System.out.println(e.getMessage());
			}
			
			System.out.print("Continue? (y/n) ");
			cont = input.next().equalsIgnoreCase("y");
		}
		
		System.out.println("\nSee ya!");
	}
}
