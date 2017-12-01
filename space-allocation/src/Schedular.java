/*
 *	Starts the Allocation System Program
 *	@author Dylan Kennedy
*/
import javax.swing.*;

public class Schedular extends JFrame
{
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException
	{
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"); 
		Login login = new Login();
		login.launchFrame();
	}
}