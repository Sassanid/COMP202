public class MakingChange{
  public static void main(String[] args){
    int money = Integer.parseInt(args[0]);
    int change = money;
    int toonie = 0;
    int loonie = 0;
    int quater = 0;
    int dime = 0;
    int nickel = 0;
    int penny = 0;
    while (money >= 200) {
      money = money - 200;
      toonie = toonie + 1;
    }
    while (200 > money && money >= 100) {
      money = money - 100;
      loonie = loonie + 1;
    }
    while (100 > money && money >= 25) {
      money = money - 25;
      quater = quater + 1;
    }
    while (25 > money && money >= 10) {
      money = money - 10;
      dime = dime +1;
    }
    while (10 > money && money >= 5) {
      money = money - 5;
      nickel = nickel + 1;
    }
    while (5 > money && money > 0) {
      money = money - 1;
      penny = penny + 1;
    }
    System.out.println("change for "+ change + " cents is:" + "\nNumber of toonies:" + toonie + "\nNumber of loonies:" + loonie + "\nNumber of quaters:" + quater + "\nNumber of dimes:" + dime + "\nNumber of nickels:" + nickel + "\nNumber of pennies:" + penny);   
  }
}
    