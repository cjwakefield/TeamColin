package backEnd;
import java.awt.*;


public class GraphDrawer
{
	private String equation; 
	private int screenWidth , screenHeight , screenMiddleW , screenMiddleH; 
	public GraphDrawer(int width , int height , String equation)
	{
		screenWidth = width ; 
		screenHeight = height ; 
		screenMiddleW = screenWidth/2; 
		screenMiddleH = screenHeight/2; 
		this.equation = equation ; 
	}
	public void DrawGraph(Graphics2D g2 , int start , int end )
	{
    	g2.setColor(Color.black);

		DrawBackGround(g2); 
    	g2.setColor(Color.red);
		DrawGraph_private(g2 ,start , end); 
	}
	private void DrawBackGround(Graphics2D g2)
	{
		g2.drawLine(screenWidth/2, 0, screenWidth/2, screenHeight);
		g2.drawLine(0, screenHeight/2, screenWidth, screenHeight/2);
	}
	private void DrawGraph_private(Graphics2D g2 , int Start , int End)
	{
		Solver s = new Solver(); 
		for(int x = End ; x > Start ; x--)
		{
			int y = (int)s.solveForX(x, equation); 
			int y2 = (int)s.solveForX(x+1, equation); 

			
			//System.out.print(y);
			g2.drawLine((screenMiddleW+ x), (screenMiddleH+-y), (screenMiddleW+x+1), (screenMiddleH+-y2)); 
		}
	}
}
