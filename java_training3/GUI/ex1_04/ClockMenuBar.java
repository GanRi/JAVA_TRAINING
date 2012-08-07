package ex1_04;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClockMenuBar extends MenuBar{
	private Menu setMenu = null;
	private MenuItem propertySetMenuItem = null;
	private PropertySetDialog dialog = null;
	
	
	public ClockMenuBar(ClockWindow frame, CurrentTimePanel currentPanel, ClockSetting set){
		setMenu = new Menu("Menu");
		propertySetMenuItem = new MenuItem("Set Property");
		dialog = new PropertySetDialog(frame, currentPanel, set);
		propertySetMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("clicked");
				dialog.setVisible(true);
				
			}
			
		});
		setMenu.add(propertySetMenuItem);
		this.add(setMenu);
	}
}
