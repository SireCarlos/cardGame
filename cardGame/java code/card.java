package cards;

import javax.swing.ImageIcon;

public class card {
	private String name;
	private int number;
	private int colour;
	private int value;
	private ImageIcon image;
	
	public card(String name, int number, int colour, int value, String image){
		this.name = name;
		this.number = number;
		this.colour = colour;
		this.value = value;
		this.image =  new ImageIcon(this.getClass().getResource(image));
	}
	
	public card(){
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getColour() {
		return colour;
	}
	public void setColour(int colour) {
		this.colour = colour;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public ImageIcon getImage() {
		return image;
	}

	public void setImage(ImageIcon image) {
		this.image = image;
	}

	public String printColour(){
		switch(this.colour){
			case 1:
				return "Gruen";
			case 2:
				return "Blau";
			case 3:
				return "Rot";
			default:
				return "Fehler";
		}
	}
	public String printCard(){
		return (getName() + " (" + getValue() + " | " + printColour() + ")");
	}
}
