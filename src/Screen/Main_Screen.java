package Screen;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.*;
import javax.swing.border.Border;

import backEnd.Graph;
import backEnd.GraphHandler;

public class Main_Screen extends JPanel implements Runnable , MouseListener  , KeyListener ,MouseWheelListener
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
        addMouseWheelListener(this);
        //graph
        gh = new GraphHandler(GraphWidth,GraphHeight);
    	gh.add("x^2+1");
    	gh.add("x^2+x^7");
    	gh.add("x^3*3*x");
    	//gh.add("x^7---x^2");
    	gh.setScale(.05);
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

			//System.out.println("running");
		}
	}
	public void update()
	{
		
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) 
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * This changes the scale of the graph; 
	 * @param This is a implmented method for the MouseWeel
	 */
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) 
	{
		int notches = e.getWheelRotation();
		double scale = gh.getScale();
		//System.out.println("N :"+notches);
		//System.out.println("S :" + scale);
		if((scale > .001 ||notches > 0 ) && notches != 0 )
		{
		
			if (notches > 0  ) 
			{
				scale = scale + .001; 
				gh.setScale(scale);
			}
			else
			{
				scale = scale - .001; 
				gh.setScale(scale);
			}
		}
	}


}
