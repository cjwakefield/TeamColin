package Screen;
import java.awt.*;
import javax.swing.*;

import backEnd.GraphDrawer;

public class Main_Screen extends JPanel implements Runnable
{
    private JFrame frame;
    private int screenWidth , screenHeight  , graphStart , graphEnd; 
    private Thread t ; 
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
    	graphStart = -screenWidth/2; 
    	graphEnd = screenWidth/2; 

    	//settings for the JFrame
        frame = new JFrame();
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this); 
        
        this.setDoubleBuffered(true);
        this.setBounds(0,0,500, 500);
        this.setVisible(true);
        
        
        
		 t = new Thread(this);
        //keep at the end 
	    frame.getContentPane().setPreferredSize(new Dimension(screenWidth ,screenHeight ));
        frame.pack(); 
        frame.setSize(screenWidth, screenHeight);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    @Override
    public void paintComponent(Graphics g)
    {
    	Graphics2D g2 = (Graphics2D)g ; 
    	GraphDrawer gd = new GraphDrawer(screenWidth,screenHeight , "   (1/20)*x^3+5*x^2-7*x  "); 
    	gd.DrawGraph(g2 ,graphStart , graphEnd ); 

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
			catch (InterruptedException e) {e.printStackTrace();}
			running = false ;
		}
	}
	public void update()
	{
		
	}

}
