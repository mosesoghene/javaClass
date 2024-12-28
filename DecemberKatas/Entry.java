public class Entry{
  private int currentId = 1;
  private int id;
  private String title;
  private String body;
  
  public Entry(String title, String body){
    this.id = currentId++;
    this.title = title;
    this.body = body;
    
    printDiaryInfo();
  }
  
  private void printDiaryInfo(){
    System.out.println("Entry Successfully Created:");
    System.out.printf("Entry ID: %d%n", this.id);
    System.out.printf("Title: %s%n", this.title);
    System.out.printf("Body: %n%n%s", this.body);
  }
  
  public void updateEntryBody(String newBody){
    this.body = newBody;  
  }
  
  public void updateEntryTitle(String newTitle){
    this.title = newTitle;  
  }
  
  public int getId(){
    return this.id;
  }
}
