package ex2_4;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.colorchooser.ColorSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PropertySetDialog extends JDialog {
	private JButton saveButton = new JButton("     Set     ");
	private JButton cancelButton = new JButton("  Cancel  ");
	private GridBagLayout layout = new GridBagLayout();
	
	private JLabel fontColorLabel = new JLabel("Font Color: ");
	private JLabel fontSizeLabel = new JLabel("Font Size: ");
	private JLabel fontLabel = new JLabel("Font: ");
	private JLabel backgroudColorLable = new JLabel("Backgroud Color: ");
	
	private Choice fontColor = new Choice();
	private Choice fontStyle = new Choice();
	private Choice fontSize = new Choice();
	private Choice backgroudColor = new Choice();
	
	private Color fontColorSave = Color.BLUE;
	private Color backgroudColorSave = Color.YELLOW;
	private ClockSetting set = new ClockSetting();
	
	private JColorChooser fontColorChooser = new JColorChooser();
	private JColorChooser backgroudColorChooser = new JColorChooser();
	
	private String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment()
			.getAvailableFontFamilyNames();
	
	
	public PropertySetDialog(ClockWindow frame, final CurrentTimePanel timePanel, ClockSetting set) {
		super(frame);
		this.set = set;
		this.setTitle("Set Property");
		this.setResizable(false);
		
		ColorSelectionModel fontModel = fontColorChooser.getSelectionModel();
	    ChangeListener changeListener = new ChangeListener() {
	      public void stateChanged(ChangeEvent changeEvent) {
	    	fontColorSave = fontColorChooser.getColor();	    	
	        timePanel.setFontColor(fontColorSave);
	      }
	    };
	    
	    fontModel.addChangeListener(changeListener);
	    
		ColorSelectionModel backgroudModel = backgroudColorChooser.getSelectionModel();
	    ChangeListener backgroudChangeListener = new ChangeListener() {
	      public void stateChanged(ChangeEvent changeEvent) {
	    	backgroudColorSave = backgroudColorChooser.getColor();
	        timePanel.setBackgroudColor(backgroudColorSave);
	      }
	    };
	    
	    backgroudModel.addChangeListener(backgroudChangeListener);

		this.setLayout(layout);
		this.createButton(frame, timePanel);
		this.createLayout();
		this.createContents();
		
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		this.setSize(1300, 600);
	}

	private void createLayout(){
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth=1;
		constraints.gridheight=1;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.NONE;
		constraints.weightx = 0.0;
		constraints.weighty = 0.0;
		constraints.insets = new Insets(0,0,0,0);
		constraints.ipadx = 0;
		constraints.ipady = 0;
		makeLayoutContents(layout, constraints, fontColorLabel);
		constraints.gridy = 1;
		constraints.anchor = GridBagConstraints.WEST;
		//makeLayoutContents(layout, constraints, fontColor);fontColorChooser
		makeLayoutContents(layout, constraints, fontColorChooser);
		//makeLayoutContents(layout, constraints, box);
		
		//-------------
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.anchor = GridBagConstraints.WEST;
		makeLayoutContents(layout, constraints, backgroudColorLable);
		//makeLayoutContents(layout, constraints, fontSizeLabel);
		
		constraints.gridy = 1;
		constraints.anchor = GridBagConstraints.WEST;
		makeLayoutContents(layout, constraints, backgroudColorChooser);
		//makeLayoutContents(layout, constraints, fontSize);
		
		constraints.gridy = 2;
		constraints.gridx = 0;
		constraints.anchor = GridBagConstraints.WEST;
		makeLayoutContents(layout, constraints, fontSizeLabel);
		constraints.gridy = 3;
		constraints.anchor = GridBagConstraints.WEST;
		makeLayoutContents(layout, constraints, fontSize);
		constraints.gridx = 1;
		constraints.gridy = 2;
		//constraints.gridy = 2;
		constraints.anchor = GridBagConstraints.WEST;
		makeLayoutContents(layout, constraints, fontLabel);
		//constraints.gridx = 1;
		constraints.gridy = 3;
		constraints.anchor = GridBagConstraints.WEST;
		makeLayoutContents(layout, constraints, fontStyle);
		//constraints.gridx = 0;
		//constraints.gridy = 3;
		//constraints.anchor = GridBagConstraints.EAST;
		//makeLayoutContents(layout, constraints, backgroudColorLable);
		//constraints.gridx = 1;
		//constraints.anchor = GridBagConstraints.WEST;
		////makeLayoutContents(layout, constraints, backgroudColor);
		//makeLayoutContents(layout, constraints, backgroudColorChooser);
		
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.anchor = GridBagConstraints.EAST;
		makeLayoutContents(layout, constraints, saveButton);
		
		constraints.gridx = 1;
		constraints.gridy = 4;
		constraints.anchor = GridBagConstraints.WEST;
		makeLayoutContents(layout, constraints, cancelButton);
	}
	
	private void makeLayoutContents(GridBagLayout layout, GridBagConstraints constraints, Component component){
		layout.setConstraints(component, constraints);
		add(component);
	}
	

	private void createButton(final ClockWindow frame, CurrentTimePanel timePanel) {
		saveButton.addActionListener(new SaveButtonListener(frame, timePanel));
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
	
		cancelButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				fontStyle.select(set.getFont());
				fontSize.select(String.valueOf(set.getFontSize()));
				dispose();
			}			
		});
	}

	class SaveButtonListener implements ActionListener {
		CurrentTimePanel timePanel = null;
		ClockWindow window = null;
		public SaveButtonListener(ClockWindow frame, CurrentTimePanel timePanel) {
			this.timePanel = timePanel;
			this.window = frame;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			dispose();
			//timePanel.setBackgroudColor(convertToColor(backgroudColor.getSelectedItem()));
			//timePanel.setFontColor(convertToColor(fontColor.getSelectedItem()));
			timePanel.setFontSize(Integer.parseInt(fontSize.getSelectedItem()));
			timePanel.setFontStyle(fontStyle.getSelectedItem());
			//window.setSize((Integer.parseInt(fontSize.getSelectedItem()) * 10 + 100), (Integer.parseInt(fontSize.getSelectedItem()) * 3 + 150));
			
			Point location = window.getLocation();
			save(backgroudColorSave,fontStyle.getSelectedItem(),fontColorSave,Integer.parseInt(fontSize.getSelectedItem()), location);
		}
	}
	
	private Color convertToColor(String color){
		switch (color){
		case "Black":
			return Color.BLACK;
		case "White":
			return Color.WHITE;
		case "Red":
			return Color.RED;
		case "Yellow":
			return Color.YELLOW;
		case "Blue":
			return Color.BLUE;
		case "Cyan":
			return Color.CYAN;
		}
		return Color.BLACK;
	}
	
	private void createContents() {
		for (int i = 0; i < fonts.length; i++){
			fontStyle.add(fonts[i]);
		}
		
		fontStyle.select(set.getFont());
		
		fontSize.add("20");
		fontSize.add("30");
		fontSize.add("40");
		fontSize.add("50");
		fontSize.add("60");
		fontSize.add("70");
		fontSize.add("80");
		fontSize.select(String.valueOf(set.getFontSize()));	

	}
	
	private void save(Color backgroudColor, String font, Color fontColor, int fontSize, Point location){
		Preferences p = Preferences.userRoot();
		Preferences clock = p.node("LiYanClock");
		clock.put("LiYanClockFont", font);
        clock.putInt("LiYanClockFontSize", fontSize);
        clock.putInt("LiYanClockFontColorR", fontColor.getRed());
        clock.putInt("LiYanClockFontColorG", fontColor.getGreen());
        clock.putInt("LiYanClockFontColorB", fontColor.getBlue());
        clock.putInt("LiYanClockBackgroudColorR", backgroudColor.getRed());
        clock.putInt("LiYanClockBackgroudColorG", backgroudColor.getGreen());
        clock.putInt("LiYanClockBackgroudColorB", backgroudColor.getBlue());
        clock.putInt("LiYanClockLocationx",(int)location.getX());
        System.out.println(location.getX());
        clock.putInt("LiYanClockLocationy", (int)location.getY());
        System.out.println(location.getY());
        try {
            p.flush();
        } catch (BackingStoreException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
}
