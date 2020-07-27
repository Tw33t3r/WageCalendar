import javax.swing.*;
import java.awt.*;

public class Main {
	// Creating a global window size variable for x and y so it is consistent and
	// easy to change
	public static final int xGlobal = 800;
	public static final int yGlobal = 600;

	public static void main(String args[]){
		CalWindow calendar = new CalWindow("WageCalendar");

		calendar.setSize(new Dimension(Main.xGlobal, Main.yGlobal));
		calendar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		calendar.setUp();
	}
};
