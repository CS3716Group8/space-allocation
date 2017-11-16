import javax.swing.*;
import java.awt.event.*;


public class Request extends JFrame
{
	JButton button1;
	JTextField textField1;
	JTextField textField2;
	JLabel label1;
	JLabel label3;
	JPanel thePanel;

	
	public Request()
	{
		this.setSize(400,150);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("System ");
		JPanel thePanel = new JPanel();
		JLabel label1 = new JLabel("Room Number:");
		JLabel label2 = new JLabel("Time:");
		JLabel label3 = new JLabel("Date (MM/DD/YYYY):");
		button1 = new JButton("Confirm");
		JTextField textField1 = new JTextField();
		JTextField textField2 = new JTextField();
		JTextField textField3 = new JTextField();
		textField1.setColumns(10);
		textField2.setColumns(10);
		textField3.setColumns(10);


		ListenForButton lForButton = new ListenForButton();

		button1.addActionListener(lForButton);
			
		thePanel.add(label1);
		thePanel.add(textField1);
		thePanel.add(label2);
		thePanel.add(textField2);
		thePanel.add(label3);
		thePanel.add(textField3);
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