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
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class Creator extends JFrame implements ItemListener
{
	JButton button1;

	
	JLabel label1;
	JLabel label3;
	JPanel requestPanel;
	JComboBox <Semesters>semesters;
	JComboBox <Location>locations;
	JComboBox <WeekDays>days;
	JTextField timeS;
	JTextField timeF;
	JCheckBox mon;
	JCheckBox tue;
	JCheckBox wed;
	JCheckBox thurs;
	JCheckBox fri;
	JCheckBox sat;
	JCheckBox sun;
	
	public Creator()
	{
		this.setSize(450,150);
		this.setLocationRelativeTo(null);
		
		this.setTitle("Creator");
		
		Location[] loc = Location.class.getEnumConstants();
		Semesters[] s = Semesters.class.getEnumConstants();

		semesters = new JComboBox<Semesters>(s);
		locations = new JComboBox<Location>(loc);
		
		timeS = new JTextField("",3);
		timeF = new JTextField("",3);
		JPanel thePanel = new JPanel();
		JLabel label1 = new JLabel("Semester:");
		JLabel label2 = new JLabel("Location:");
		JLabel label3 = new JLabel("Day:");
		JLabel label4 = new JLabel("Time:");
		JLabel label5 = new JLabel("to");
		button1 = new JButton("Submit");
		

        //Create the check boxes.
        mon = new JCheckBox("Monday");
        mon.setMnemonic(KeyEvent.VK_C);
        mon.setSelected(false);
        
        tue = new JCheckBox("Tuesday");
        tue.setMnemonic(KeyEvent.VK_C);
        tue.setSelected(false);
 
        wed = new JCheckBox("Wednesday");
        wed.setMnemonic(KeyEvent.VK_C);
        wed.setSelected(false);
 
        thurs = new JCheckBox("Thursday");
        thurs.setMnemonic(KeyEvent.VK_C);
        thurs.setSelected(false);
        
        fri = new JCheckBox("Friday");
        fri.setMnemonic(KeyEvent.VK_C);
        fri.setSelected(false);
        
        sat = new JCheckBox("Saturday");
        sat.setMnemonic(KeyEvent.VK_C);
        sat.setSelected(false);
        
        sun = new JCheckBox("Sunday");
        sun.setMnemonic(KeyEvent.VK_C);
        sun.setSelected(false);
        
        //Register a listener for the check boxes.
        mon.addItemListener(this);
        tue.addItemListener(this);
        wed.addItemListener(this);
        thurs.addItemListener(this);
        fri.addItemListener(this);
        sat.addItemListener(this);
        sun.addItemListener(this);
		
		ListenForButton lForButton = new ListenForButton();

		button1.addActionListener(lForButton);
			
		thePanel.add(label1);
		thePanel.add(semesters);
		thePanel.add(label2);
		thePanel.add(locations);
		thePanel.add(label3);
		thePanel.add(label4);
		thePanel.add(timeS);
		thePanel.add(label5);
		thePanel.add(timeF);
		thePanel.add(mon);
		thePanel.add(tue);
		thePanel.add(wed);
		thePanel.add(thurs);
		thePanel.add(fri);
		thePanel.add(sat);
		thePanel.add(sun);
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
				int t1 = Integer.parseInt((String) timeS.getText());
				int t2 = Integer.parseInt((String) timeF.getText());
				
				Location l = (Location) locations.getSelectedItem();
				
				List<WeekDays> selDays = getSelectedDays();
				
				Semesters selSemester = getCurrentlySelectedSemester(); 
				for(WeekDays d : selDays){
					
					TimeSlot si = new TimeSlot(t1,t2, d, l);
					Vector<TimeSlot> newSlots = new Vector<TimeSlot>();
					newSlots.add(si);
					ScheduleManager.createSchedule(newSlots, selSemester);
				}
				
				
				String st = "Process Complete";
				JOptionPane.showMessageDialog(null, st);		
			}
		}
	}
	
	private List<WeekDays> getSelectedDays(){
		List<WeekDays> days = new ArrayList<WeekDays>();
		if(mon.isSelected()){
			days.add(WeekDays.valueOf(mon.getText()));
		}
		if(tue.isSelected()){
			days.add(WeekDays.valueOf(tue.getText()));
		}
		if(wed.isSelected()){
			days.add(WeekDays.valueOf(wed.getText()));
		}
		if(thurs.isSelected()){
			days.add(WeekDays.valueOf(thurs.getText()));
		}
		if(fri.isSelected()){
			days.add(WeekDays.valueOf(fri.getText()));
		}
		if(sat.isSelected()){
			days.add(WeekDays.valueOf(sat.getText()));
		}
		if(sun.isSelected()){
			days.add(WeekDays.valueOf(sun.getText()));
		}
		return days;
	}
	
	private Semesters getCurrentlySelectedSemester(){
		return (Semesters)semesters.getSelectedItem();
	}


	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}