/**
 * COMI2510 - Advanced Java Programming
 * October 3rd, 2016
 * 
 * Creates an okay button listener.
 * @author Dylan Grandjean
 *
 */
import java.awt.event.*;
import javax.swing.*;

public class OkayListener  implements ActionListener
{
	//Fields:
	private ChartTypePanel typePanel;
	private ChartDataPanel dataPanel;
	private ChartSettingsPanel settingsPanel;
	private String type;
	private String data;
	private String settings;
	private String pieSettings;
	
	/**
	 * OkayListener constructor.
	 * @param type -- Type panel
	 * @param data -- Data panel
	 * @param settings -- Settings panel
	 */
	public OkayListener(ChartTypePanel type, ChartDataPanel data, ChartSettingsPanel settings)
	{
		this.typePanel = type;
		this.dataPanel = data;
		this.settingsPanel = settings;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String chartType = typePanel.getCurrentChartType();
		String chartData = dataPanel.getCurrentChartData();
		//String chartSettings = settingsPanel.getCurrentSettings();
		if(chartType == ChartTypePanel.COLUMN)
		{
			type = "Column";
			if(chartData == ChartDataPanel.COLUMN2D)
				data = "Column 2D";
			else if(chartData == ChartDataPanel.COLUMN3D)
				data = "Column 3D";
			else if(chartData == ChartDataPanel.CYLINDER)
				data = "Cylinder";
			else if(chartData == ChartDataPanel.CONE)
				data = "Cone";
			else if(chartData == ChartDataPanel.PYRAMID)
				data = "Pyramid";
			else data = "Error";
		}
		else if(chartType == ChartTypePanel.PIE)
		{
			type = "Pie";
			if(chartData == ChartDataPanel.PIE2D)
				data = "2D Pie";
			else if(chartData == ChartDataPanel.PIE3D)
				data = "3D Pie";
			else data = "Error";
			
		}
		else if(chartType == ChartTypePanel.LINE)
		{
			type = "Line";
			if(chartData == ChartDataPanel.LINE2D)
				data = "2D Line";
			else if(chartData == ChartDataPanel.LINE3D)
				data = "3D Line";
			else data = "Error";
		}
		
		settings = settingsPanel.getCurrentChartData();
		
		if(settings.equals("Error"))
			JOptionPane.showMessageDialog(null, "One or more of your fields is left blank.", "Error", JOptionPane.ERROR_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, String.format("Type: %s\nFormat: %s\n\n%s", type, data, settings), type + " Chart", JOptionPane.PLAIN_MESSAGE);
	}
	
}
