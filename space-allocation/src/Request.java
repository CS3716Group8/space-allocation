import javax.swing.*;

import ioSystem.IOSpaceRequest;
import scheduling.Location;
import scheduling.Semesters;
import spaceRequests.SpaceRequest;

import java.awt.event.*;
import java.util.List;


public class Request extends JFrame
{
	JButton button1;
	JTextField textField1 = new JTextField();
	JTextField textField2 = new JTextField();
	String room;
	String time;
	JLabel label1;
	JLabel label3;
	JPanel requestPanel;

	
	public Request()
	{
		this.setSize(400,150);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("System ");
		
		Location[] loc = Location.class.getEnumConstants();
		Semesters[] s = Semesters.class.getEnumConstants();
		JComboBox locations = new JComboBox(loc);
		JComboBox semesters = new JComboBox(s);
		JPanel thePanel = new JPanel();
		JLabel label1 = new JLabel("Semesters:");
		JLabel label2 = new JLabel("Location:");
		JLabel label3 = new JLabel("Day:");
		button1 = new JButton("Confirm");

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
		thePanel.add(locations);
		thePanel.add(semesters);
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
				room = textField1.getText();
				time = textField2.getText();
				System.out.println(textField2.getText());
				System.out.println(room);
				System.out.println(time);
				//IOSpaceRequest request = new IOSpaceRequest();
				//request.save(textField1.getText());
				
				String st = "Process Complete";
				JOptionPane.showMessageDialog(null, st);		
			}
			
		}
		
	}

}