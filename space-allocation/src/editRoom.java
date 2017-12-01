/*
 *	Defines the edit room window
 *	@author Dylan Kennedy
*/
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;



import java.text.*;
import java.awt.event.*;
import java.awt.*;

public class editRoom extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton button1;
	JTextField textField1;
	JLabel label1;
	JPanel thePanel;
	
	public editRoom()
	{
		this.setSize(400,150);
		this.setLocationRelativeTo(null);		
		this.setTitle("System ");
		JPanel thePanel = new JPanel();
		JLabel label1 = new JLabel("Location:");
		JTextField textField1 = new JTextField();		
		textField1.setColumns(10);
		ListenForButton lForButton = new ListenForButton();
		button1 = new JButton("Confirm");
		button1.addActionListener(lForButton);
		
		thePanel.add(label1);
		thePanel.add(textField1);
		thePanel.add(button1);
		
		this.add(thePanel);
		this.setVisible(true);
		


	}


	private class ListenForButton implements ActionListener
	{
		
		// This method is called when an event occurs
		
		public void actionPerformed(ActionEvent e)
		{
			
			// Check if the source of the event was the button
			
			if(e.getSource() == button1)
			{	
				String st = "Process Complete";
				JOptionPane.showMessageDialog(null, st);		
			}
			
		}
		
	}

}