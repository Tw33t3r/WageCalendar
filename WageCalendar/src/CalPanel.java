import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CalPanel extends JPanel implements ActionListener{

	/**
	 * TODO
	 * Options Menu for wage, potentially holiday/weekend wage
	 * 
	 * Options for income tax?
	 * 	Requires re-writing the storage of hours worked and wage earned
	 * 
	 * Option for reduction of pay based off travel expenses
	 * 	Requires similar re-writing to income tax.
	 * 		Income tax first, then travel reduction
	 * 
	 * Eventually Program different Months swapping between
	 * 
	 * Save functionality
	 * 
	 * Polish dialogue
	 * 
	 * ???Label on button for wage earned per day???
	 * ???Rewrite hoursWorked and totalHoursLabel to better names???
	 * ???TimeTraveled???
	 */
	
	
	/**
	 * Because javac complains
	 * Default Values
	 */
	private static final long serialVersionUID = 2;
	private double totalHoursWorked = 0.0;
	private double hourlyWage = 10.0;
	private double earned = 0.0;
	private double travelCost = 13.0;
	private List<LabelButton> hoursWorked = new ArrayList<LabelButton>();
	private JLabel totalHoursLabel;
	private JLabel totalEarned;
	private JLabel travelCostLabel;


	public CalPanel() {
		//Initiate Values
		super();
		totalHoursLabel = new JLabel();
		totalEarned = new JLabel();
		travelCostLabel = new JLabel();
		this.setLayout(null);
		//Get Month
		Calendar cal = Calendar.getInstance();
		int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		//Create Butons for Calendar Days
		for(int i=1; i <= days; i++) {
			String iString = i + "";
			LabelButton but = new LabelButton(iString);
			int xOffset = (i % 7);
			int yOffset = (i / 7);
			but.setLocation((xOffset*75) + 125, (yOffset * 75) + 100);
			but.setSize(75, 75);
			but.setBackground(Color.BLUE);
			but.setForeground(Color.WHITE);
			but.addActionListener(this);
			this.add(but);
			but.setPanelText("0.0");
			hoursWorked.add(but);
		}
		//Create JLabels
		totalHoursLabel.setText("Total Hours Worked: " + totalHoursWorked);
		totalHoursLabel.setLocation(550,450);
		totalHoursLabel.setSize(200,10);
		this.add(totalHoursLabel);
		totalEarned.setText("Total Earned: " + earned);
		totalEarned.setLocation(550, 465);
		totalEarned.setSize(200,10);
		this.add(totalEarned);
		travelCostLabel.setLocation(550, 30);
		travelCostLabel.setSize(200,10);
		travelCostLabel.setText("Travel Cost: " + travelCost);
		this.add(travelCostLabel);

	}
	
	private void clickDate(int date) {
	    String hoursPerDay = JOptionPane.showInputDialog("How many hours did you work on the: " + date + "?");
	    Double doubleHours = Double.parseDouble(hoursPerDay);
    	Double doubleStoredHours = Double.parseDouble(hoursWorked.get(date-1).getPanelText());
	    if (doubleHours == 0) {
	    	if(doubleStoredHours == 0) {
	    		//Reset button date
	    		hoursWorked.get(date-1).setPanelText(hoursPerDay);
	    		//Remove Hours from history
	    		Double overwriteHours = doubleStoredHours;
	    		totalHoursWorked -= overwriteHours;
	    	}
	    	else {
	    		//Reset button date
	    		hoursWorked.get(date-1).setPanelText(hoursPerDay);
	    		//Remove Hours from history
	    		Double overwriteHours = doubleStoredHours;
	    		totalHoursWorked -= overwriteHours;
	    		//Remove wage from history including travelCost
	    		earned -= ((overwriteHours * hourlyWage) + travelCost);
	    	}
	    }
	    else {
		    if(doubleStoredHours!=0){
		    	//Rewrite data
		    	//Hours
		    	Double overwriteHours = doubleStoredHours;
		    	totalHoursWorked -= overwriteHours;
		    	//Wage
			    earned -= ((overwriteHours * hourlyWage) + travelCost);
		    }
		    //Add hours to total
	    	hoursWorked.get(date-1).setPanelText(hoursPerDay);
	    	totalHoursWorked = totalHoursWorked + doubleHours;
	    	//Handle wage earned
	    	earned += ((doubleHours * hourlyWage) + travelCost);
	    }
    	//Update JLabels
    	totalHoursLabel.setText("TotalHoursWorked: " + totalHoursWorked);
    	totalEarned.setText("Total Earned: " + earned);
	}
	
	public void addMenu(int x, int y, int width, int height) {

		int buttonHeightSpacing = height / 10;
		int buttonWidthSpacing = width / 12;
		int buttonWidth = width / 8 - buttonWidthSpacing;
		int buttonHeight = buttonHeightSpacing * 4;
		
		/*
		// create the "File" button
		fileButton = new Button("File");
		fileButton.addActionListener(this);

		fileButton.setBounds(x + buttonWidthSpacing, y + buttonHeightSpacing, buttonHeight, buttonWidth);
		this.add(fileButton);
		loadMenuItem.addActionListener(this);
		filePopupMenu.add(loadMenuItem);
		saveMenuItem.addActionListener(this);
		filePopupMenu.add(saveMenuItem);
		fileButton.setVisible(true);
		*/
		
		// create the "Quit" button
		JButton closeButton = new JButton("Quit");
		closeButton.addActionListener(this);
		closeButton.setBounds(x + (2 * buttonWidth) + (2 * buttonWidthSpacing) + 125, y + buttonHeightSpacing, buttonHeight, buttonWidth);
		this.add(closeButton);
		closeButton.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		Object source = event.getActionCommand();
		// TODO For File open eventually
		if(source == "Quit") {
			System.exit(0);
		}
		else {
			int buttonID = Integer.parseInt(event.getActionCommand());
			clickDate(buttonID);
		}
	}
}
