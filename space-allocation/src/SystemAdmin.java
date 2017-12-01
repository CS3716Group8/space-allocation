import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import AllocationUI.AllocationWindow;
import ioSystem.IOSpaceRequest;
import spaceRequests.RequestManager;
import spaceRequests.SpaceRequest;





public class SystemAdmin extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame mainFrame;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JButton button7;
	JLabel label1;
	SwingCalendar calendar;
	SwingCalendar sc;
	
	ScheduleDisplay display = new ScheduleDisplay();
	JTextArea textField1 = new JTextArea(25, 20);



	
	
	public SystemAdmin()
	{
		mainFrame = new JFrame();
		mainFrame.setSize(900,500);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setLayout(new BorderLayout());
		//Toolkit tk = Toolkit.getDefaultToolkit();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setTitle("System Admin");
		JPanel thePanel = new JPanel();
		
		
		//display = new ScheduleDisplay();
		SwingCalendar sc = new SwingCalendar();
		JPanel thePanel2 = new JPanel();
		thePanel2.add(sc);
		JPanel thePanel3 = new JPanel();		
		thePanel3.add(textField1);

		button1 = new JButton("Create Schedule");
		button1.setToolTipText("Creates a new Schedule");
		button2 = new JButton("Display Schedule");
		button3 = new JButton("Add Room");
		button4 = new JButton("Remove Room");
		button5 = new JButton("Get Requests");
		button5.setToolTipText("View Time Requests");
		button6 = new JButton("Allocate Time Slot");
		button7 = new JButton("Deallocate Time Slot");
		


		ListenForButton lForButton = new ListenForButton();

		button1.addActionListener(lForButton);
		button2.addActionListener(lForButton);
		button3.addActionListener(lForButton);
		button4.addActionListener(lForButton);
		button5.addActionListener(lForButton);
		button6.addActionListener(lForButton);
		button7.addActionListener(lForButton);
	
		GridLayout experimentLayout = new GridLayout(7,0);
		
		thePanel.setLayout(experimentLayout);
		thePanel.add(button1);
		thePanel.add(button2);
		thePanel.add(button3);
		thePanel.add(button4);
		thePanel.add(button5);
		thePanel.add(button6);
		thePanel.add(button7);

		mainFrame.add("West",thePanel);
		mainFrame.add("Center",thePanel2);
		mainFrame.add("Center",thePanel2);
		mainFrame.add("East",thePanel3);
		mainFrame.setVisible(true);
		
		
		


	}


	private class ListenForButton implements ActionListener
	{
		
		// This method is called when an event occurs
		
		public void actionPerformed(ActionEvent e)
		{
			
			// Check if the source of the event was the button
//***Create Schedule**********************************************************************************				
			if(e.getSource() == button1)
			{	
				//String st = "Schedule Created";
				//JOptionPane.showMessageDialog(null, st);	
				calendar = new SwingCalendar();
				new Creator();
			}
//***Display Schedule*********************************************************************************				
			if(e.getSource() == button2)
			{		
				
				try
				{
					calendar.setVisible(true);
				}
				
				
				catch(final NullPointerException ex)
				{	
					String st = "Please Create A Schedule First";
					JOptionPane.showMessageDialog(null, st);
				}
				
			}
//***Add Room*****************************************************************************************				
			if(e.getSource() == button3)
			{	
				new editRoom();	
				
			}
//***Remove Room**************************************************************************************				
			if(e.getSource() == button4)
			{	
				new editRoom();		
				
			}
//***Get Requests*************************************************************************************			
			if(e.getSource() == button5)
			{	
				
				
				
				Vector<SpaceRequest> requests = RequestManager.getRequests();
				String str = "";
				for(SpaceRequest r:requests)
				{
					str +=  "Name: "+r.getRequester() +"\n"+ 
							"Semester: "+ r.getSemesterOfSlot().name() +"\n"+
							"Location: "+r.getLocationOfSlot().name() +"\n"+
							"Day: "+r.getSlot().getDay()+"\n"+
							"Start Time: "+r.getStartTime()+"\n"+
							"End Time: "+r.getEndTime()+"\n \n";
				}
				textField1.append(str);
				
	
		
			}
//***Allocate Time Slot*******************************************************************************				
			if(e.getSource() == button6)
			{	
				AllocationWindow alo = new AllocationWindow();	
				alo.setVisible(true);
			}
//***Deallocate Time Slot*****************************************************************************		
			if(e.getSource() == button7)
			{	
				new Request();
				
			}
//****************************************************************************************************				
		
		}
		
	}
			
}