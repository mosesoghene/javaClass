package dms;

import java.time.LocalDateTime;

public class Entry {
    private int id;
    private String title;
    private String body;
    private LocalDateTime date;

    public  Entry(int id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.date = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateBody(String content) {
        this.body = content;
    }
}
