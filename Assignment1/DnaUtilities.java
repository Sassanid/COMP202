public class DnaUtilities {
  public static void main(String[] args){
  }
  
  //3.1
  
  public static boolean isValidBase(char Base){
    boolean ValidBase;
    if (Base=='A'|| Base=='C'||Base=='G'||Base=='T'){
      ValidBase = true;
    }
    else {
      ValidBase = false;
    }
    return ValidBase;
  }
  
  //3.2
  
  public static char watsonCrickComplement(char OneBase){
    boolean BaseCheck = isValidBase(OneBase);
      if (!BaseCheck){
        return OneBase;
      }
      if (BaseCheck){
        if (OneBase=='A'){
          OneBase = 'T';
          return OneBase;
        }
        if (OneBase=='T'){
          OneBase = 'A';
          return OneBase;
        }
        if (OneBase=='G'){
          OneBase = 'C';
          return OneBase;
        }
        if (OneBase=='C'){
          OneBase = 'G';
          return OneBase;
        }
      }
    return OneBase;
  }
  
  //3.3
  
  public static String watsonCrickTripletComplement(String dnaSequence){
    int length = dnaSequence.length();
    String Complement = "";
      if (length != 3){
        return Complement;
      }
      else {
        char FirstBase = dnaSequence.charAt(0);
        char SecondBase = dnaSequence.charAt(1);
        char ThirdBase = dnaSequence.charAt(2);
        if (isValidBase(FirstBase) && isValidBase(SecondBase) && isValidBase(ThirdBase)){
          FirstBase = watsonCrickComplement(FirstBase);
          SecondBase = watsonCrickComplement(SecondBase);
          ThirdBase = watsonCrickComplement(ThirdBase);
          Complement = "" + FirstBase + SecondBase + ThirdBase;
          return Complement;
        }
        else {
          Complement = "";
          return Complement;
        }
      } 
  }
} 