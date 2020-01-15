import java.lang.Math;
import java.util.Random;
public class Cryptography{
  public static void main(String[] args){
  }
  // 1
  //1.1
  public static String caesarEncrypt(String originalMessage,int shift){
    while (shift > 26){
      shift  = shift-26;
    }
    int length = originalMessage.length();
    String encryptMessage = "";
    for (int i = 0;i < length;i++){
      char letterMessage = originalMessage.charAt(i);  //this checks whether the String at position i is a letter//
      if ((65 <= letterMessage && letterMessage <= 90) || (97 <= letterMessage && letterMessage <= 122)){
        if((90-shift) < letterMessage && letterMessage <= 90){
          letterMessage = (char)(64 + shift - (90 - letterMessage));
        }
        else if ((122-shift) < letterMessage && letterMessage <= 122){
          letterMessage = (char)(96 + shift - (122 - letterMessage));
        }
        else {
          letterMessage = (char)(letterMessage + shift);
        }
      }
      else {
        letterMessage = letterMessage;
      }
    encryptMessage = encryptMessage + letterMessage;
    }
    return encryptMessage;
  }
  
  
  //1.2
  public static String caesarDecrypt(String encoded,int shift){
    while (shift > 26){
      shift  = shift-26;
    }
    int length = encoded.length();
    String decryptMessage = "";
    for (int i = 0;i < length;i++){
      char letterMessage = encoded.charAt(i);  //this checks whether the String at position i is a letter//
      if ((65 <= letterMessage && letterMessage <= 90) || (97 <= letterMessage && letterMessage <= 122)){
        if(65 <= letterMessage && letterMessage < (65+shift)){
          letterMessage = (char)(91 - shift + (letterMessage - 65));
        }
        else if (97 <= letterMessage && letterMessage < (97+shift)){
          letterMessage = (char)(123 - shift + (letterMessage - 97));
        }
        else {
          letterMessage = (char)(letterMessage - shift);
        }
      }
      else {
        letterMessage = letterMessage;
      }
    decryptMessage = decryptMessage + letterMessage;
    }
    return decryptMessage;
  }
  //1.3
  public static String crackCiper(String encoded,int numberLetters){
    String[] posibilities = new String[numberLetters];
    int[] numberEachString = new int[numberLetters];
    String sentencesToBeChosen = "";
    for (int i = 0;i < numberLetters;i++){
      posibilities[i] = caesarDecrypt(encoded,i);
      numberEachString[i]= SentenceChecker.countEnglishWords(posibilities[i]);
    }
    int expectedWords = numberEachString[0];
    for (int j = 1;j < numberLetters;j++){
      if ((numberEachString[j-1] <= numberEachString[j]) && numberEachString[j] >= expectedWords){
        expectedWords = numberEachString[j];
      }
    }
    for (int k = 0;k < numberLetters;k++){
      if (numberEachString[k] == expectedWords){
        sentencesToBeChosen = sentencesToBeChosen + posibilities[k]+"   ";
      }
    }
  return sentencesToBeChosen;
  }
  
  //2
  //2.1
  public static void shuffle(char[] input){
    Random generator = new Random(12345);
    int arrayLength = input.length;
    for (int i = 1;i <= Math.pow(arrayLength,4);i++){
      int elementOne = generator.nextInt(arrayLength);
      int elementTwo = generator.nextInt(arrayLength);
      char contemporaryElementOne = input[elementOne];
      char contemporaryElementTwo = input[elementTwo];
      input[elementOne] = contemporaryElementTwo;
      input[elementTwo] = contemporaryElementOne;
    }
  }
  //2.2
  public static char[] generatePermutation(){
    char[] arrayWithLetters= new char[26];
    for (int i = 0;i < 26;i++){
      arrayWithLetters[i] = (char)(i + 65);
    }
    shuffle(arrayWithLetters);
    return arrayWithLetters;
  }
  //2.3
  public static String permuteEncrypt(String input){
    char[] encryptArray = generatePermutation();
    int lengthOfString = input.length();
    String encoded = "";
    for (int i = 0; i < lengthOfString ; i++){
      char Letter = input.charAt(i);
      if (97 <= Letter && Letter <= 122){
        Letter = (char)(Letter - 32);
      }
      if (65 <= Letter && Letter <= 90){
        int value = Letter - 65; //find the corresponding alphabet value of the Letter
        Letter = encryptArray[value];
      }
      encoded = encoded + Letter;
    }
    return encoded;
  }
}