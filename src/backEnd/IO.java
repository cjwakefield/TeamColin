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
public class IO implements Runnable 
{
	private Scanner kboard;
	private GraphHandler gh ; 
	private boolean[] running ; 
	
	public IO(GraphHandler gh , boolean[] running)
	{
		this.gh = gh ; 
		this.running = running ; 
	}
	/**
	 * This method asks the user to input a polynomial or 'e' to see an example.
	 * @return The polynomial that has been entered by the user.
	 */
	public void receiveInput() 
	{
		//Parser p = new Parser() ; 
		kboard = new Scanner(System.in);
		System.out.println("***POLYNOMIAL CALCULATOR***");
		System.out.print("Enter in a polynomial or 'h' for help: ");
		String input = kboard.nextLine();
		
		while(!input.equalsIgnoreCase("q"))
		{
			if(input.equalsIgnoreCase("h")) 
			{
				System.out.println("\nIf you wanted to type in 3x^2 + 2x + 1, it would be:"
									+ "\n\t3*x^2+2*x+1");
			}
			else
			{
				gh.add(input);
			}
			
			
			System.out.print("Enter in a polynomial or 'h' for help: ");
			input = kboard.nextLine();
		}
	}

	@Override
	public void run() 
	{
		receiveInput();
		running[0] = false ; 
		System.out.println(running[0]);

	}

}
