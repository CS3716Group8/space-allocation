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
import java.util.Vector;


public class Request extends JFrame
{
	JButton button1;
	JTextField textField1 = new JTextField();
	JTextField textField2 = new JTextField();
	
	JComboBox <Semesters>semesters;
	JComboBox <Location>locations;

	JComboBox<TimeSlot> timeS;
	JComboBox<TimeSlot> timeF;
	JComboBox<WeekDays> days;
	List<WeekDays> day;


	
	public Request()
	{
		this.setSize(400,150);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("System ");
		createCB();
		populateCB();
	

		JPanel thePanel = new JPanel();
		JLabel label1 = new JLabel("Semester:");
		JLabel label2 = new JLabel("Location:");
		JLabel label3 = new JLabel("Day:");
		JLabel label4 = new JLabel("Time:");
		JLabel label5 = new JLabel("to");
		button1 = new JButton("Submit");
		
		
//Action Listeners for ComboBoxes
		semesters.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        System.out.println("Semester Changed");
		        //updateLocations
		       populateLocationCB();
		       thePanel.revalidate();
		       thePanel.repaint();
		    }
		});
		
		locations.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        System.out.println("Locations Changed");
		        //updateDays
		        
		       
		        populateDayCB();
		        thePanel.revalidate();
		        thePanel.repaint();
		    }
		});
		
		
		
		days.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        System.out.println("Day Changed");
		       // updateTime
		        populateTimeCB();
		        thePanel.revalidate();
		        thePanel.repaint();
		      
		    }
		});
		
//End of Action Listeners



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
		this.add(thePanel);
		this.setVisible(true);
		

	}

//****************************************************************************
private void populateCB() {
	List<Semesters> allSemesters = RequestManager.getAllSemesters();
	
	if(allSemesters != null){		
		for(Semesters sem : allSemesters){
			semesters.addItem(sem);
		}
	}
	
	populateLocationCB();
}


//****************************************************************************
//****************************************************************************
private void populateLocationCB() {
	Location[] loc = Location.class.getEnumConstants();
	locations = new JComboBox<Location>(loc);
	
	populateDayCB();
}


//****************************************************************************
//****************************************************************************
private void populateDayCB() {
	
	Location x = (Location) locations.getSelectedItem();
	Semesters y = (Semesters) semesters.getSelectedItem();
	
	List<WeekDays> day = ScheduleManager.getDaysFromLocation(y, x);
	//temp assignment
	day = ScheduleManager.getDaysFromLocation(Semesters.Winter, Location.Dance);
	
	
	if(!day.isEmpty()){
		for(WeekDays d : day){
		days.addItem(d);
		}
	}
	
	else if(day.isEmpty()){	
	
	day = ScheduleManager.getDaysFromLocation(Semesters.Fall, Location.Dance);
	for(WeekDays d : day){
		days.addItem(d);
		}
	}
	
	

	populateTimeCB();
	
}

//****************************************************************************
private void populateTimeCB() {
	
	//List<String> time1 = ScheduleManager.getDayTimeStart(Semesters.Winter, WeekDays.Tuesday);
	//List<String> time2 = ScheduleManager.getDayTimeEnd(Semesters.Winter, WeekDays.Tuesday);
	
	WeekDays d = (WeekDays) days.getSelectedItem();
	Semesters s = (Semesters) semesters.getSelectedItem();
	
	List<String> time1 = ScheduleManager.getDayTimeStart(s, d);
	List<String> time2 = ScheduleManager.getDayTimeEnd(s, d);

	timeS = new JComboBox(time1.toArray());
	timeF = new JComboBox(time2.toArray());
	

}


//****************************************************************************
//****************************************************************************
	private void createCB() {
		semesters = new JComboBox<Semesters>();
		locations = new JComboBox<Location>();
		days = new JComboBox<WeekDays>();
		timeS = new JComboBox<TimeSlot>();
		timeF = new JComboBox<TimeSlot>();
		this.add(semesters);
		this.add(locations);
		this.add(days);
		this.add(timeS);
		this.add(timeF);
		
	}

//****************************************************************************
	private class ListenForButton implements ActionListener
	{
		
		// This method is called when an event occurs
		
		public void actionPerformed(ActionEvent e)
		{
			
			// Check if the source of the event was the button
			
			if(e.getSource() == button1)
			{	
				

				int t1 = Integer.parseInt((String) timeS.getSelectedItem());
				int t2 = Integer.parseInt((String) timeF.getSelectedItem());
				WeekDays d = (WeekDays) days.getSelectedItem();
				Location l = (Location) locations.getSelectedItem();
				
				
				TimeSlot s1 = new TimeSlot(t1,t2, d, l);
				RequestManager.createRequest(s1,"User", s1.getStartTime(), s1.getEndTime());

				
				String st = "Process Complete";
				JOptionPane.showMessageDialog(null, st);	
		
			}
			
		}
		
	}

	
}