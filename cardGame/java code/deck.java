package cards;
import java.util.Random;

public class deck {
	private card[] cards;
	private int numberofcards;
	private int counter;
	
	static card g9 = new card("Bisaflor",1,1,9, "bisaflor.png");
    static card g8 = new card("Rexblisar",2,1,8, "rexblisar.png");
    static card g7 = new card("Shaymin",3,1,7, "shaymin.png");
    static card g6 = new card("Tengulist",4,1,6, "tengulist.png");
    static card g5 = new card("Giflor",5,1,5, "tengulist.png");
    static card g4 = new card("Kapilz",6,1,4, "kapilz.png");
    static card g3 = new card("Tropius",7,1,3, "tropius.png");
    static card g2 = new card("Folipurba",8,1,2, "folipurba.png");
    static card g1 = new card("Tangela",9,1,1, "tangela.png");
    static card g0 = new card("Knofensa",10,1,0, "knofensa.png");
    
    static card w9 = new card("Turtok",11,2,9, "turtok.png");
    static card w8 = new card("Garados",12,2,8, "garados.png");
    static card w7 = new card("Manaphy",13,2,7, "manaphy.png");
    static card w6 = new card("Austos",14,2,6, "austos.png");
    static card w5 = new card("Wallord",15,2,5, "wallord.png");
    static card w4 = new card("Octillery",16,2,4, "octillery.png");
    static card w3 = new card("Relicanth",17,2,3, "relicanth.png");
    static card w2 = new card("Aquana",18,2,2, "aquana.png");
    static card w1 = new card("Lampi",19,2,1, "lampi.png");
    static card w0 = new card("Tentacha",20,2,0, "tentacha.png");
    
    static card f9 = new card("Glurak",21,3,9, "glurak.png");
    static card f8 = new card("Arkani",22,3,8, "arkani.png");
    static card f7 = new card("Victini",23,3,7, "victini.png");
    static card f6 = new card("Camerupt",24,3,6, "camerupt.png");
    static card f5 = new card("Flampivian",25,3,5, "flampavian.png");
    static card f4 = new card("Houndoom",26,3,4, "houndoom.png");
    static card f3 = new card("Heatmor",27,3,3, "heatmor.png");
    static card f2 = new card("Flamara",28,3,2, "flamara.png");
    static card f1 = new card("Ponita",29,3,1, "ponita.png");
    static card f0 = new card("Vulpix",30,3,0, "vulpix.png");
     
    static card[] unshuffled = {g9,g8,g7,g6,g5,g4,g3,g2,g1,g0,w9,w8,w7,w6,w5,w4,w3,w2,w1,w0,f9,f8,f7,f6,f5,f4,f3,f2,f1,f0};
    private Random randomiser = new Random();
    
    public deck(){
    	this.numberofcards = 30;
    	this.counter = 0;
    	this.cards = shuffleDeck(unshuffled);
    }
    
    public deck(card[] cards){
    	this.numberofcards = cards.length;
    	this.cards = shuffleDeck(cards);
    	this.counter = 0;
    }
    
	private card[] shuffleDeck(card[] cards) {
		card temp = new card();
		for(int i=0; i<301; i++){
			int randnum1 = randomiser.nextInt(getNumberOfCardsInDeck());
			int randnum2 = randomiser.nextInt(getNumberOfCardsInDeck());
			temp = cards[randnum1];
			cards[randnum1] = cards[randnum2];
			cards[randnum2] = temp;
		}
		return cards;
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
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public card dealCard(){
		return cards[counter++];
	}
	public int getNumberOfCardsInDeck(){
		return numberofcards;
	}
	
	
}
