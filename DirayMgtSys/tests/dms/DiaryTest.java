package dms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryTest {
    private Diary diary;

    @BeforeEach
    public void initialize(){
        diary = new Diary("localdevv", "1234");
    }

    @Test
    public void diaryCreated_diaryIsLocked_diaryTest(){
        assertTrue(diary.isLocked());
    }

    @Test
    public void diaryCreated_unlockDiary_diaryIsNotLocked_diaryTest(){
        diary.unlockDiary();
        assertFalse(diary.isLocked());
    }

    @Test
    public void diaryCreated_unlockDiary_createEntry_findEntryById_diaryTest(){
        diary.unlockDiary();
        diary.addEntry("Love Chi", "Regardless, chi is still chi");
        assertEquals(Entry.class, diary.findEntryById(0).getClass());
    }

    @Test
    public void diaryCreated_unlockDiary_findEntryById_2_returnsNull_diaryTest(){
        diary.unlockDiary();
        assertNull(diary.findEntryById(2));
    }

    @Test
    public void createEntry_deleteEntry_findEntryById_returnNull_diaryTest(){
        diary.unlockDiary();
        diary.addEntry("Love Chi", "Regardless, chi is still chi");
        assertEquals(Entry.class, diary.findEntryById(0).getClass());
        diary.delete(0);
        assertNull(diary.findEntryById(0));
    }

    @Test
    public void createEntry_updateEntry_findEntryById_returnsUpdatedEntry_diaryTest(){
        diary.unlockDiary();
        diary.addEntry("Love Chi", "Regardless, chi is still chi");
        diary.updateEntry(0, "Love Chioma", "Regardless, chi is still chi");
        assertEquals("Love Chioma", diary.findEntryById(0).getTitle());
    }

}
