package dms;

import java.util.ArrayList;
import java.util.List;

public class Diaries {
    private final List<Diary> diaries = new ArrayList<Diary>();

    public void addDiary(String username, String password) {
        diaries.add(new Diary(username, password));
    }

    public Diary findByUsername(String username) {
        return diaries.stream()
                .filter((diary) -> isUsername(username, diary))
                .findFirst()
                .orElse(null);
    }

    private boolean isUsername(String username, Diary diary) {
        return diary.username().equals(username);
    }

    public void delete(String username, String password) {
        diaries.removeIf((diary) -> diary.isAuthenticated(username, password));
    }
}
