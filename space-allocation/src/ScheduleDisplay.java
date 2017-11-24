import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ScheduleDisplay extends JPanel
{
	
	JTextArea textArea;
	
	ScheduleDisplay()
	{
		JTextArea textArea = new JTextArea(5, 20);
		JScrollPane scrollPane = new JScrollPane(textArea); 
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(true);
		
	}
	
	
	
	
}
