package Screen;
import java.util.*;
/*
 * By: Nathan Sellers
*/

import backEnd.GraphHandler;

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
		System.out.print("Enter in a polynomial or 'r' to remove : ");
		String input = kboard.nextLine();
		
		while(!input.equalsIgnoreCase("q"))
		{
			if(input.equalsIgnoreCase("r")) 
			{
				try
				{
				
				for(int x= 0 ; x < gh.Size() ; x++)
				{
					System.out.println(x+": "+gh.getEquation(x)); 
				}
				System.out.print("input integer value to remove : ");

				int tmp = Integer.parseInt(kboard.nextLine());
				gh.remove(tmp);
				
				}catch(Exception e)
				{
					System.out.println("You messed up! ");

				}
			}
			else
			{
				gh.add(input);
			}
			
			
			System.out.print("Enter in a polynomial or 'r' to remove : ");
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
