public class LeapYearCalculator {
  public static void main (String[] args) {
    System.out.println(subsequentLeapYear(396));
  }
  
  // 2a
  
  public static void printIsLeapYear(int year) {
    if (year%4 == 0 && year%100 != 0){
      System.out.println(year + " is a leap year");
    }
    if (year%400 == 0){
      System.out.println(year + " is a leap year");
    }
    else{
      System.out.println(year + " is not a leap year");
    }
  }
  
  // 2b
  
  public static boolean isLeapYear(int year) {
    boolean isLeapyear;
    if (year%4 == 0 && year%100 != 0){
      isLeapyear = true;
    }
    else if (year%400 == 0){
      isLeapyear = true;
    }
    else{
      isLeapyear = false;;
    }
    return isLeapyear;
  }
  
  // 2c
  
  public static int subsequentLeapYear(int year) {
    boolean YearCheck = isLeapYear(year);
    int subsequentleapYear = year + 4;
    if (YearCheck){
      YearCheck = isLeapYear(year + 4);
      if (YearCheck) {
        subsequentleapYear = year + 4;
      }
      else {
        subsequentleapYear = year + 8;
      }
    return subsequentleapYear;
    }
    if (!YearCheck){
      YearCheck = isLeapYear(year + 1);
      if (YearCheck) {
        subsequentleapYear = year + 1;
        return subsequentleapYear;
      }
      else {
        YearCheck = isLeapYear(year + 2);
      }
      if (YearCheck) {
        subsequentleapYear = year + 2;
        return subsequentleapYear;
      }
      else {
        YearCheck = isLeapYear(year + 3);
      } 
      if (YearCheck) {
        subsequentleapYear = year + 3;
        return subsequentleapYear;
      }
      else {
        YearCheck = isLeapYear(year + 5);
      }  
      if (YearCheck) {
        subsequentleapYear = year + 5;
        return subsequentleapYear;
      }
      else {
        YearCheck = isLeapYear(year + 6);
      }
      if (YearCheck) {
        subsequentleapYear = year + 6;
        return subsequentleapYear;
      }
      else { 
        YearCheck = isLeapYear(year + 7);
      }
      if (YearCheck) {
        subsequentleapYear = year + 7;
        return subsequentleapYear;
      }
    }
    return subsequentleapYear;
  }
}
  

    
    
    