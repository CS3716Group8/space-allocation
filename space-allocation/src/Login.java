

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;
import java.util.*;
class Login extends JFrame implements KeyListener
{
	
	

	// Store name
	public static String username;
	public static String password;

	// GUI components
	private JFrame loginFrame;
	private JLabel userLabel;
	private JTextField userText;
	private JLabel passLabel;
	private JTextField passText;
	private int count = 0;
	
	public int getCount()
	{
		count = count +1;
		return count;
	}

	/**
	 * This constructor initialize GUI components
	 */
	public Login() 
	{
		loginFrame = new JFrame("Login");
		userLabel = new JLabel("Username :");
		userText = new JTextField("", 10);
		passLabel = new JLabel("Password :");
		passText = new JTextField("", 10);
		userText.setFont(new Font("",Font.BOLD,12));
		passText.setFont(new Font("",Font.BOLD,12));
	}

	/**
	 * This method consist of frame launch events 
	 */
	public void launchFrame() 
	{	
		loginFrame.setSize(200,350);

		loginFrame.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
		loginFrame.getContentPane().add(userLabel);
		loginFrame.getContentPane().add(userText);
		loginFrame.getContentPane().add(passLabel);
		loginFrame.getContentPane().add(passText);
		loginFrame.pack();

		// Centering the screen on the desktop
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = loginFrame.getSize();
		loginFrame.setLocation(((screenSize.width - frameSize.width) / 2),
							((screenSize.height - frameSize.height) / 2));		

		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setVisible(true);

		userText.selectAll();
		passText.selectAll();
		userText.addKeyListener(this);
		passText.addKeyListener(this);
	}

	// Unused interface methods
	public void keyTyped(KeyEvent e) { }
	public void keyReleased(KeyEvent e) { }

	public void keyPressed(KeyEvent e) { 

		// Key Enter is pressed
		
		if (e.getKeyCode() == 10) 
		{

			username = userText.getText();
			password = passText.getText();
			
			
		
			if(username.contains("Mun")&& password.contains("Admin"))
			{
			String st = "Access Granted...";
			JOptionPane.showMessageDialog(null, st);

			new SystemAdmin();
			loginFrame.setVisible(false);
			
			}
			
			else if(username.contains("Student")&& password.contains("Student"))
			{
			String st = "Student Access Granted...";
			JOptionPane.showMessageDialog(null, st);

			new Request();
			loginFrame.setVisible(false);
			
			}
			
			 else 
			 {
				System.out.println("Could not validate Username and Password");
				getCount();
				JOptionPane.showMessageDialog(null, "Invalid Password", "LOG IN", JOptionPane.ERROR_MESSAGE);
				launchFrame();
				
				if(count == 3)
				{
				System.exit(0);
				}
				
			}
		}
	
	}
			
		
	
}// End of Login class