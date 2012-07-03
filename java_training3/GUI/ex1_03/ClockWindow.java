package ex1_03;

import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class ClockWindow extends Window{
	private CurrentTimePanel timeFrame = null;

	public ClockWindow(Window owner, GraphicsConfiguration gc) {
		super(owner, gc);
		timeFrame = new CurrentTimePanel(this);
		setSize(500, 500);
		this.add(timeFrame);
		this.setVisible(true);
	}
	
	public void setWindowSize(int size) {
		this.setSize(size * 8, size * 2);
	}

	public static void main(String args[]) {
		ClockWindow ob = new ClockWindow(new Frame("frame"), null);
	}
}
