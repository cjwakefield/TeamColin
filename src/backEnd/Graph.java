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
	public void Draw(Graphics2D g2 , int Start , int End)
	{
		System.out.println(Start +" "+ End);
		Solver s = new Solver(); 
		s.setParsed(equation); 
		for(int x = End ; x > Start ; x--)
		{
			System.out.println(x);
			int y = (int)s.solveForX(x); 
			int y2 = (int)s.solveForX(x+1); 
			//System.out.println(y);
			//System.out.println(y2);
			//System.out.println((screenMiddleH-y2));
			//System.out.println((screenMiddleW+x+1));
			//System.out.println((screenMiddleH-y));
			//System.out.println((screenMiddleW+ x));
			System.out.println((screenMiddleH));
			System.out.println((screenMiddleW));
			g2.drawLine((screenMiddleW+ x), (screenMiddleH-y), (screenMiddleW+x+1), (screenMiddleH-y2)); 
		}
	}
}
