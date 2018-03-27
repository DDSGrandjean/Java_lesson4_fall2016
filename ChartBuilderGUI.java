/**
 * COMI2510 - Advanced Java Programming
 * October 3rd, 2016
 * 
 * Program based on microsoft word, design
 * to evaluate programmer's knowledge of
 * GUI prgramming and its elements.
 * @author Dylan Grandjean
 *
 */
import javax.swing.*;
import java.awt.*;

public class ChartBuilderGUI extends JFrame
{
	public ChartBuilderGUI()
	{
		//Set window's title
		setTitle("Chart Builder");
		
		//Specifies the close button's action
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Add a GridLayout manager to the content pane
		//setLayout(new GridLayout(2, 1));
		setLayout(new BorderLayout());
		
		//Create the four different panels
		ChartSettingsPanel chartSettingsPanel = new ChartSettingsPanel();
		ChartDataPanel chartDataPanel = new ChartDataPanel();
		ChartButtonListener chartButtonListener = new ChartButtonListener(chartDataPanel, chartSettingsPanel);
		ChartTypePanel chartTypePanel = new ChartTypePanel(chartButtonListener);
		ChartTopPanels chartTopPanels = new ChartTopPanels(chartTypePanel, chartDataPanel);

		ButtonPanel buttonPanel = new ButtonPanel();
		OkayListener okayListener = new OkayListener(chartTypePanel, chartDataPanel, chartSettingsPanel);
		CancelListener cancelListener = new CancelListener();
		buttonPanel.setListener(okayListener, cancelListener);
		
		add(chartTopPanels, BorderLayout.NORTH);
		add(chartSettingsPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
		
		pack();
		setVisible(true);
	}
	
	/**
	 * Main method which runs the program.
	 * @param args -- Array of String.
	 */
	public static void main(String[] args)
	{
		new ChartBuilderGUI();
	}
	
	/**
	 * Class destined to create the top half of the
	 * program's panel.
	 * @author Dylan Grandjean
	 *
	 */
	private class ChartTopPanels extends JPanel
	{
		private ChartTopPanels(ChartTypePanel type, ChartDataPanel data)
		{
			setLayout(new GridLayout(1, 2));
			add(type);
			add(data);
		}
	}
}
