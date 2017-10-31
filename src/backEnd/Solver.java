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
	ArrayList<String> parsed ; 
	//This main is for testing only 
	public static void main(String args[])
	{
		Solver s = new Solver();
		s.setParsed("2*x");
		System.out.print(s.solveForX(2));
	}
	/**solve
	 * This method solves a equation is infix notation
	 * 
	 * @param This is the operator that is being set to a value 
	 * @return This returns the solved equation for the equation  
	 */
	public double solve()
	{
		return solveInner(parsed) ; 
	}
	public void setParsed(String equation)
	{
		Parser p = new Parser(); 
		parsed = p.parse(equation);
	}
	/**solveForX
	 * This method solves a equation is infix notation
	 * 
	 * @param This is the operator that is being set to a value 
	 * @return This returns the solved equation for the equation  
	 */
	public double solveForX(double x )
	{
		ArrayList<String> listEquation = SetX(x);
		System.out.println(listEquation);
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
		@SuppressWarnings("unchecked")
		ArrayList<String> tempParsed =(ArrayList<String>) parsedEquation.clone(); 
		ArrayList<String> hold = new ArrayList<String>(); 
		
		while(tempParsed.size() > 0 )
		{
			System.out.println("hold"+ hold);
			System.out.println("temp"+ tempParsed);
			//System.out.println("holds "+ hold.size());
			String var = tempParsed.remove(0); 
			switch(var)
			{
			case "^" : hold.add(pow( hold.remove(hold.size()-2 ) , hold.remove(hold.size()-1 ))); break ; 
			case "*" : hold.add(mult( hold.remove(hold.size()-2 ) , hold.remove(hold.size()-1 ))); break ; 
			case "/" : hold.add(div( hold.remove(hold.size()-2 ) , hold.remove(hold.size()-1 ))); break ; 
			case "+" : hold.add(add( hold.remove(hold.size()-2 ) , hold.remove(hold.size()-1 ))); break ;
			case "-" :
				try
				{
					
					hold.add(sub( hold.remove(hold.size()-2 ) , hold.remove(hold.size()-1 ))); 
				}catch(Exception e)
				{
					// very close 
					Invert(tempParsed ,hold, -1); 
				}
				
				
				break ; 
			default : hold.add(var);
			}
			
		}
		return Double.parseDouble(hold.get(0)) ; 
	}
	private ArrayList<String> SetX(double xIn)
	{
		@SuppressWarnings("unchecked")
		ArrayList<String> parsedEquation = (ArrayList<String>) parsed.clone(); 
		
		for(int x = 0 ; x < parsedEquation.size(); x++)
		{
			if(parsedEquation.get(x).contains("x"))
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

	/**sub
	 * This is a method that subtracts two strings 
	 * 
	 * @param This is the input string 
	 * @param This is the input string 
	 * @return returns a string that is the solved double  
	 */
	private String sub(String a , String b )
	{
		
			double one = Double.parseDouble(a) ; 
			double two = Double.parseDouble(b) ; 
			return (one - two) +"";
			 
		
	}
	private void Invert(ArrayList <String> tempParsed ,ArrayList <String> Hold, int versionOfOne)
	{
		String temp =  tempParsed.remove(0) ; 

		try
		{
			Hold.add( ""+(Double.parseDouble(temp)*versionOfOne)); 

		}catch(Exception e )
		{
			Invert(tempParsed ,Hold,versionOfOne * -1 ); 
		}
	}
}
