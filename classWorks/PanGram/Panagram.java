
public class Panagram{
  
  public boolean isPanagram(String text){
    return text.toLowerCase()
               .chars()
               .filter(letter -> letter >= 'a' && letter <= 'z')
               .distinct()
               .count() == 26;
  }
}
