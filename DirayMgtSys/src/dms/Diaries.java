package dms;

import java.util.ArrayList;
import java.util.List;

public class Diaries {
    private final List<Diary> diaries = new ArrayList<Diary>();

    public void addDiary(String username, String password) {
        diaries.add(new Diary(username, password));
    }

    public Diary findByUsername(String username) {
        for (Diary diary : diaries) {
            if (diary.username().equals(username)) return diary;
        }
        return null;
    }

    public void delete(String username, String password) {
        for (Diary diary : diaries) {
            if (diary.isAutenticated(username, password)) {
                diaries.remove(diary);
                return;
            }
        }
    }


}
