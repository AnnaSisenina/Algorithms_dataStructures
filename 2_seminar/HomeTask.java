public class HomeTask{

    public static void main(String[] args) {
        // [1 2 3 2 1 2 3 4 4 4 2 3 3 1 2 3 4 4 2 1 3 4 2 1 1]
        int [] array = new int[] { 2, -3, 2, 1};
        countingSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] +" ");
        }
        
    }

    /**
     * Реализовать сортировку подсчетом.
     *
     */
    static void countingSort(int[] array) {
        
        int max = array [0];
        int min = array [0];
        int length = array.length;
        for (int i = 1; i < length; i++) {
            if (array[i] > max)
            max = array[i];
            if (array[i] < min)
            min = array[i];
        }
        
        int[] indexArray = new int[max + min * (-1) + 1];
        for (int i = 0; i < length; i++) {
            indexArray[array[i] - min]++;
        }
        int index = 0;
        for (int i = 0; i < indexArray.length; i++) {
            for (int j = 0; j < indexArray[i]; j++) {
                array[index] = i + min;
                index++;
            }
        }

    }

}
