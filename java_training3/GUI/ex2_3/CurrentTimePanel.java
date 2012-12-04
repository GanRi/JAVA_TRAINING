package ex2_3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Point;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JWindow;

public class CurrentTimePanel extends JPanel implements Runnable{
	private Image iBuffer = null;
	private Graphics gBuffer = null;
	private ClockWindow window = null;
	private Point clockPosition;
	Thread clock;
	Font font = null;
	int fontSize = 50;
	String fontStyle = "TimesRoman";
	Color backgroundColor = Color.WHITE;
	Color fontColor = Color.BLACK;

	ClockPopupMenu popupMenu = null;

	public CurrentTimePanel(final ClockWindow window) {
		this.window = window;
		//popupMenu = new ClockPopupMenu(this, window);

		this.setFontType();
		start();
		this.add(popupMenu);
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON3)
					popupMenu.show(e.getComponent(), e.getX(), e.getY());
			}

			public void mouseEntered(MouseEvent e) {
				System.out.println("Entered");
			}

			public void mouseExited(MouseEvent e) {
				System.out.println("Exited");
			}
		});
	}

	public void setFontSize(int size) {
		fontSize = size;
		setFontType();
	}

	public int getFontSize() {
		return this.fontSize;
	}

	private void setFontType() {
		this.font = new Font(fontStyle, Font.BOLD, fontSize);
		setFont(font);
	}

	public void setFontStyle(String style) {
		this.fontStyle = style;
		setFontType();
	}

	public void setBackgroudColor(Color color) {
		this.backgroundColor = color;
	}

	public void setFontColor(Color color) {
		this.fontColor = color;
	}

	public Color getFontColor() {
		return this.fontColor;
	}

	public Color getBackgroudColor() {
		return this.backgroundColor;
	}

	public Font getFont() {
		return this.font;
	}

	public void start() {
		if (clock == null) {
			clock = new Thread(this);
			clock.start();
		}
	}

	public void run() {
		while (clock != null) {
			try {
				repaint();
				Thread.sleep(1000);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void stop() {
		clock = null;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Calendar now = new GregorianCalendar();
		String timeInfo = "";
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);
		if (hour <= 9)
			timeInfo += "0" + hour + ":";
		else
			timeInfo += hour + ":";
		if (minute <= 9)
			timeInfo += "0" + minute + ":";
		else
			timeInfo += minute + ":";
		if (second <= 9)
			timeInfo += "0" + second;
		else
			timeInfo += second;

		setBackground(getBackgroudColor());
		g.setFont(getFont());
		g.setColor(getFontColor());
		g.drawString(
				timeInfo,
				((int) (this.getSize().width * 0.5) - (int) (this.getFontSize() * 2.4)),
				(int) (this.getSize().height * 0.5)
						- (int) (this.getFontSize() * 0.35));
	}
}
