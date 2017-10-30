package backEnd;
import java.awt.*;
import java.util.ArrayList;


public class GraphHandler
{
	private int screenWidth , screenHeight , screenMiddleW , screenMiddleH ; 
	private double scale ; 
	private ArrayList<Graph> equations;  
	public GraphHandler(int width , int height )
	{
		screenWidth = width ; 
		screenHeight = height ; 
		screenMiddleW = screenWidth/2; 
		screenMiddleH = screenHeight/2; 
		this.equations = new ArrayList<>(); 
	}
	public void Draw(Graphics2D g2 , int start , int end )
	{
    	g2.setColor(Color.black);

		DrawBackGround(g2); 
    	g2.setColor(Color.red);
    	for(Graph g : equations)
    	{
    		g.Draw(g2 ,start , end , scale); 
    	}
	}
	private void DrawBackGround(Graphics2D g2)
	{
		g2.drawLine(screenWidth/2, 0, screenWidth/2, screenHeight);
		g2.drawLine(0, screenHeight/2, screenWidth, screenHeight/2);
	}
	public void add(String equation)
	{
		equations.add(new Graph(equation , screenMiddleW , screenMiddleH)); 
	}
	public void remove(int x)
	{
		equations.remove(x); 
	}
	public void setScale(double scale )
	{
		this.scale = scale; 
	}
}
