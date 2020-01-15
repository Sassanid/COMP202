import java.util.ArrayList;
import java.util.Scanner;
public class Blackjack{
  public static void main(String[] args){
     CardPile cardsToPlay = CardPile.makeFullDeck(4);
     int totChips = Integer.parseInt(args[0]);
     Scanner input = new Scanner(System.in);
     int chipsBet;
     while(cardsToPlay.getNumCards() > 10){
       chipsBet = input.nextInt();
       if(chipsBet < 0){
         break;
       }
       while(chipsBet > totChips){
         System.out.println("Bet too many,please bet an amount less than "+totChips);                                                   //chips to bet must be less or equal to total chips
         chipsBet = input.nextInt();
       }
       Results roundResult= playRound(cardsToPlay);
       // four different situations to determine the change of total chips
       if(roundResult == Results.DEALER_WINS){
         totChips = totChips - chipsBet;
       }
       if(roundResult == Results.PLAYER_WINS){
         totChips = totChips + chipsBet;
       }
       if(roundResult == Results.TIE){
         totChips = totChips;
       }
       if(roundResult == Results.BLACKJACK){
         totChips = totChips + (int)(1.5*chipsBet);
       }
       if(totChips <= 0){
         break;
       }
       System.out.println(totChips);
     }
  }
  
  // calculate the score of each card
  public static int getScore(Card input){
    int pointOfCard;
    if ((input.getValue() == Value.JACK) || (input.getValue() == Value.QUEEN) || (input.getValue() == Value.KING)){
      pointOfCard = 10;
      return pointOfCard;
    }
    if (input.getValue() == Value.ACE){
      pointOfCard = 11;
      return pointOfCard;
    }
    else {
      pointOfCard = input.getValue().ordinal() + 2;                                                                               //for value of TWO to TEN, just use ordinal method + 2 to get the score as defined
    }
    return pointOfCard;
  }
  
  public static int countValues(CardPile input){
    int totalScore = 0;
    int numACES = 0;
    for(int i = 0 ; i < input.getNumCards() ; i++){
        totalScore = totalScore + getScore(input.get(i));                                                                          //firstly, consider all the ACE as 11 and add all the values up, but still record the numer of ACES
        if(input.get(i).getValue() == Value.ACE){
          numACES = numACES + 1;
        }
    }
    if (totalScore > 21){
      for(int j = 1 ; j <= numACES ; j++ ){
        totalScore = totalScore - 10;                                                                                              //the value of ACE can also be 1, which is 10 less than the value considered in getScore method, when the score is less or equal to 21, should break
        if (totalScore <= 21){
          break;
        }
      }
    } 
    return totalScore;
  }
  
  public static Results playRound(CardPile input){
    Scanner input2 = new Scanner(System.in);
    CardPile userHand = new CardPile();
    CardPile dealerHand = new CardPile();
    Results result = Results.TIE;                                                                                                //to initialize the variable, no actual meaning
    for(int i = 0;i < 2;i++){
      userHand.addToBottom(input.remove(0));
    }
    System.out.println(userHand);
    for(int j = 0;j < 2;j++){
      dealerHand.addToBottom(input.remove(0));
      if(j == 1){
        System.out.println(dealerHand.get(j));                                                                                    //print the second card of the dealer
      }
    }
    if ((countValues(userHand) == 21) && (countValues(dealerHand) != 21)){
      System.out.println(dealerHand);
      System.out.println("The player wins!");
      result = Results.BLACKJACK;
      return result;
    }
    if ((countValues(userHand) != 21) && (countValues(dealerHand) == 21)){
      System.out.println(dealerHand);
      System.out.println("The dealer wins!");
      result = Results.DEALER_WINS;
      return result;
    }
    if ((countValues(userHand) == 21) && (countValues(dealerHand) == 21)){
      System.out.println(dealerHand);
      System.out.println("a tie");
      result = Results.TIE;
      return result;
    }
    if((countValues(userHand) != 21) && (countValues(dealerHand) != 21)){
      while(countValues(userHand) <= 21){
        String userBehaviour = input2.next();
        if(userBehaviour.equals("hit")){
          userHand.addToBottom(input.remove(0));
          System.out.println(userHand);
        }
        if(countValues(userHand) > 21){
          System.out.println(dealerHand);
          System.out.println("The dealer wins!");
          result = Results.DEALER_WINS;
          return result;
        }
        if(userBehaviour.equals("stay")){
          break;
        }
      }
      while(countValues(dealerHand) < 18){
        dealerHand.addToBottom(input.remove(0));
        if(countValues(dealerHand) > 21){
          System.out.println(dealerHand);
          System.out.println("The player wins!");
          result = Results.PLAYER_WINS;
          return result;
        }
      }  
    }
    //this happens after the while loops, since I have considered all the situation that the user/dealer's scores are larger than 21, can compare the value directly without considering it's larger than 21 or not
    if(countValues(userHand) > countValues(dealerHand)){   
      System.out.println(dealerHand);
      System.out.println("The player wins!");
      result = Results.PLAYER_WINS;
      return result;
    }
    if(countValues(userHand) == countValues(dealerHand)){
      System.out.println(dealerHand);
      System.out.println("a tie");
      result = Results.TIE;
      return result;
    }
    if(countValues(userHand) < countValues(dealerHand)){
      System.out.println(dealerHand);
      System.out.println("The dealer wins!");
      result = Results.DEALER_WINS;
      return result;
    }
    return result;
  }
  
  //creating the enum
  public enum Results{
    DEALER_WINS,
    PLAYER_WINS,
    TIE,
    BLACKJACK
  }
  
}
