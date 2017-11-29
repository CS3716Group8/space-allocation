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


public class Creator extends JFrame implements ItemListener
{
	JButton button1;

	
	JLabel label1;
	JLabel label3;
	JPanel requestPanel;
	JComboBox <Semesters>semesters;
	JComboBox <Location>locations;
	JComboBox <WeekDays>days;
	JComboBox <TimeSlot>timeS;
	JComboBox <TimeSlot>timeF;
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
		WeekDays [] day = WeekDays.class.getEnumConstants();
		
		List<String> time1 = ScheduleManager.getDayTimeStart(Semesters.Winter, WeekDays.Tuesday);
		List<String> time2 = ScheduleManager.getDayTimeEnd(Semesters.Winter, WeekDays.Tuesday);
		

		semesters = new JComboBox(s);
		
		
		

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
		
		locations = new JComboBox(loc);
		days = new JComboBox(day);
		JTextField timeS = new JTextField("",3);
		JTextField timeF = new JTextField("",3);
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



		ListenForButton lForButton = new ListenForButton();

		button1.addActionListener(lForButton);
			
		thePanel.add(label1);
		thePanel.add(semesters);
		thePanel.add(label2);
		thePanel.add(locations);
		thePanel.add(label3);
		//thePanel.add(days);
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
				
	
				
				String st = "Process Complete";
				JOptionPane.showMessageDialog(null, st);		
			}
			
		}
		
	}


	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}