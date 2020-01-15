public class CardPile{
  private Card[] cards;
  private int numCards;
  
  public CardPile(){
    this.cards = new Card[52];
    this.numCards = 0;
  }
  public void addToBottom(Card c){
    cards[numCards] = c;
    numCards = numCards + 1;
  }
  public boolean isEmpty(){
    boolean isEmpty = true;
    for(int i = 0;i < 52;i++){
      if (cards[i] != null){
        isEmpty = false;
      }
    }
    return isEmpty;
  }
  public Card remove(int i){
    if (i >= numCards) {
      Card cardToRemove = cards[numCards-1];
      System.out.println("no cards here,please enter a value less than"+" "+numCards+" which is "+cardToRemove);
      return cardToRemove;
    }
    Card cardToRemove = cards[i];
    for(int j = i; j < (numCards - 1);j++){
      cards[j] = cards[j+1];
    }
    numCards = numCards - 1;
    return cardToRemove;
  }
  public int find(Suit s,Value v){
    int index = -1;
    for(int i = 0;i < numCards;i++){
      Suit suitOfCard = cards[i].getSuit();
      Value valueOfCard = cards[i].getValue();
      if((suitOfCard == s) && (valueOfCard == v)){
        index = i;
        return index;
      }
    }
    return index;  
  }
  public String toString(){
    String finalString = "";
    for(int i = 0;i < numCards;i++){
      finalString = finalString +i+"."+ cards[i]+" ";
    }
    return finalString;
  }
  public static CardPile makeFullDeck(){
    CardPile fullDeck = new CardPile();
    for(Suit s:Suit.values()){
      for(Value v:Value.values()){
        Card c = new Card(s,v);
        fullDeck.cards[fullDeck.numCards] = c;
        fullDeck.numCards = fullDeck.numCards + 1;
      }
    }
    UtilityCode.shuffle(fullDeck.cards,fullDeck.numCards);
    return fullDeck;
  }
}