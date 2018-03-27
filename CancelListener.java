/**
 * COMI2510 - Advanced Java Programming
 * October 3rd, 2016
 * 
 * Creates an cancel button listener.
 * @author Dylan Grandjean
 *
 */
import java.awt.event.*;

public class CancelListener implements ActionListener
{
	/**
	 * Exists program when cancel button is pressed
	 */
	public void actionPerformed(ActionEvent e)
	{
		System.exit((0));
	}
}
