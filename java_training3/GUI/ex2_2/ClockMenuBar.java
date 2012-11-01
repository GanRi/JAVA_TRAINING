package ex2_2;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GraphicsEnvironment;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ClockMenuBar extends JMenuBar{
	private JMenu setMenu = null;
	private JMenuItem propertySetMenuItem = null;
	private PropertySetDialog dialog = null;
	
	
	public ClockMenuBar(ClockWindow frame, CurrentTimePanel currentPanel){
		
		
		
		setMenu = new JMenu("Menu");
		propertySetMenuItem = new JMenuItem("Set Property");
		dialog = new PropertySetDialog(frame, currentPanel);
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
