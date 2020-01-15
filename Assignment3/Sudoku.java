public class Sudoku{
  public static void main(String[] args){
  }
  public static int[] sort(int[] input){
    int length = input.length;
    int[] finalArray = new int[length];
    for(int i = 0;i < length;i++){
      finalArray[i] = input[i];
    }
    for(int j = 0;j < length;j++){
      int temp = finalArray[j];
      for (int k = j + 1;k < length;k++){
        if(finalArray[k] < finalArray[j]){
          finalArray[j] = finalArray[k];
          finalArray[k] = temp;
          temp = finalArray[j];
        } 
      }
    }
    return finalArray; 
  }
  
  public static boolean uniqueEntries(int[] input){
    boolean result = true;
    int[] arrayToCheck = sort(input);
    for(int i = 0;i < (arrayToCheck.length-1);i++){
      if (arrayToCheck[i] == arrayToCheck[i+1]){
        result = false;
        break;
      }
      else{
        result = true;
      }
    }
    return result;
  }
  
  public static int[] getColumn(int[][] input,int j){
    int[] result = new int[input.length];
    for(int k = 0;k < (input.length - 1);k++){
      if((input[k].length) != (input[k+1].length)){
        System.out.println("invalid array");
      }
      else{
        if(j < input[0].length){
          for(int i = 0;i < input.length;i++){
            result[i] = input[i][j];
          }
        }
        else{
          System.out.println("invalid input index");
        }
      }
    }
    return result;
  }
 
  public static int[] flatten(int[][] squareArray){
    int numIndex = 0;                                            //counting number of index for final array
    for(int i = 0;i < squareArray.length;i++){
      for(int j = 0;j < squareArray[i].length;j++){
        numIndex = numIndex + 1;
      }
    } 
    int[] finalArray = new int[numIndex];
    for(int k = 0;k < squareArray.length;k++){
      if(squareArray[k].length != squareArray.length){
        System.out.println("not a squareArray,will do nothing");
        return finalArray;
      }
    }  
    int index = 0;
    while(index < numIndex){
      for(int j = 0;j < squareArray.length;j++){     
        for(int k = 0;k < squareArray[j].length;k++){
          finalArray[index] = squareArray[j][k];
          index = index + 1;
        }
      }
    }
    return finalArray;
  }
 
  public static int[][]subGrid(int[][] squareArray,int i,int j,int m){
    int[][] finalArray = new int[m][m];
    for(int k = 0;k < squareArray.length;k++){
      if(squareArray[k].length != squareArray.length){
        System.out.println("not a squareArray,will do nothing");
        return finalArray;
      }
    } 
    if((i >= squareArray.length) || (j >=squareArray.length)){
      System.out.println("invalid index, will do nothing");
      return finalArray;
    }
    if (m > (squareArray.length - i)){
      System.out.println("bad choice of m, but still get the result anyway");
    }
    int index = 0;
    int index2 = 0;
    for(int k1 = i;k1 < squareArray.length;k1++){
      for(int k2 = j;k2 < squareArray[k1].length;k2++){
        finalArray[index][index2] = squareArray[k1][k2];;
        index2 = index2 + 1;
        if(index2 == m){
          break;
        }
      }
      index2 = 0;
      index = index + 1;
      if(index == m){
        break;
      }
    }
    return finalArray;
  }
 //main part of 1 starts here
  
  public static boolean isSuduko(int[][] arrayToCheck) {
    boolean isSuduko = true;
    if (arrayToCheck.length != 9){
      isSuduko = false;
      return isSuduko;
    }
    for(int i = 0;i < arrayToCheck.length;i++){
      if(arrayToCheck[i].length != arrayToCheck.length){
        isSuduko = false;
        return isSuduko;
      }
    } 
    for(int i = 0;i < arrayToCheck.length;i++){
      for(int j = 0;j < arrayToCheck[i].length;j++){
        if((arrayToCheck[i][j] < 1) || (arrayToCheck[i][j] > 9) || (uniqueEntries(arrayToCheck[i]) == false)){
          isSuduko = false;
          System.out.print(isSuduko);
          return isSuduko;
        }
      }
    }
    for(int i = 0;i < arrayToCheck.length;i++){
      int[] columeOfArray = getColumn(arrayToCheck,i);
      if(uniqueEntries(columeOfArray) == false){
          isSuduko = false;
          return isSuduko;
      }
    }
    int[][] subGrid = new int[3][3];
    for(int i = 0;i < arrayToCheck.length;i = i + 3){
      for(int j = 0;j < arrayToCheck.length;j = j + 3){
        subGrid = subGrid(arrayToCheck,i,j,3); 
        int[] subGridAfterFlatten = flatten(subGrid);
        if(uniqueEntries(subGridAfterFlatten) == false){
          isSuduko = false;
          return isSuduko;
        }
      }
    }
    return isSuduko;
  }      
}