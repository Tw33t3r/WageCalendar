import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;

public class LabelButton extends JButton {

	/**
	 * Because javac complains
	 */
	private static final long serialVersionUID = 3;
	private JLabel time;
	public LabelButton(String name) {
		super(name);
		this.setLayout(null);
		time = new JLabel("0.0");
		time.setLocation(5,5);
		time.setSize(30,10);
		time.setForeground(Color.YELLOW);
		this.add(time);
	}
	
	public void setPanelText(String text) {
		time.setText(text);
	}
	
	public String getPanelText() {
		return time.getText();
	}
}
