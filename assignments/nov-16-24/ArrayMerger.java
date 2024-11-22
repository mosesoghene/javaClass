import java.util.Arrays;

public class ArrayMerger {
    public static void main(String[] args) {
        int[] firstLArray = {11, 20, 13};
        int[] secondArray = {45, 3, 1, 12, 5, 23};
        
        int[] mergedArray = mergeArray(firstLArray, secondArray);
        System.out.println(Arrays.toString(mergedArray));
    }
    
    public static int[] mergeArray(int a[], int b[]) {
        int[] merged = new int[a.length + b.length];
        
        for (int index = 0; index < a.length; index++) {
            merged[index] = a[index];
        }
        
        for (int index = 0; index < b.length; index++) {
            merged[merged.length - b.length + index ] = b[index];
        }
        
        return merged;
    }
}
