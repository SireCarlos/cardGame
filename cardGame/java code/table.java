package cards;

public class table {
	private int pointer;
	private card blank = new card("Blank",0,0,0, "img/wallord.png");
	private card[] cards = new card[30];
	public table(card[] cards){
		this.pointer = 0;
		this.cards[0] = blank;
	}
	
	public table(){
		this.pointer = 0;
		this.cards[pointer] = blank;
	}
	
	public void addCard(card card){
		pointer++;
		this.cards[pointer] = card;
		return;
	}
	
	public card getCardOnTop(){
		return cards[pointer];
	}
	
	public int getNumberOfCardsInPlay(){
		return pointer;
	}

	public card[] getCards() {
		return cards;
	}

	public void setCards(card[] cards) {
		this.cards = cards;
	}
	
	public card getCard(int number) {
		return cards[number];
	}

	public void setCards(card card, int number) {
		this.cards[number] = card;
	}
}
