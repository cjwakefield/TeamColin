package Screen;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import backEnd.Graph;
import backEnd.GraphHandler;

public class Main_Screen extends JPanel implements Runnable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
    private int screenWidth , screenHeight  , graphStart , graphEnd, GraphWLocation 
    , GraphHLocation, GraphWidth ,GraphHeight; 
    private Thread t ; 
    GraphHandler gh ; 
    private boolean running = true  ; 
    
    public Main_Screen(String title)
    {
        init();
        t.start(); // calls the run() method to start the loop  
    }
    private void init()
    {
    	//
    	screenWidth = 500 ; 
    	screenHeight = 500 ; 
    	GraphWidth = 400 ; 
    	GraphHeight = 400 ;
    	GraphWLocation = 0 ; 
    	GraphHLocation = 0; 
    	graphStart = -(GraphWidth+GraphWLocation)/2; 
    	graphEnd = (GraphHeight+GraphHLocation)/2; 

    	//settings for the JFrame
        frame = new JFrame();
        frame.setLayout(null);
        //frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setDoubleBuffered(true);
        this.setBounds(GraphWLocation,GraphHLocation,GraphWidth, GraphHeight);
        this.setVisible(true);
        frame.add(this); 
        
        
        
		 t = new Thread(this);
        //keep at the end 
	    frame.setPreferredSize(new Dimension(screenWidth, screenHeight));
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);


        
        //classes 
        //graph
        gh = new GraphHandler(GraphWidth,GraphHeight ,GraphWLocation , GraphHLocation  );
    	gh.add("x^2+1");
    	gh.add("x^2+x^7");
    	//gh.add("x^7---x^2");
    	gh.setScale(.1);
    	//list on screen  
    	//JList<Graph> graphList = new JList<Graph>();
    	//JScrollPane listScroller = new JScrollPane(graphList);
    	//listScroller.setPreferredSize(new Dimension(50, screenHeight));
    }
    @Override
    public void paintComponent(Graphics g)
    {
    	
    	Graphics2D g2 = (Graphics2D)g ; 
    	g2.clearRect(0, 0, screenWidth, screenHeight);
    	gh.Draw(g2 ,graphStart , graphEnd ); 
    	//System.out.print("cats");
    }
	@Override
	public void run()  
	{
		while(running)
		{
			this.update(); 
			this.repaint();
			try {
				Thread.sleep(100);// is a wait for the loop 
				} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
				running = false ;
			}
		}
	}
	public void update()
	{
		
	}

}
