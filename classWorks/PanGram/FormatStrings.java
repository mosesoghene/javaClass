import java.util.Arrays;

public class FormatStrings{
  public String capitalize(String sentence){
    String[] words = sentence.split("\\s+");
    for(int i = 0; i < words.length; i++)
      words[i] = words[i].substring(0,1).toUpperCase() + words[i].substring(1).toLowerCase();
    
    return String.join(" ", words);
  }
  
  public int[] minMaxOfSumsOf(int[] array){
    int[] sums = new int[array.length];
    int[] minMax = new int[2];
    int total = 0;
    for(int sumsIndex = 0; sumsIndex < sums.length; sumsIndex++){
      for (int arrayIndex = 0; arrayIndex < array.length; arrayIndex++)){
        total += array[arrayIndex];
      }
      sums[sumsIndex] = total - array[sumsIndex];
      total = 0;
      
    }
    
  }
  
}
