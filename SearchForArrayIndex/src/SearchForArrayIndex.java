import java.util.ArrayList;

public class SearchForArrayIndex {
    private final ArrayList<Integer> list;

    public SearchForArrayIndex() {
        list = new ArrayList<>();
    }

    public void parse(int[] array){
        for (int number : array) {
            list.add(number);
        }
    }

    public String searchFor(int target) {
        return !list.contains(target) ?
                "Not available" :
                Integer.toString(list.indexOf(target));
    }
}
