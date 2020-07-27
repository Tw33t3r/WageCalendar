import javax.swing.*;

public class CalWindow extends JFrame {
	/**
	 * because it is a serializable object, need this or javac complains a lot
	 */
	public static final long serialVersionUID = 1;

	public CalWindow(String name) {
		super(name);
		CalPanel panels = new CalPanel();
		panels.addMenu(150, 0, 600, 200);
		getContentPane().add(panels);
		/**
		 * TODO
		 * Eventually create a reader class for reading calendar data
		 */
		//reader = frames.reader;
		setVisible(true);

	}

	// Sets up the Calendar window
	public void setUp(){
		//if(CalendarFrame.fileExists(path)==true) {
		//try {
		//	frames.newCalendar(path);
		//} catch (Exception a) {
		//	JOptionPane.showMessageDialog(this, "ERROR: No Default File. Please use the load menu to load a file.");
		//	a.printStackTrace();
		//}
		//}else {
		//	JOptionPane.showMessageDialog(this, "ERROR: No Default File. Please use the load menu to load a file.");
		//}
	}
};