package dms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiariesTest {
    private Diaries diaries;
    @BeforeEach
    public void setUp() {
        diaries = new Diaries();
    }

    @Test
    public void testAdd() {
        diaries.addDiary("og", "1234");
        assertEquals(Diary.class, diaries.findByUsername("og").getClass());
    }

    @Test
    public void testDelete() {
        diaries.addDiary("og", "1234");
        diaries.addDiary("oghene", "5678");
        diaries.delete("og", "1234");
        assertNull(diaries.findByUsername("og"));
        assertEquals(Diary.class, diaries.findByUsername("oghene").getClass());
        assertNotNull(diaries.findByUsername("oghene"));
        diaries.delete("og", "1234");
    }
}
