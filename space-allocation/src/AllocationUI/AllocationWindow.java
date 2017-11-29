package AllocationUI;

import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.JButton;

import spaceRequests.*;
import scheduling.Semesters;
import scheduling.*;
public class AllocationWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel allocationWindow;
	private JComboBox<Semesters> semesterCB;
	private JPanel slotsPanel;
	private List<JPanel> requestSlots = new ArrayList<JPanel>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllocationWindow frame = new AllocationWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AllocationWindow() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 795, 614);
		allocationWindow = new JPanel();
		allocationWindow.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(allocationWindow);
		allocationWindow.setLayout(null);
		
		createSemesterCB();
		populateCB();
		addListernerToCB();
		
		JLabel semesterLbl = new JLabel("Semester:");
		semesterLbl.setBounds(26, 31, 88, 24);
		allocationWindow.add(semesterLbl);
		
		slotsPanel = new JPanel();
		slotsPanel.setBounds(12, 84, 771, 518);
		allocationWindow.add(slotsPanel);
		slotsPanel.setLayout(new GridLayout(0, 2, 0, 0));
		
		displaySpaceRequests();
		
//		JPanel slot = new JPanel();
//		slotsPanel.add(slot);
//		slot.setLayout(new GridLayout(4, 1, 0, 0));
//		
//		JLabel nameLbl = new JLabel("Name");
//		slot.add(nameLbl);
//		
//		JLabel locationLbl = new JLabel("Location");
//		slot.add(locationLbl);
//		
//		JLabel timeLbl = new JLabel("Time Requested: 0:00 - 0:00");
//		slot.add(timeLbl);
//		
//		JButton allocBtn = new JButton("Allocate");
//		slot.add(allocBtn);
	}
	
	private void displaySpaceRequests(){
		
		Semesters semester = getSelectedSemester();
		List<SpaceRequest> reqs = RequestManager.getRequestsInSemester(semester);
		
		if(!requestSlots.isEmpty()){
			removeRequestSlots();
		}
		
		for(SpaceRequest req : reqs){
			
			String name = req.getRequester();
			Location loc = req.getLocationOfSlot();
			int sTime = req.getStartTime();
			int eTime = req.getEndTime();
			
			createRequestSlot(name, loc, sTime, eTime);
		}
	}
	
	private void removeRequestSlots(){
		
		List<JPanel> toRemove = new ArrayList<JPanel>();
		for(JPanel slot : requestSlots){
			
			slotsPanel.remove(slot);
			toRemove.add(slot);
		}
		
		for(JPanel slot : toRemove){
			requestSlots.remove(slot);
		}
		
		slotsPanel.revalidate();
		slotsPanel.repaint();
	}
	
	private void createRequestSlot(String name, Location loc, int sTime, int eTime){
		
		JPanel slot = new JPanel();
		slotsPanel.add(slot);
		slot.setLayout(new GridLayout(4, 1, 0, 0));
		
		JLabel nameLbl = new JLabel(name);
		slot.add(nameLbl);
		
		JLabel locationLbl = new JLabel(loc.name());
		slot.add(locationLbl);
		
		JLabel timeLbl = new JLabel("Time Requested: " + sTime + " - " + eTime );
		slot.add(timeLbl);
		
		JButton allocBtn = new JButton("Allocate");
		slot.add(allocBtn);
		addListenerToAllocBtn(allocBtn);
		
		requestSlots.add(slot);
	}
	
	private void addListenerToAllocBtn(JButton btn){
		
		btn.addActionListener(new ActionListener() { 
		  public void actionPerformed(ActionEvent e) { 
			  
			  System.out.println("Allocate Button Pressed");
		  } 
		});
	}
	
	private void createSemesterCB(){
		
		semesterCB = new JComboBox<Semesters>();
		semesterCB.setBounds(149, 31, 172, 24);
		allocationWindow.add(semesterCB);
	}
	
	private void populateCB(){
		List<Semesters> allSemesters = RequestManager.getAllSemesters();
		
		if(allSemesters != null){		
			for(Semesters sem : allSemesters){
				semesterCB.addItem(sem);
			}
		}
	}
	
	private void addListernerToCB(){
		semesterCB.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        
		    	System.out.println("Semester Changed");
		    	displaySpaceRequests();
		    }
		});
	}
	
	private Semesters getSelectedSemester(){
		Semesters selSemester = null;
		selSemester = (Semesters)semesterCB.getSelectedItem();	
		return selSemester;
	}
}























