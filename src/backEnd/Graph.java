package backEnd;

import java.awt.Graphics2D;

public class Graph 
{
	private String equation ; 
	private int screenMiddleW , screenMiddleH; 
	public Graph (String equation , int screenMiddleW ,int  screenMiddleH)
	{
		this.equation = equation; 
		this.screenMiddleW = screenMiddleW;
		this.screenMiddleH = screenMiddleH; 
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
			int y = (int)s.solveForX(ScaledCounter); 
			int y2 = (int)s.solveForX(ScaledCounter+Scale); 

			g2.drawLine( (int)(screenMiddleW+ Counter) , (int)(screenMiddleH-y), (int)(screenMiddleW+Counter+1), (int)(screenMiddleH-y2)); 
		}
	}
}
