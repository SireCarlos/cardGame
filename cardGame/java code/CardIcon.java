package cards;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class CardIcon extends JButton{
	ImageIcon icon;
	
	public CardIcon(ImageIcon image){
		this.icon = image;
		this.addActionListener((ActionListener) this);
	}
}
