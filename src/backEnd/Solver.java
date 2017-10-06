package backEnd;
/*
 * by Colin Wakefield
 * email cjwakefield@ksu.edu
 * 
 * This class takes a String input as infix equation and turns it in to postfix equation
 */
import java.util.ArrayList;

public class Solver 
{
	//This main is for testing only 
	public static void main(String args[])
	{
		Solver s = new Solver(); 
		
		System.out.print(s.solveForX(2, "2*x+x^x" )); 
	}
	/**solve
	 * This method solves a equation is infix notation
	 * 
	 * @param This is the operator that is being set to a value 
	 * @return This returns the solved equation for the equation  
	 */
	public double solve(String equation)
	{
		Parser p = new Parser(); 
		return solveInner(p.parse(equation)) ; 
	}
	/**solveForX
	 * This method solves a equation is infix notation
	 * 
	 * @param This is the operator that is being set to a value 
	 * @return This returns the solved equation for the equation  
	 */
	public double solveForX(double x , String equation)
	{
		Parser p = new Parser(); 
		ArrayList<String> listEquation = SetX(p.parse(equation),x);
		return solveInner(listEquation) ; 
	}
	/**solveInner
	 * This is the inner solve method that does the actual solving of a full set up equation
	 * 
	 * @param This is the operator that is being set to a value 
	 * @return This returns the solved equation for the equation  
	 */
	private double solveInner(ArrayList<String> parsedEquation)
	{
		//System.out.println("parsedEquation"+ parsedEquation);

		ArrayList<String> hold = new ArrayList<String>(); 
		for(int x = 0 ; x < parsedEquation.size() ; x++)
		{
			//System.out.println("hold"+ hold);
			//System.out.println("holds "+ hold.size());

			switch(parsedEquation.get(x))
			{
			case "^" : hold.add(pow( hold.remove(hold.size()-2 ) , hold.remove(hold.size()-1 ))); break ; 
			case "*" : hold.add(mult( hold.remove(hold.size()-2 ) , hold.remove(hold.size()-1 ))); break ; 
			case "/" : hold.add(div( hold.remove(hold.size()-2 ) , hold.remove(hold.size()-1 ))); break ; 
			case "+" : hold.add(add( hold.remove(hold.size()-2 ) , hold.remove(hold.size()-1 ))); break ; 
			case "-" : hold.add(sub( hold.remove(hold.size()-2 ) , hold.remove(hold.size()-1 ))); break ; 
			case "_" : hold.add(invert(hold.remove(hold.size()-1 ))); break ; 
			default : hold.add(parsedEquation.get(x));
			}
		}
		return Double.parseDouble(hold.get(0)) ; 
	}
	private ArrayList<String> SetX(ArrayList<String> parsedEquation ,double xIn)
	{
		for(int x = 0 ; x < parsedEquation.size(); x++)
		{
			if(parsedEquation.get(x).equals("x"))
			{
				parsedEquation.set(x, xIn+""); 
			}
		}
		return parsedEquation; 
	}
	/**pow
	 * This is a method that takes the power of a two string inputs 
	 * 
	 * @param This is the input string 
	 * @param This is the input string 
	 * @return returns a string that is the solved double  
	 */
	private String pow(String a , String b )
	{
		return Math.pow(Double.parseDouble(a), Double.parseDouble(b))+""; 
	}
	/**mult
	 * This is a method that multiplies two strings 
	 * 
	 * @param This is the input string 
	 * @param This is the input string 
	 * @return returns a string that is the solved double  
	 */
	private String mult(String a , String b )
	{
		return (Double.parseDouble(a)* Double.parseDouble(b))+""; 
	}
	/**div
	 * This is a method that divides two strings 
	 * 
	 * @param This is the input string 
	 * @param This is the input string 
	 * @return returns a string that is the solved double  
	 */
	private String div(String a , String b )
	{
		return (Double.parseDouble(a)/ Double.parseDouble(b))+""; 
	}
	/**add
	 * This is a method that adds two strings 
	 * 
	 * @param This is the input string 
	 * @param This is the input string 
	 * @return returns a string that is the solved double  
	 */
	private String add(String a , String b )
	{
		return (Double.parseDouble(a)+ Double.parseDouble(b))+""; 
	}
	/**invert
	 * This is a method that inverts 
	 * 
	 * @param This is the input string 
	 * @param This is the input string 
	 * @return returns a string that is inverted  
	 */
	private String invert(String a)
	{
		return (-Double.parseDouble(a)) +"";
	}
	/**sub
	 * This is a method that subtracts two strings 
	 * 
	 * @param This is the input string 
	 * @param This is the input string 
	 * @return returns a string that is the solved double  
	 */
	private String sub(String a , String b )
	{
		return (Double.parseDouble(a)- Double.parseDouble(b))+""; 
	}
}
