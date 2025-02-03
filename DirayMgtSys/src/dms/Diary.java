package dms;

import java.util.ArrayList;
import java.util.List;

public class Diary {
    private final String username;
    private final String password;
    private boolean isLocked;
    private final List<Entry> entries = new ArrayList<>();

    public Diary(String username, String password) {
        this.username = username;
        this.password = password;
        this.isLocked = true;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void lockDiary(boolean locked) {
        isLocked = true;
    }

    public void unlockDiary() {
        isLocked = false;
    }

    public void addEntry(String title, String content) {
        if (isLocked) return;
        entries.add(new Entry(entries.size(), title, content));
    }

    public Entry findEntryById(int id) {
        if (entries.isEmpty() || isLocked()) return null;

        return entries.stream()
                .filter((entry) -> entry.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void delete(int id) {
        if (findEntryById(id) == null || isLocked) return;
        entries.remove(id);
    }

    public void updateEntry(int id, String title, String content) {
        Entry entry = findEntryById(id);
        if (entry == null || isLocked) return;
        entry.updateTitle(title);
        entry.updateBody(content);
    }

    public String username() {
        return username;
    }

    public boolean isAuthenticated(String username, String password) {
        return username().equals(username) && this.password.equals(password);
    }
}
