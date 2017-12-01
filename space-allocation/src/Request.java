import javax.swing.*;

import ioSystem.IOSpaceRequest;
import scheduling.Location;
import scheduling.Schedule;
import scheduling.ScheduleManager;
import scheduling.Semesters;
import scheduling.TimeSlot;
import scheduling.WeekDays;
import spaceRequests.RequestManager;
import spaceRequests.SpaceRequest;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class Request extends JFrame
{
	JButton button1;
	JTextField textField1 = new JTextField();
	JTextField textField2 = new JTextField();
	
	JComboBox <Semesters>semesters;
	JComboBox <Location>locations;

	JComboBox timeS = new JComboBox<TimeSlot>();
	JComboBox timeF = new JComboBox<TimeSlot>();
	JComboBox<WeekDays> days = new JComboBox();
	List<WeekDays> day;

	public Request()
	{
		this.setSize(400,150);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("System ");
		createCB();
		populateSemesterCB();
	

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
private void populateSemesterCB() {
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
	
	removePreviousCBLocations();
	
	Semesters sem = getSelectedSemester();
	List<Schedule> schs = ScheduleManager.getSchedule(sem);
	
	List<Location> allLocs = new ArrayList<Location>();
	List<String> locStrings = new ArrayList<String>();
	for (Schedule sch : schs){
		locStrings = ScheduleManager.getLocationsInSchedule(sch);
		
		for(String s : locStrings){
			
			Location currLoc = Location.valueOf(s);
			if(!allLocs.contains(currLoc)){
				allLocs.add(Location.valueOf(s));
			}
		}
	}
	
	for(Location loc : allLocs){
		locations.addItem(loc);
	}
	
	populateDayCB();
}


//****************************************************************************
//****************************************************************************
private void populateDayCB() {
	
	removePreviousCBDays();
	
	Location x = (Location) locations.getSelectedItem();
	Semesters y = (Semesters) semesters.getSelectedItem();
		
	List<WeekDays> day = ScheduleManager.getDaysFromLocation(y, x);
	System.out.println(day.toString());
	if(!day.isEmpty()){

		for(WeekDays d : day){	
			days.addItem(d);
		}
	}
	
	populateTimeCB();
}

//****************************************************************************
private void populateTimeCB() {
	
	removePreviousCBTimes();
	
	WeekDays d = (WeekDays) days.getSelectedItem();
	Semesters s = (Semesters) semesters.getSelectedItem();
	
	List<String> time1 = ScheduleManager.getDayTimeStart(s, d);
	List<String> time2 = ScheduleManager.getDayTimeEnd(s, d);

	int startTime = 0;
	int endTime = 0;
	for(int i = 0; i < time1.size(); i++){
		startTime = Integer.parseInt(time1.get(i));
		endTime = Integer.parseInt(time2.get(i));
	}
	
	int tempSTime = startTime;	
	while(tempSTime < endTime){		
		timeS.addItem(tempSTime);
		tempSTime += 1;
	}
	
	int tempETime = endTime;
	while(tempETime > startTime){
		
		timeF.addItem(tempETime);
		tempETime -= 1;
	}
}

private void removePreviousCBLocations(){
	
	locations.removeAllItems();
}
private void removePreviousCBDays(){
	
	days.removeAllItems();
}

private void removePreviousCBTimes(){
	
	timeS.removeAllItems();
	timeF.removeAllItems();
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
				String t1 = (String) timeS.getSelectedItem();
				Object t2 = timeF.getSelectedItem();
				System.out.println(t1.toString());
				System.out.println(t2.toString());
	
				WeekDays d = (WeekDays) days.getSelectedItem();
				Location l = (Location) locations.getSelectedItem();
				
				String st = "Process Complete";
				JOptionPane.showMessageDialog(null, st);	
			}
		}		
	}
	
	private Semesters getSelectedSemester(){
		return (Semesters)semesters.getSelectedItem();
	}
}