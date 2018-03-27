/**
 * COMI2510 - Advanced Java Programming
 * October 3rd, 2016
 * 
 * Creates a button listener for the
 * chart program..
 * @author Dylan Grandjean
 *
 */
import java.awt.event.*;

public class ChartButtonListener implements ActionListener
{
	//Fields:
	private ChartDataPanel dataPanel;
	private ChartSettingsPanel settingsPanel;
	
	//Constructors:
	/**
	 * ChartButtonListener constructor.
	 * @param data -- ChartDataPanel buttons.
	 * @param settings -- ChartSettingsPanel buttons.
	 */
	public ChartButtonListener(ChartDataPanel data, ChartSettingsPanel settings)
	{
		this.dataPanel = data;
		this.settingsPanel = settings;
	}
	
	/**
	 * Gets input from button and activates a method accordingly.
	 */
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand() == ChartTypePanel.COLUMN)
		{
			dataPanel.showColumnFields();
			settingsPanel.showColumnFields();
		}
		else if(e.getActionCommand() == ChartTypePanel.PIE)
		{
			dataPanel.showPieFields();
			settingsPanel.showPieFields();
		}
		else if(e.getActionCommand() == ChartTypePanel.LINE)
		{
			dataPanel.showLineFields();
			settingsPanel.showLineFields();
		}
	}
}
