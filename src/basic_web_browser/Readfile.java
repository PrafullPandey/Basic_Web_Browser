package basic_web_browser;

import java.awt.*;
import java.awt.event.* ;
import javax.swing.*;
import javax.swing.event.*;


public class Readfile extends JFrame {
	
	private JTextField addressBar;
	private JEditorPane display;
	
	//constructor
	public Readfile(){
		super("p2 Basic Browser");
		addressBar = new JTextField("https://www.");
		addressBar.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent event){
						load(event.getActionCommand());
					}
				}
			);
		add(addressBar,BorderLayout.NORTH);
		display = new JEditorPane();	
		display.setEditable(false);
		display.addHyperlinkListener(
				new HyperlinkListener(){
					public void hyperlinkUpdate(HyperlinkEvent event){
						if(event.getEventType()==HyperlinkEvent.EventType.ACTIVATED)
							load(event.getURL().toString());
					}
				}
			);
		add(new JScrollPane(display),BorderLayout.CENTER);
		setSize(900,900);
		setVisible(true);
	
	}
	
	//load to display on screen
	private void load(String userText){
		try{
			display.setPage(userText);
			addressBar.setText(userText);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Enter a valid address");
			System.out.println("unable yo load");
		}
	}
	
}
