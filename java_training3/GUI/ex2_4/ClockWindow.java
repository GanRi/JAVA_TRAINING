package ex2_4;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javax.swing.JFrame;

public class ClockWindow extends JFrame {
	private CurrentTimePanel timeFrame = null;
	private ClockMenuBar menubar = null;
	private ClockSetting clockSetting = new ClockSetting();
	public ClockWindow() {
		super("Clock Window");
		try {
			load();
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
		timeFrame = new CurrentTimePanel(clockSetting);
		System.out.println(timeFrame.isVisible());
		menubar = new ClockMenuBar(this, timeFrame, clockSetting);
		setSize(500, 500);
		System.out.println(clockSetting.getLocation().getX());
		System.out.println(clockSetting.getLocation().getY());
		setLocation(clockSetting.getLocation());
		this.add(timeFrame);
		this.setJMenuBar(menubar);
		this.setVisible(true);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				save();
				dispose();
				System.exit(0);
			}
		});
	}

	public void setWindowSize(int size) {
		this.setSize(size * 8, size * 2);
	}

	public static void main(String args[]) {
		ClockWindow ob = new ClockWindow();
	}

	private void load() throws BackingStoreException {
		Preferences p = Preferences.userRoot();
		if (p.nodeExists("LiYanClock")) {
			System.out.println("have");
			Preferences clock = p.node("LiYanClock");
			clockSetting.setFontSize(clock.getInt("LiYanClockFontSize", clockSetting.getFontSize()));
			//clockSetting.setBackgroudColor(clock.get("LiYanClockBackgroudColor", clockSetting.getBackgroudColor()));
			Color backgroudColor = new Color(clock.getInt("LiYanClockBackgroudColorR", 255),clock.getInt("LiYanClockBackgroudColorG",0),clock.getInt("LiYanClockBackgroudColorB",0));
			clockSetting.setBackgroudColor(backgroudColor);
			clockSetting.setFont(clock.get("LiYanClockFont", clockSetting.getFont()));
			//clockSetting.setFontColor(clock.get("LiYanClockFontColor",clockSetting.getFontColor()));
			Color fontColor = new Color(clock.getInt("LiYanClockFontColorR",0),clock.getInt("LiYanClockFontColorG",255),clock.getInt("LiYanClockFontColorB",255));
			clockSetting.setFontColor(fontColor);
			clockSetting.setLocation(new Point(clock.getInt("LiYanClockLocationx", (int)clockSetting.getLocation().getX()), 
					clock.getInt("LiYanClockLocationy", (int)clockSetting.getLocation().getY())));
			setLocation(clockSetting.getLocation());
			System.out.println(clockSetting.getLocation().getX());
		}
	}
	
	private void save(){
		Preferences p = Preferences.userRoot();
		Preferences clock = p.node("LiYanClock");
		clock.putInt("LiYanClockLocationx",(int)getLocation().getX());
        System.out.println(getLocation().getX());
        clock.putInt("LiYanClockLocationy", (int)getLocation().getY());
        System.out.println(getLocation().getY());
        try {
            p.flush();
        } catch (BackingStoreException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}

}
