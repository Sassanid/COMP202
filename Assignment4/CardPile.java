import java.util.ArrayList;
import java.util.Collections;
public class CardPile{
  private ArrayList<Card>cards;
  private int numCards;
  
  // this method is the constructor of the class CardPile
  public CardPile(){
    this.cards = new ArrayList<Card>(52);            //index 52 may be meaningless, just write in a way that is similar with the past assignment 
    int numCards = 0;
  }
  
  
  //simply using add() method without declaring the index since this will add a card to the bottom directly
  public void addToBottom(Card c){
    this.cards.add(c);
    numCards++;
  }
  
  //there is a built-in method to test whether an arraylist is empty
  public boolean isEmpty(){
    return this.cards.isEmpty();
  }
  
  //there is a built-in method to obtain an element at an index of an arraylist, using it directly
  public Card get(int i){
    Card cardAtI = new Card (Suit.CLUBS,Value.TWO);
    if (i >= (this.cards.size()) || (i < 0)){
      System.out.println("no card found here, you just get a meaningless card");
      return cardAtI;
    }
    else{
      cardAtI = this.cards.get(i);                                //assign the variable with the value of the card at index i
    }
    return cardAtI;
  }
  
  public Card remove(int i){
    if (i >= (this.cards.size()) || (i < 0)){                                           //to prevent the situation that i is not a valid index of the arraylist
       Card cardToRemove = new Card(Suit.CLUBS,Value.TWO);
       System.out.println("no cards here,just get a meaningless card "+cardToRemove);
       return cardToRemove;
    }
    Card cardToRemove = this.cards.remove(i);
    this.numCards--;
    return cardToRemove;
  }
  
  public int find(Suit s, Value v){
    int index = -1;
    for(int i = 0;i < numCards;i++){
      Suit suitOfCard = this.cards.get(i).getSuit();
      Value valueOfCard = this.cards.get(i).getValue();
      if((suitOfCard == s) && (valueOfCard == v)){
        index = i;
        return index; 
      } 
    }                                                                                                      //compare the suit and value of the element with the input
    return index;
  } 
  
  public String toString(){
    String finalString = "";
    for(int i = 0;i < numCards;i++){
      finalString = finalString +i+"."+ this.cards.get(i)+" ";
    }
    return finalString;
  }
  
  // similar make a full deck with 52 cards in an arraylist
  public static CardPile makeFullDeck(){
    CardPile fullDeck = new CardPile();
    for(Suit s:Suit.values()){
      for(Value v:Value.values()){
        fullDeck.addToBottom(new Card(s,v));
      }
    }
    Collections.shuffle(fullDeck.cards);
    return fullDeck;
  }
  
  
  //  Problem 2 starts here
  
  public static CardPile makeFullDeck(int n){
    CardPile fullDeck = CardPile.makeFullDeck();
    for(int i = 1;i < n;i++){
      for(int j = 0;j < 52;j++){
        fullDeck.addToBottom(fullDeck.cards.get(j));
      }
    }
    Collections.shuffle(fullDeck.cards);
    return fullDeck; 
  }
  
  public int getNumCards(){
    return this.numCards;
  }
    
    
}