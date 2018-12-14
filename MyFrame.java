import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame
{
	public MyFrame( )
	{
		drawingPanel = new MyPanel( );
		add(drawingPanel, BorderLayout.CENTER);
		createControlPanel( );
		pack( );
	}
	
	public void createControlPanel( )
	{
		JPanel panel = new JPanel( );
		panel.setBackground(Color.lightGray);
		JLabel label = new JLabel("Number:");
		numberFld = new JTextField(3);
		numberFld.setText("5");
		panel.add(label);
		panel.add(numberFld);
		
		// make a "Draw Circles" button by calling makeButton and add it to the panel
		JButton circleButton = makeButton("Draw Circles");
		drawingPanel.add(circleButton);
		
		// make a "Draw Squares" button by calling makeButton and add it to the panel
		JButton squareButton = makeButton("Draw Squares");
		drawingPanel.add(squareButton);
		
		add(panel, BorderLayout.NORTH);
	}
	
	/**
	 * Make a JButton.  This method has an inner class that will create
	 * a listener for the button.  The button will pass data using the
	 * drawingPanel instance field to MyPanel so that a number of circles
	 * or squares will be drawn.  The name of the button will determine
	 * if numberFld contains a number of squares or a number of circles.
	 * @param btnName is the name of the button
	 * @return the JButton created
	 */
	public JButton makeButton(final String btnName)
	{
		JButton button = new JButton(btnName);
		
		class ButtonListener implements ActionListener
		{
			public void actionPerformed(ActionEvent event)
			{
				// get the number in the JTextField (numberFld instance field)
				int x = (int) Double.parseDouble(numberFld.getText());
				// convert this number to an int
				
				// this number is either the number of squares or circles depending on btnName
				// call the setData method of the MyPanel class by using the drawingPanel instance field
				if(btnName == "Draw Circle")
				{
					drawingPanel.setData(x, 0);
				}
				
				if(btnName == "Draw Squares")
				{
					drawingPanel.setData(0, x);
				}
				
			}
		}
		
		// set the action listener and return the button
		ActionListener listener = new ButtonListener();
		button.addActionListener(listener);
		return button;
		
	}
	
	private MyPanel drawingPanel;
	private JTextField numberFld;
}
