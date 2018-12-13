import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

public class MyPanel extends JPanel
{
	public MyPanel( )
	{
		numC = 0;
		numS = 0;
		setPreferredSize(new Dimension(300, 300));
		setBackground(Color.WHITE);
	}
	
	/**
	 * Draw the circles or the squares.  One of the instance fields
	 * should be zero and the other nonzero.
	 */
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
		... // let count = the number of objects to be drawn
		... // let size = the minimum of the width and height of the panel
		... // then let gap between one circle or square and the next one is:  0.4 * size / count
		// the above line assumes that the drawing will take place on the center 80% of the panel
		
		// determine the x and y coordinates of the center of the panel
		...
		...
		
		// within a loop:  draw the required number of circles
		...
		
		
		// within a loop:  draw the required number of squares
		...
	}
	
	/**
	 * This is the method called from the actionPerformed method of the ButtonListener class.
	 * One of the parameters should be zero and the other nonzero.
	 * @param circles: the number of circles to draw
	 * @param squares: the number of squares to draw
	 */
	
	public void setData(int circles, int squares)
	{
		numC = circles;
		numS = squares;
		repaint( );
	}
	
	/**
	 * The instance fields represent the number of circles and the number of
	 * squares to be drawn.
	 */
	
	private int numC;
	private int numS;
}
