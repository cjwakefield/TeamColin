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
		DrawBackGround(g2); 
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
		for(int x = Start ; x < End ; x++)
		{
			int y = (int)Math.round(s.solveForX(x, equation)); 
			//System.out.print(y);
			g2.drawLine(screenMiddleW- x, screenHeight-y, screenMiddleW-x, screenHeight-y); 
		}
	}
}
