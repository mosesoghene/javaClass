import java.util.ArrayList;
import java.util.Scanner;

public class User{
  static ArrayList<Diary> diaries = new ArrayList<>();
  
  public void mainMenu(){
    Scanner input = new Scanner(System.in);
    String promptMessage = """
    Main Menu
    
    1. Create new diary
    2. Select diary
    3. Delete diary
    0. Exit
    
    >>>   """;
    inputPrompt(promptMessage);
    String option = input.next();
    
    switch (option){
      case "1" -> {
        inputPrompt("Enter Diary Name \n\n>>>   ");
        String diaryName = input.nextLine();
        diaries.add(new Diary(diaryName));
        mainMenu();
      }
      case "2" -> {
        inputPrompt("Enter Diary Name to select it\n\n>>>   ");
        String diaryNeeded = input.nextLine();
        for (Diary diary: diaries){
          if ( diary.getDiaryName().ignoreCase()
                    .equals(diaryNeeded.ignoreCase()) 
              ){
                diaryMenu(diary);
                return;
          } else {
            System.out.println("Specified Diary Not Found");
            mainMenu();
          }
        }
      }
      case "3" -> {
        inputPrompt("Enter Diary Name to delete it\n\n>>>   ");
        String diaryNeeded = input.nextLine();
        for (Diary diary: diaries){
          if ( diary.getDiaryName().ignoreCase()
                    .equals(diaryNeeded.ignoreCase()) 
              ){
                diaries.remove(diary);
                System.out.println("Diary deleted");
                mainMenu();
          } else {
            System.out.println("Specified Diary Not Found");
            mainMenu();
          }
        }
      }
    }
  }
  
  public void diaryMenu(Diary diary){
    Scanner input = new Scanner(System.in);
    String promptMessage = """
    Diary Menu
    
    1. Create new entry
    2. update entry
    3. Delete entry
    4. Find entry
    5. view all entries
    0. Exit
    
    >>>   """;
    inputPrompt(promptMessage);
    String option = input.next();
    
    switch (option){
      case "1" -> {
        inputPrompt("Enter Entry Title \n\n>>>   ");
        String EntryTitle = input.nextLine();
        
        inputPrompt("Enter Entry Body \n\n>>>   ");
        String entryBody = input.nextLine();
        
        diaries.add(diary.addEntry(EntryTitle, entryBody));
        diaryMenu();
      }
      case "2" -> {
        inputPrompt("Enter Diary Name to select it\n\n>>>   ");
        String diaryNeeded = input.nextLine();
        for (Diary currentDiary: diaries){
          if (diary.getDiaryName().equalsIgnoreCase(diaryNeeded)){
            diaryMenu(currentDiary);
            return;
          } else {
            System.out.println("Specified Diary Not Found");
            mainMenu();
          }
        }
      }
      case "3" -> {
        inputPrompt("Enter Diary Name to delete it\n\n>>>   ");
        String diaryNeeded = input.nextLine();
        for (Diary currentDiary: diaries){
          if ( diary.getDiaryName().equalsIgnoreCase(diaryNeeded) ){
                diaries.remove(currentDiary);
                System.out.println("Diary deleted");
                mainMenu();
          } else {
            System.out.println("Specified Diary Not Found");
            mainMenu();
          }
        }
      }
    }
  }
  
  public void inputPrompt(String text){
    System.out.print(text);
  }
  
  public static void main(String... args){
    
  }
}
