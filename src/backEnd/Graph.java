package backEnd;

import java.awt.Graphics2D;

public class Graph 
{
	private String equation ; 
	private int GraphMiddleW , GraphMiddleH; 
	public Graph (String equation , int screenMiddleW ,int  screenMiddleH)
	{
		this.equation = equation; 
		this.GraphMiddleW = screenMiddleW;
		this.GraphMiddleH = screenMiddleH; 
	}
	public void Draw(Graphics2D g2 , int Start , int End , double Scale)
	{
		Solver s = new Solver(); 
		s.setParsed(equation); 
		double ScaledEnd = (int)End*Scale; 

		double ScaledCounter = ScaledEnd ;
		double Counter = End ; 
		while ( Counter >= Start )
		{
			ScaledCounter = ScaledCounter - Scale ; 
			Counter -= 1 ; 
			int y = (int) (s.solveForX(ScaledCounter)/Scale); 
			int y2 = (int) (s.solveForX(ScaledCounter+Scale)/Scale); 

			g2.drawLine( (int)(GraphMiddleW+ Counter) , (int)(GraphMiddleH-y), (int)(GraphMiddleW+Counter+1), (int)(GraphMiddleH-y2)); 
		}
	}
	public String toString()
	{
		return equation ;
	}
}
