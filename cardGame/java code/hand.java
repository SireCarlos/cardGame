package cards;

public class hand {
	private  card[] handcards = new card[10];
	
	public hand(){
	}
	
	public hand(card[] handcards){
		this.handcards = handcards;
	}
	
	public card[] getHandCards() {
		return handcards;
	}

	public void setHandCards(card[] handcards) {
		this.handcards = handcards;
	}
	
	public card removeHandCard(int number){
		card card = getHandCard(number);
		while(number < getNumberOfCards()){
			handcards[number] = handcards[number+1];
			number++;
		}
		return card;
	}
	
	public card getHandCard(int number) {
		return handcards[number];
	}

	public void setHandCard(card handcard, int number) {
		this.handcards[number] = handcard;
	}
	
	public int getNumberOfCards(){
		int count = 0;
		for (int i = 0; i < handcards.length; i++){
			if(handcards[i] != null){
				count++;
			}
		}
		return count;
	}
}
