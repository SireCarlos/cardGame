package cards;

public class player {
	private String name;
	private hand hand;
	

	public player(String name, hand hand){
		this.setName(name);
		this.hand = hand;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public hand getHand() {
		return hand;
	}

	public void setHand(hand hand) {
		this.hand = hand;
	}
	
	
	
}
