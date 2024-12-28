//User: create Diary(Name, entries(id, body, title))
import java.util.ArrayList;

public class Diary{
  private String name;
  private ArrayList<Entry> entries;
  private boolean lockStatus; 
  
  public Diary(String name){
    this.name = name;
    this.entries = new ArrayList<>();
    this.lockStatus = false;
  }
  
  public void lockDiary(){
    this.lockStatus = true;
  }
  
  public void unlockDiary(){
    this.lockStatus = false;
  }
  
  public boolean getLockStatus(){
    return this.lockStatus;
  }
  
  public void addEntry(String title, String body){
    this.entries.add(new Entry(title, body));
  }
  
  public String getDiaryName(){
    retrun this.name;
  }
}
