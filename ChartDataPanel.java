/**
 * COMI2510 - Advanced Java Programming
 * October 3rd, 2016
 * 
 * Creates a panel to hold chart data.
 * @author Dylan Grandjean
 *
 */
import javax.swing.*;
import java.awt.*;

public class ChartDataPanel extends JPanel
{
	//Fields:
	public static final String COLUMN2D = "2D Column";
	public static final String COLUMN3D = "3D Column";
	public static final String CYLINDER = "Cylinder";
	public static final String CONE = "Cone";
	public static final String PYRAMID = "Pyramid";
	public static final String PIE2D = "2D Pie";
	public static final String PIE3D = "3D Pie";
	public static final String LINE2D = "2D Line";
	public static final String LINE3D = "3D Line";
	
	private ColumnPanel columnPanel;
	private PiePanel piePanel;
	private LinePanel linePanel;
	private enum Panels {Column, Pie, Line};
	private Panels panels = Panels.Column;
	
	/**
	 * showColumnPanel
	 * Displays column data panel when
	 * column is selected
	 */
	public void showColumnFields()
	{
		this.removeAll();
		this.add(columnPanel);
		this.setVisible(false);
		this.setVisible(true);
		panels = Panels.Column;
	}
	
	/**
	 * showPiePanel
	 * Displays column data panel when
	 * pie is selected
	 */
	public void showPieFields()
	{
		this.removeAll();
		this.add(piePanel);
		this.setVisible(false);
		this.setVisible(true);
		panels = Panels.Pie;
	}
	
	/**
	 * showLinePanel
	 * Displays column data panel when
	 * pie is selected
	 */
	public void showLineFields()
	{
		this.removeAll();
		this.add(linePanel);
		this.setVisible(false);
		this.setVisible(true);
		panels = Panels.Line;
	}
	
	
	//Constructor:
	public ChartDataPanel()
	{
		columnPanel = new ColumnPanel();
		piePanel = new PiePanel();
		linePanel = new LinePanel();
		
		setBorder(BorderFactory.createTitledBorder(""));	
		showColumnFields();
	}
	
	//Internal classes:
	private class ColumnPanel extends JPanel
	{		
		private JRadioButton column2DButton;
		private JRadioButton column3DButton;
		private JRadioButton cylinderButton;
		private JRadioButton coneButton;
		private JRadioButton pyramidButton;
		private ButtonGroup buttonGroup;
			
		private ColumnPanel()
		{
			//Create a border layout
			//setLayout(new BorderLayout());
			setLayout(new GridLayout(5, 1));
				
			//Create buttons
			column2DButton = new JRadioButton(COLUMN2D, true);
			column3DButton = new JRadioButton(COLUMN3D);
			cylinderButton = new JRadioButton(CYLINDER);
			coneButton = new JRadioButton(CONE);
			pyramidButton = new JRadioButton(PYRAMID);
				
			//Group buttons together
			buttonGroup = new ButtonGroup();
			buttonGroup.add(column2DButton);
			buttonGroup.add(column3DButton);
			buttonGroup.add(cylinderButton);
			buttonGroup.add(coneButton);
			buttonGroup.add(pyramidButton);
				
			//Add elements to panel
			add(column2DButton);
			add(column3DButton);
			add(cylinderButton);
			add(coneButton);
			add(pyramidButton);	
		}
		
		/**
		 * getCurrentChartData returns selected button.
		 * @return Selected button.
		 */
		public String getCurrentChartData()
		{
			if(column2DButton.isSelected())
				return column2DButton.getActionCommand();
			else if(column3DButton.isSelected())
				return column3DButton.getActionCommand();
			else if(cylinderButton.isSelected())
				return cylinderButton.getActionCommand();
			else if(coneButton.isSelected())
				return coneButton.getActionCommand();
			else if(pyramidButton.isSelected())
				return pyramidButton.getActionCommand();
			else return "Error";	
		}
	}
	
	private class PiePanel extends JPanel
	{	
		private JRadioButton pie2DButton;
		private JRadioButton pie3DButton;
		private ButtonGroup buttonGroup;
			
		private PiePanel()
		{
			//setLayout(new BorderLayout());
			setLayout(new GridLayout(5, 1));
				
			//Create buttons
			pie2DButton = new JRadioButton(PIE2D, true);
			pie3DButton = new JRadioButton(PIE3D);
			buttonGroup = new ButtonGroup();
				
			//Group buttons together
			buttonGroup = new ButtonGroup();
			buttonGroup.add(pie2DButton);
			buttonGroup.add(pie3DButton);
				
			//Add elements to panel
			add(pie2DButton);
			add(pie3DButton);
		}
		
		/**
		 * getCurrentChartData returns selected button.
		 * @return Selected button.
		 */
		public String getCurrentChartData()
		{
			if(pie2DButton.isSelected())
				return pie2DButton.getActionCommand();
			else if(pie3DButton.isSelected())
				return pie3DButton.getActionCommand();
			else return "Error";	
		}
	}
	
	private class LinePanel extends JPanel
	{	
		private JRadioButton line2DButton;
		private JRadioButton line3DButton;
		private ButtonGroup buttonGroup;
		
		private LinePanel()
		{
			//setLayout(new BorderLayout());
			setLayout(new GridLayout(5, 1));
				
			//Create buttons
			line2DButton = new JRadioButton(LINE2D, true);
			line3DButton = new JRadioButton(LINE3D);
			buttonGroup = new ButtonGroup();
				
			//Group buttons together
			buttonGroup = new ButtonGroup();
			buttonGroup.add(line2DButton);
			buttonGroup.add(line3DButton);
				
			//Add elements to panel
			add(line2DButton);
			add(line3DButton);
		}
		
		/**
		 * getCurrentChartData returns selected button.
		 * @return Selected button.
		 */
		public String getCurrentChartData()
		{
			if(line2DButton.isSelected())
				return line2DButton.getActionCommand();
			else if(line3DButton.isSelected())
				return line3DButton.getActionCommand();
			else return "Error";	
		}
	}
	
	/**
	 * Returns click button of current panel.
	 * @return Selected button.
	 */
	public String getCurrentChartData()
	{
		if(panels == Panels.Column)
			return columnPanel.getCurrentChartData();
		else if(panels == Panels.Pie)
			return piePanel.getCurrentChartData();
		else if(panels == Panels.Line)
			return linePanel.getCurrentChartData();
		else return "Error";
	}
	
}
