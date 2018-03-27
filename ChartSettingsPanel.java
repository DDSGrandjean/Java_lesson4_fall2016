/**
 * COMI2510 - Advanced Java Programming
 * October 3rd, 2016
 * 
 * Creates a panel to hold chart settings.
 * @author Dylan Grandjean
 *
 */
import javax.swing.*;
import java.awt.*;

public class ChartSettingsPanel extends JPanel
{
	//Fields:
	public static final String NONE = "None";
	public static final String AT_RIGHT = "At right";
	public static final String AT_LEFT = "At left";
	public static final String AT_TOP = "At top";
	public static final String AT_BOTTOM = "At bottom";
	public static final String NONE2 = "None";
	public static final String CENTER = "Center";
	public static final String INSIDE = "Inside end";
	public static final String OUTSIDE = "Outside end";
	
	private ColumnPanel columnPanel;
	private PiePanel piePanel;
	private LinePanel linePanel;
	private String title;
	private String horizontalAxis;
	private String verticalAxis;
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
	public ChartSettingsPanel()
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
		private JLabel titleLabel;
		private JLabel horizLabel;
		private JLabel vertiLabel;
		private JLabel legendLabel;
		
		private JTextField titleField;
		private JTextField horizField;
		private JTextField vertiField;
		
		private JRadioButton noneButton;
		private JRadioButton atRightButton;
		private JRadioButton atLeftButton;
		private JRadioButton atTopButton;
		private JRadioButton atBottomButton;
		private ButtonGroup buttonGroup;
		
		private ColumnPanel()
		{
			//Create a border layout
			//setLayout(new BorderLayout());
			setLayout(new GridLayout(6, 3));
			
			//Create layout components
			titleLabel = new JLabel("Chart title", JLabel.RIGHT);
			horizLabel = new JLabel("Primary horizontal axis title", JLabel.RIGHT);
			vertiLabel = new JLabel("Primary vertical axis title", JLabel.RIGHT);
			legendLabel = new JLabel("Legend", JLabel.RIGHT);
			
			titleField = new JTextField(7);
			horizField = new JTextField(7);
			vertiField = new JTextField(7);
			
			//Create buttons
			noneButton = new JRadioButton(NONE, true);
			atRightButton = new JRadioButton(AT_RIGHT);
			atLeftButton = new JRadioButton(AT_LEFT);
			atTopButton = new JRadioButton(AT_TOP);
			atBottomButton = new JRadioButton(AT_BOTTOM);
			
			//Group buttons together
			buttonGroup = new ButtonGroup();
			buttonGroup.add(noneButton);
			buttonGroup.add(atRightButton);
			buttonGroup.add(atLeftButton);
			buttonGroup.add(atTopButton);
			buttonGroup.add(atBottomButton);
			
			//Add elements to panel
			add(titleLabel);
			add(titleField);
			add(new JLabel(""));
			add(horizLabel);
			add(horizField);
			add(new JLabel(""));
			add(vertiLabel);
			add(vertiField);
			add(new JLabel(""));
			add(legendLabel);
			add(noneButton);
			add(atTopButton);
			add(new JLabel(""));
			add(atRightButton);
			add(atBottomButton);
			add(new JLabel(""));
			add(atLeftButton);	
		}
		
