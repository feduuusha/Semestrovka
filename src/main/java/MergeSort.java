public class MergeSort {
    private static int counterOfIterations;
    public static int[] sort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int[] left = new int[array.length / 2];
        int[] right = new int[array.length - array.length / 2];
        System.arraycopy(array, 0, left, 0, array.length / 2);
        System.arraycopy(array, array.length / 2, right, 0, array.length - array.length / 2);
        return connectArrays(sort(left), sort(right));
    }

    private static int[] connectArrays(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0;
        int j = 0;
        int size = 0;
        while (i < left.length && j < right.length) {
            counterOfIterations++;
            if (left[i] < right[j]) result[size++] = left[i++];
            else result[size++] = right[j++];
        }
        while (i < left.length) {
            counterOfIterations++;
            result[size++] = left[i++];
        }
        while (j < right.length) {
            counterOfIterations++;
            result[size++] = right[j++];
        }
        return result;
    }

    public static int getCounterOfIterations() {
        int temp = counterOfIterations;
        counterOfIterations = 0;
        return temp;
    }
}
