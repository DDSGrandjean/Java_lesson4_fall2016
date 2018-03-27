/**
 * COMI2510 - Advanced Java Programming
 * October 3rd, 2016
 * 
 * Creates a panel to hold buttons.
 * @author Dylan Grandjean
 *
 */
import javax.swing.*;

public class ButtonPanel extends JPanel
{
	//Fields:
	private JButton okayButton;
	private JButton cancelButton;
	
	/**
	 * Sets listeners to buttons
	 * @param okayListener -- Listener of the okay button.
	 * @param cancelListener -- Listener of the cancel button.
	 */
	public void setListener(OkayListener okayListener, CancelListener cancelListener)
	{
		okayButton.addActionListener(okayListener);
		cancelButton.addActionListener(cancelListener);
	}
	
	/**
	 * ButtonPanel no-arg constructor
	 */
	public ButtonPanel()
	{
		//Create buttons
		okayButton = new JButton("Okay");
		cancelButton = new JButton("Cancel");
		
		add(cancelButton);
		add(okayButton);
	}
}
