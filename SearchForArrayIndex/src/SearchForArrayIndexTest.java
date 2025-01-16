import org.junit.Test;
import static org.junit.Assert.*;

public class SearchForArrayIndexTest {

    static SearchForArrayIndex searchForArrayIndex = new SearchForArrayIndex();

    @Test
    public void searchFor() {
        searchForArrayIndex.parse(new int[]{12,17,24,32,14});
        String actual = searchForArrayIndex.searchFor(32);
        String expected = "3";
        assertEquals(expected, actual);
    }

    @Test
    public void searchFor2() {
        searchForArrayIndex.parse(new int[]{12,17,24,32,14});
        String actual = searchForArrayIndex.searchFor(23);
        String expected = "Not available";
        assertEquals(expected, actual);
    }
}