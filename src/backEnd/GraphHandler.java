package backEnd;
import java.awt.*;
import java.util.ArrayList;


public class GraphHandler
{
	private int screenWidth , screenHeight , screenMiddleW , screenMiddleH ,Pwidth  ,Pheight ; 
	private double scale ; 
	private ArrayList<Graph> equations;  
	public GraphHandler(int screenwidth , int screenheight   )
	{
		this.screenWidth = screenwidth +Pwidth; 
		this.screenHeight = screenheight+Pheight ; 
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

		g2.drawLine(0, 0, screenWidth, 0);
		g2.drawLine(0, 0, 0, screenHeight);
		g2.drawLine(0, screenHeight-1, screenWidth-1,screenHeight-1 );
		g2.drawLine(screenWidth-1, 0, screenWidth-1,screenHeight-1 );
		
		g2.drawLine(screenWidth/2, 0, screenWidth/2, screenHeight);
		g2.drawLine(0, screenHeight/2, screenWidth, screenHeight/2);
		
		
		int dashedLineSpace = (int) (1/scale) ; 
		if(dashedLineSpace > 1 )
		{
			for(int x = screenWidth/2 ; x < screenWidth; x+= dashedLineSpace)
				g2.drawLine(x, (screenWidth/2)-3, x, (screenWidth/2)+3);
			
			for(int y = screenHeight/2 ; y < screenHeight; y+= dashedLineSpace)
				g2.drawLine((screenHeight/2)-3, y, (screenHeight/2)+3, y);
			
			for(int x = screenWidth/2 ; x > 0; x-= dashedLineSpace)
				g2.drawLine(x, (screenWidth/2)-3, x, (screenWidth/2)+3);
			
			for(int y = screenHeight/2 ; y > 0; y-= dashedLineSpace)
				g2.drawLine((screenHeight/2)-3, y, (screenHeight/2)+3, y);
		}
		else
		{
			 dashedLineSpace = (int) (5*scale) ; 
			for(int x = screenWidth/2 ; x < screenWidth; x+= dashedLineSpace)
				g2.drawLine(x, (screenHeight/2)-3, x, (screenHeight/2)+3);
			for(int x = screenWidth/2 ; x > 0; x-= dashedLineSpace)
				g2.drawLine(x, (screenHeight/2)-3, x, (screenHeight/2)+3);
		}

	
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
	public int Size()
	{
		return equations.size(); 
	}
	public double getScale( )
	{
		return scale; 
	}
	public String getEquation(int x )
	{
		return equations.get(x).toString(); 
	}
}
