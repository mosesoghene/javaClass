package dsa;

public class MySet {
    private final MyArrayList set = new MyArrayList();

    public void add(String element){
        if(!set.contains(element)) set.add(element);
    }

    public int size(){
        return set.size();
    }

    public String toString(){
        return set.toString();
    }

    public String get(int index) throws Exception {
        return set.get(index);
    }

    public void remove(String element) throws Exception {
        set.remove(element);
    }

    public boolean contains(String element) {
        return set.contains(element);
    }

    public int indexOf(String element) {
        return set.findIndexOf(element);
    }
}
