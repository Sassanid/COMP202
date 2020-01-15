public class CardGame{
  public static void main(String[] args){
    CardPile deckPlayed = CardPile.makeFullDeck();
    int numPlayers = Integer.parseInt(args[0]);
    CardPile[] pileForPlayers = new CardPile[numPlayers];
    for (int i = 0;i < numPlayers;i++){
      pileForPlayers[i] = new CardPile();
    }
    int indexOfPlayer = 0;
    for (int i = 0;i < 52;i++){
      Card cardRemoved = deckPlayed.remove(0);
      pileForPlayers[indexOfPlayer].addToBottom(cardRemoved);
      indexOfPlayer = indexOfPlayer+1;
      if(indexOfPlayer == numPlayers){
        indexOfPlayer = 0;
      }
    }
    for(int i = 0;i < numPlayers;i++){
      int result = pileForPlayers[i].find(Suit.SPADES,Value.ACE);
      if(result != -1){
        System.out.println("the winner of the game is player" + " " + (i+1) + ".");
      }
    }
  }
}