/**
 * COMI2510 - Advanced Java Programming
 * October 3rd, 2016
 * 
 * Creates a panel to hold chart type.
 * @author Dylan Grandjean
 *
 */
import javax.swing.*;
import java.awt.*;

public class ChartTypePanel extends JPanel
{
	//Fields:
	public static final String COLUMN = "Column";
	public static final String PIE = "Pie";
	public static final String LINE = "Line";
	
	private JLabel chartTitle;
	private JRadioButton columnButton;
	private JRadioButton pieButton;
	private JRadioButton lineButton;
	private ButtonGroup buttonGroup;
	
	public ChartTypePanel(ChartButtonListener buttonListener)
	{
		//Create a GridLayout manager
		setLayout(new GridLayout(5, 1));
		
		//Create label
		chartTitle = new JLabel("Chart Type");
		
		//Create the buttons
		columnButton = new JRadioButton(COLUMN, true);
		pieButton = new JRadioButton(PIE);
		lineButton = new JRadioButton(LINE);
		
		//Add buttons to group
		buttonGroup = new ButtonGroup();
		buttonGroup.add(columnButton);
		buttonGroup.add(pieButton);
		buttonGroup.add(lineButton);
		
		//Add button listener
		columnButton.addActionListener(buttonListener);
		pieButton.addActionListener(buttonListener);
		lineButton.addActionListener(buttonListener);
		
		//Add titled border
		setBorder(BorderFactory.createTitledBorder(""));
		
		//Add components to panel
		add(chartTitle);
		add(columnButton);
		add(pieButton);
		add(lineButton);
		add(new JLabel(""));
	}
	
	/**
	 * Gets button clicked from the panel
	 * @return Button clicked.
	 */
	public String getCurrentChartType()
	{
		if(columnButton.isSelected())
			return columnButton.getActionCommand();
		else if(pieButton.isSelected())
			return pieButton.getActionCommand();
		else if(lineButton.isSelected())
			return lineButton.getActionCommand();
		else return "Error";
	}
}