		/**
		 * getCurrentChartData returns selected button.
		 * @return Selected button.
		 */
		public String getCurrentChartData()
		{
			title = titleField.getText();
			horizontalAxis = horizField.getText();
			verticalAxis = vertiField.getText();
			
			if(noneButton.isSelected())
				return noneButton.getActionCommand();
			else if(atTopButton.isSelected())
				return atTopButton.getActionCommand();
			else if(atRightButton.isSelected())
				return atRightButton.getActionCommand();
			else if(atBottomButton.isSelected())
				return atBottomButton.getActionCommand();
			else if(atLeftButton.isSelected())
				return atLeftButton.getActionCommand();
			else return "Error";	
		}
	}
	
	private class PiePanel extends JPanel
	{		
		private JLabel titleLabel;
		private JLabel legendLabel;
		private JLabel dataLabel;
			
		private JTextField titleField;
			
		private JRadioButton noneButton;
		private JRadioButton atRightButton;
		private JRadioButton atLeftButton;
		private JRadioButton atTopButton;
		private JRadioButton atBottomButton;
		private JRadioButton none2Button;
		private JRadioButton centerButton;
		private JRadioButton insideButton;
		private JRadioButton outsideButton;
		private ButtonGroup settingsButtonGroup;
		private ButtonGroup dataButtonGroup;
			
		private PiePanel()
		{
			//Create a border layout
			//setLayout(new BorderLayout());
			setLayout(new GridLayout(6, 3));
		
			//Create layout components
			titleLabel = new JLabel("Chart title", JLabel.RIGHT);
			legendLabel = new JLabel("Legend", JLabel.RIGHT);
			dataLabel = new JLabel("Data labels", JLabel.RIGHT);
				
			titleField = new JTextField(7);
				
			//Create buttons
			noneButton = new JRadioButton(NONE, true);
			atRightButton = new JRadioButton(AT_RIGHT);
			atLeftButton = new JRadioButton(AT_LEFT);
			atTopButton = new JRadioButton(AT_TOP);
			atBottomButton = new JRadioButton(AT_BOTTOM);
			none2Button = new JRadioButton(NONE2, true);
			centerButton = new JRadioButton(CENTER);
			insideButton = new JRadioButton(INSIDE);
			outsideButton = new JRadioButton(OUTSIDE);
				
			//Group buttons together
			settingsButtonGroup = new ButtonGroup();
			settingsButtonGroup.add(noneButton);
			settingsButtonGroup.add(atRightButton);
			settingsButtonGroup.add(atLeftButton);
			settingsButtonGroup.add(atTopButton);
			settingsButtonGroup.add(atBottomButton);
			
			dataButtonGroup = new ButtonGroup();
			dataButtonGroup.add(none2Button);
			dataButtonGroup.add(centerButton);
			dataButtonGroup.add(insideButton);
			dataButtonGroup.add(outsideButton);
				
			//Add elements to panel
			add(titleLabel);
			add(titleField);
			add(new JLabel(""));
			add(legendLabel);
			add(noneButton);
			add(atTopButton);
			add(new JLabel(""));
			add(atRightButton);
			add(atBottomButton);
			add(new JLabel(""));
			add(atLeftButton);
			add(new JLabel(""));
			add(dataLabel);
			add(none2Button);
			add(centerButton);
			add(new JLabel(""));
			add(insideButton);
			add(outsideButton);
		}
		
		/**
		 * getCurrentChartData returns selected button.
		 * @return Selected button.
		 */
		public String getCurrentChartData()
		{
			title = titleField.getText();
			horizontalAxis = "";
			verticalAxis = "";
			
			if(noneButton.isSelected())
				return noneButton.getActionCommand();
			else if(atTopButton.isSelected())
				return atTopButton.getActionCommand();
			else if(atRightButton.isSelected())
				return atRightButton.getActionCommand();
			else if(atBottomButton.isSelected())
				return atBottomButton.getActionCommand();
			else if(atLeftButton.isSelected())
				return atLeftButton.getActionCommand();
			else return "Error";
		}
		
		/**
		 * getAdditionalChartData returns more
		 * information required for a pie chart.
		 * @return Addtional information.
		 */
		public String getAdditionalChartData()
		{
			if(none2Button.isSelected())
				return none2Button.getActionCommand();
			else if(centerButton.isSelected())
				return centerButton.getActionCommand();
			else if(insideButton.isSelected())
				return insideButton.getActionCommand();
			else if(outsideButton.isSelected())
				return outsideButton.getActionCommand();
			else return "Error";
		}
	}
	
	private class LinePanel extends JPanel
	{
		private JLabel titleLabel;
		private JLabel horizLabel;
		private JLabel vertiLabel;
		private JLabel legendLabel;
		
		private JTextField titleField;
		private JTextField horizField;
		private JTextField vertiField;
		
		private JRadioButton noneButton;
		private JRadioButton atRightButton;
		private JRadioButton atLeftButton;
		private JRadioButton atTopButton;
		private JRadioButton atBottomButton;
		private ButtonGroup buttonGroup;
		
		private LinePanel()
		{
			//Create a border layout
			//setLayout(new BorderLayout());
			setLayout(new GridLayout(6, 3));
			
			//Create layout components
			titleLabel = new JLabel("Chart title", JLabel.RIGHT);
			horizLabel = new JLabel("Primary horizontal axis title", JLabel.RIGHT);
			vertiLabel = new JLabel("Primary vertical axis title", JLabel.RIGHT);
			legendLabel = new JLabel("Legend", JLabel.RIGHT);
			
			titleField = new JTextField(7);
			horizField = new JTextField(7);
			vertiField = new JTextField(7);
			
			//Create buttons
			noneButton = new JRadioButton(NONE, true);
			atRightButton = new JRadioButton(AT_RIGHT);
			atLeftButton = new JRadioButton(AT_LEFT);
			atTopButton = new JRadioButton(AT_TOP);
			atBottomButton = new JRadioButton(AT_BOTTOM);
			
			//Group buttons together
			buttonGroup = new ButtonGroup();
			buttonGroup.add(noneButton);
			buttonGroup.add(atRightButton);
			buttonGroup.add(atLeftButton);
			buttonGroup.add(atTopButton);
			buttonGroup.add(atBottomButton);
			
			//Add elements to panel
			add(titleLabel);
			add(titleField);
			add(new JLabel(""));
			add(horizLabel);
			add(horizField);
			add(new JLabel(""));
			add(vertiLabel);
			add(vertiField);
			add(new JLabel(""));
			add(legendLabel);
			add(noneButton);
			add(atTopButton);
			add(new JLabel(""));
			add(atRightButton);
			add(atBottomButton);
			add(new JLabel(""));
			add(atLeftButton);	
		}
		
		/**
		 * getCurrentChartData returns selected button.
		 * @return Selected button.
		 */
		public String getCurrentChartData()
		{
			title = titleField.getText();
			title = titleField.getText();
			horizontalAxis = horizField.getText();
			verticalAxis = vertiField.getText();
			
			if(noneButton.isSelected())
				return noneButton.getActionCommand();
			else if(atTopButton.isSelected())
				return atTopButton.getActionCommand();
			else if(atRightButton.isSelected())
				return atRightButton.getActionCommand();
			else if(atBottomButton.isSelected())
				return atBottomButton.getActionCommand();
			else if(atLeftButton.isSelected())
				return atLeftButton.getActionCommand();
			else return "Error";
		}
	}
	
	public String getCurrentChartData()
	{
		String chartSettings;
		
		if(panels == Panels.Column)
		{
			chartSettings = columnPanel.getCurrentChartData();
			if(title.trim().length() > 0 && horizontalAxis.trim().length() > 0 && verticalAxis.trim().length() > 0)
				return String.format("Chart title: %s\nHorizontal axis: %s\nVertical axis: %s\n\nLegend: %s", 
						title, horizontalAxis, verticalAxis, chartSettings);
			else
				return "Error";
		}
		else if (panels == Panels.Pie)
		{
			chartSettings = piePanel.getCurrentChartData();
			String additionalData = piePanel.getAdditionalChartData();
			piePanel.getCurrentChartData();
			piePanel.getAdditionalChartData();
			if(title.trim().length() > 0)
				return String.format("Chart title: %s\n\nLegend: %s\nData label: %s", title, chartSettings, additionalData);
			else
				return "Error";
		}
		else if(panels == Panels.Line)
		{
			chartSettings = piePanel.getCurrentChartData();
			linePanel.getCurrentChartData();
			if(title.trim().length() > 0 && horizontalAxis.trim().length() > 0 && verticalAxis.trim().length() > 0)
				return String.format("Chart title: %s\nHorizontal axis: %s\nVertical axis: %s\n\nLegend: %s", 
						title, horizontalAxis, verticalAxis, chartSettings);
			else
				return "Error";
		}
		else return "Error";
	}
}
