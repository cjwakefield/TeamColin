package backEnd;
import java.util.*;
/*
 * By: Nathan Sellers
*/

/**
 * This class serves as a view class for Main_Screen, which is a class
 * that contains a main method.
 * @return String that has been entered in by user.
 */
public class IO 
{
	private Scanner kboard;
	
	/**
	 * This method asks the user to input a polynomial or 'e' to see an example.
	 * @return The polynomial that has been entered by the user.
	 */
	public String receiveInput() 
	{
		kboard = new Scanner(System.in);
		System.out.println("***POLYNOMIAL CALCULATOR***");
		System.out.print("Enter in a polynomial or 'e' to see an example: ");
		String input = kboard.nextLine();
		if(input.charAt(0) == 'e' || input.charAt(0) == 'E') 
		{
			System.out.println("\nIf you wanted to type in 3x^2 + 2x + 1, it would be:"
								+ "\n\t3*x^2+2*x+1");
			System.out.print("Enter in a polynomial: ");
			return kboard.nextLine();
		}
		else
			return input;
	}

}
