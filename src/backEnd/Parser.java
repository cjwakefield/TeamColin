package backEnd;
/*
 * by Colin Wakefield
 * email cjwakefield@ksu.edu
 * 
 * This class takes a String input as infix equation and turns it in to postfix equation
 */
import java.util.*; 
public class Parser
{
	/**parse
	 * This is the main method for the Parser class that actually does the translation from infix to postfix 
	 * 
	 * @param This is the infix equation input 
	 * @return This is the out put in postfix chopped in to numbers and variables. 
	 */
	public ArrayList<String> parse(String equation)
	{
		String equationList[] = format(equation); 
		ArrayList<String> operators = new ArrayList<String>();
		ArrayList<String> outPut = new ArrayList<String>();
		ArrayList<String> SingleInt = new ArrayList<String>();
		for(int x = 0 ; x < equationList.length ; x++)
		{
			switch(equationList[x])
			{
			case "(" : operators.add("("); break ; 
			case ")" : CompundInt(SingleInt , outPut);HandleClosing(operators , outPut); SingleInt = new ArrayList<String>();break ; 
			case "." : SingleInt.add("."); break ;
			case "0" : SingleInt.add("0"); break ;
			case "1" :SingleInt.add("1");  break ;
			case "2" :SingleInt.add("2"); break ;
			case "3" :SingleInt.add("3"); break ;
			case "4" :SingleInt.add("4"); break ;
			case "5" :SingleInt.add("5"); break ;
			case "6" :SingleInt.add("6"); break ;
			case "7" :SingleInt.add("7"); break ;
			case "8" :SingleInt.add("8"); break ;
			case "9" :SingleInt.add("9"); break ;
			case "^" :CompundInt(SingleInt , outPut);pickOperatorPosition(operators ,outPut, "^" );  SingleInt = new ArrayList<String>(); break ;
			case "*" :CompundInt(SingleInt , outPut);pickOperatorPosition(operators ,outPut, "*" ); SingleInt = new ArrayList<String>();  break ;
			case "/" :CompundInt(SingleInt , outPut);pickOperatorPosition(operators ,outPut, "/" ); SingleInt = new ArrayList<String>();  break ;
			case "+" :CompundInt(SingleInt , outPut);pickOperatorPosition(operators ,outPut, "+" ); SingleInt = new ArrayList<String>();  break ;
			case "-" :CompundInt(SingleInt , outPut);pickOperatorPosition(operators ,outPut, "-" ); SingleInt = new ArrayList<String>();  break ;
			case "x" :CompundInt(SingleInt , outPut) ; SingleInt.add("x"); break ;
			}
			//System.out.println("outPut"+outPut);
			//System.out.println("SingleInt"+SingleInt);
			//System.out.println("operators"+operators);
		}
		
		if(SingleInt.size() >= 1)
			CompundInt(SingleInt , outPut);
		
		outPut.addAll(invert(operators));
		
		return outPut ; 
	}
	/**format
	 * This method formats the incoming string so that it can be used.
	 * 
	 * @param The string to be formated.
	 * @return The arrayList of strings that will be used in the parse equation.
	 */
	private String[] format(String equation )
	{
		equation = equation.replaceAll("\\s","");
		//equation = "("+equation+")"; 
		String[] equationList = equation.split(""); 

		return equationList ; 
	}
	/**CompundInt
	 * This method compounds an Arraylist of integers into one integer
	 * 
	 * @param This is the list that will be compounded.
	 * @param This is the outPut list that will be outPut in the end.
	 */
	private void CompundInt(ArrayList<String> IntList, ArrayList<String> outPut)
	{
		if(IntList.size()> 0 )
		{
			String tmp = "" ; 		
			for(int x = 0 ; x < IntList.size() ; x ++ )
			{
				tmp += IntList.get(x); 
			}
			outPut.add(tmp); 
		}
	}
	/**HandleClosing
	 * This method deals with the closing of a () pair 
	 * 
	 * @param This is the operatorslist 
	 * @param This is the outPut list that will be outPut in the end.
	 */
	private void HandleClosing(ArrayList<String> operators, ArrayList<String>  outPut)
	{
		////System.out.println("operators"+operators);
		ArrayList<String> tmp = new ArrayList<String>()  ; 
		int x = operators.size()-1; 
		while(!operators.get(x).equals("("))
		{
			tmp.add(operators.remove(x)); 
			x--;
		}
		operators.remove(operators.size()-1);
		//System.out.println("operators"+operators);
		//System.out.println("operators"+operators.size());
		//System.out.println("tmp"+tmp);
		//System.out.println("tmp"+tmp.size());
		outPut.addAll(tmp);
	}
	//needs fixing 
	/**pickOperatorPosition
	 * This method picks the way that the operators will be handled 
	 * 
	 * @param This is the operators list 
	 * @param This is the outPut list that will be outPut in the end.
	 * @param This is the operator that is being up in to the equation
	 */
	private void pickOperatorPosition(ArrayList<String> operators, ArrayList<String> outPut , String inputOp)
	{
		////System.out.println(operators);
		////System.out.println(inputOp);
		if(operators.size() > 0 && !inputOp.equals("("))
		{
			int inputOpNum = getOperatorValue(inputOp);
			ArrayList<String> tmp = new ArrayList<String>() ;
			
			int x = operators.size()-1 ; 
			while(x >= 0 && inputOpNum <= getOperatorValue(operators.get(x)))
			{
				tmp.add(operators.remove(x)); 
				x--;
			}
			
			outPut.addAll(tmp);
			operators.add(inputOp); 
		}
		else
		{
			operators.add(inputOp); 
		}
	}
	/**getOperatorValue
	 * This is a helper for a helper that sets the values for the operators 
	 * 
	 * @param This is the operator that is being set to a value 
	 */
	private int getOperatorValue(String operator )
	{
		int tmp = 0; 
		switch(operator)
		{
		case "_" : tmp = 1000; break;
		case "(" : tmp = -999; break;
		case "^" : tmp = 300; break;
		case "*" : tmp = 200; break;
		case "/" : tmp = 200; break;
		case "\\" : tmp = 200; break;
		case "+" : tmp = 100; break;
		case "-" : tmp = 100; break;
		default : tmp = 0; break;
		}
		
		return tmp ; 
	}
	/**invert
	 * This method inverts a list so that it can be put in.
	 * 
	 * @param This is the list that will be inverted
	 */
	private ArrayList<String> invert(ArrayList<String> in )
	{
		ArrayList<String> out = new ArrayList<String>(); 
		for(String x : in) 
		{
			out.add(0 ,x ); 
		}
		
		return out ; 
	}


}
