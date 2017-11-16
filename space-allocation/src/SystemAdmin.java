import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class SystemAdmin extends JFrame
{
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	JButton button5;
	JButton button6;
	JButton button7;
	JTextField textField1;
	JTextField textField2;
	JLabel label1;
	SwingCalendar calendar;
	


	
	
	public SystemAdmin()
	{
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		//Toolkit tk = Toolkit.getDefaultToolkit();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("System Admin");
		JPanel thePanel = new JPanel();
		//JPanel thePanel2 = new JPanel();
		JLabel label1 = new JLabel("Room Number:");
		JLabel label2 = new JLabel("Time:");
		button1 = new JButton("Create Schedule");
		button1.setToolTipText("Creates a new Schedule");
		button2 = new JButton("Display Schedule");
		button3 = new JButton("Add Room");
		button4 = new JButton("Remove Room");
		button5 = new JButton("Get Requests");
		button5.setToolTipText("View Time Requests");
		button6 = new JButton("Allocate Time Slot");
		button7 = new JButton("Deallocate Time Slot");
		JTextField textField1 = new JTextField();
		JTextField textField2 = new JTextField();
		textField1.setColumns(10);
		textField2.setColumns(10);


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

		this.add(thePanel);
		this.setVisible(true);
		
		
		


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
				String st = "Schedule Created";
				JOptionPane.showMessageDialog(null, st);	
				calendar = new SwingCalendar();
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
				
				//get requests
				
				File file = new File("Requests.txt");
				BufferedReader reader = null;try {
				    reader = new BufferedReader(new FileReader(file));
				    String text = null;

				    while ((text = reader.readLine()) != null) {
				       
				        System.out.println(text+"\n");
				    }
				} catch (FileNotFoundException k) {
				    k.printStackTrace();
				} catch (IOException k) {
				    k.printStackTrace();
				} finally {
				    try {
				        if (reader != null) {
				            reader.close();
				        }
				    } catch (IOException k) {
				    }
				}

				
		
			}
//***Allocate Time Slot*******************************************************************************				
			if(e.getSource() == button6)
			{	
				new Request();	
				
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