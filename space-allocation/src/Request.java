import javax.swing.*;

import ioSystem.IOSpaceRequest;
import scheduling.Location;
import scheduling.ScheduleManager;
import scheduling.Semesters;
import scheduling.TimeSlot;
import scheduling.WeekDays;
import spaceRequests.RequestManager;
import spaceRequests.SpaceRequest;

import java.awt.event.*;
import java.util.List;


public class Request extends JFrame
{
	JButton button1;
	JTextField textField1 = new JTextField();
	JTextField textField2 = new JTextField();
	
	JLabel label1;
	JLabel label3;
	JPanel requestPanel;
	JComboBox <Semesters>semesters;
	JComboBox <Location>locations;
	List<WeekDays> day;
	JComboBox <TimeSlot>timeS;
	JComboBox <TimeSlot>timeF;

	
	public Request()
	{
		this.setSize(400,150);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("System ");
		
		//Location[] loc = Location.class.getEnumConstants();
		//Semesters[] s = Semesters.class.getEnumConstants();
		List<Semesters> s = ScheduleManager.getSemesters();
		List<String> loc = ScheduleManager.getLocationsInSchedule(ScheduleManager.getSchedule().get(0));
		List<WeekDays> day = ScheduleManager.getDaysFromLocation(Semesters.Winter, Location.Dance);
		List<String> time1 = ScheduleManager.getDayTimeStart(Semesters.Winter, WeekDays.Tuesday);
		List<String> time2 = ScheduleManager.getDayTimeEnd(Semesters.Winter, WeekDays.Tuesday);
		
		
		semesters = new JComboBox<Semesters>();
		
		
		locations = new JComboBox(loc.toArray());
		JComboBox days = new JComboBox(day.toArray());
		JComboBox timeS = new JComboBox(time1.toArray());
		JComboBox timeF = new JComboBox(time2.toArray());
		JPanel thePanel = new JPanel();
		JLabel label1 = new JLabel("Semester:");
		JLabel label2 = new JLabel("Location:");
		JLabel label3 = new JLabel("Day:");
		JLabel label4 = new JLabel("Time:");
		JLabel label5 = new JLabel("to");
		button1 = new JButton("Submit");
		
		semesters.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        System.out.println("test");
		      //  List<WeekDays> newday = ScheduleManager.getDaysFromLocation(semesters.getSelectedItem(), Location.Dance);
		        locations.repaint();
		    }
		});
		
		days.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        System.out.println("test");
		        locations.repaint();
		    }
		});

		JTextField textField3 = new JTextField();
		textField1.setColumns(10);
		textField2.setColumns(10);
		textField3.setColumns(10);


		ListenForButton lForButton = new ListenForButton();

		button1.addActionListener(lForButton);
			
		thePanel.add(label1);
		thePanel.add(semesters);
		thePanel.add(label2);
		thePanel.add(locations);
		thePanel.add(label3);
		thePanel.add(days);
		thePanel.add(label4);
		thePanel.add(timeS);
		thePanel.add(label5);
		thePanel.add(timeF);
		thePanel.add(button1);
		//thePanel.add(locations);
	//	thePanel.add(semesters);
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
				
				System.out.println(textField2.getText());

				//IOSpaceRequest request = new IOSpaceRequest();
				//request.save(textField1.getText());
				//int t1 = timeS.
				
				//TimeSlot si = new TimeSlot(9,12, WeekDays.Monday , Location.Dance);
				//RequestManager.createRequest(s1,"Tod", s1.getStartTime(), s1.getEndTime() - 1);
				
				
				String st = "Process Complete";
				JOptionPane.showMessageDialog(null, st);	
		
			}
			
		}
		
	}
/*
	public void actionPerformed(ActionEvent e)
    {
        String item = (String)mainComboBox.getSelectedItem();
        Object o = subItems.get( item );

        if (o == null)
        {
            subComboBox.setModel( new DefaultComboBoxModel() );
        }
        else
        {
            subComboBox.setModel( new DefaultComboBoxModel( (String[])o ) );
        }
    }
	
	*/
	
}