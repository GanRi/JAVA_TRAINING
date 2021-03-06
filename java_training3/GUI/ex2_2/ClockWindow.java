package ex2_2;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class ClockWindow extends JFrame {
	private CurrentTimePanel timeFrame = null;
	//private Panel panel = new Panel();
	private ClockMenuBar menubar= null;
	//private FlowLayout layout= new FlowLayout(FlowLayout.CENTER);
	public ClockWindow() {
		super("Clock Window");
		timeFrame = new CurrentTimePanel();
		System.out.println(timeFrame.isVisible());
		menubar = new ClockMenuBar(this, timeFrame);
		setSize(500, 500);
		
		
		this.add(timeFrame);
		this.setJMenuBar(menubar);
		this.setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				dispose();
				System.exit(0);
			}
		});
	}

	public void setWindowSize(int size){
		this.setSize(size*8, size * 2);
	}
	public static void main(String args[]) {
		ClockWindow ob = new ClockWindow();
	}

}
