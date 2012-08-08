package Interpret;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class InterpretWindow extends JFrame{
	private JTextField className = new JTextField();
	private JLabel classNameLabel = new JLabel("Class Name : ");
	private JButton commitButton = new JButton("OK");
	
	public InterpretWindow(){
		setSize(700,100);
		className.setColumns(40);
		setLayout(new FlowLayout());
		add(classNameLabel);
		add(className);
		add(commitButton);
		
		setVisible(true);
	}
	
	public static void main(String args[]){
		
		InterpretWindow window = new InterpretWindow();
	}
}
