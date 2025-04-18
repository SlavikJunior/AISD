package sorting;

import java.util.Arrays;

public class Main3 {

    public static void main(String[] args) {
        int[] ints1 = {1, 4, 7 ,9, 11, 12, 8, 4, 6};
        int[] ints2 = {0, 2, 3, 5, 10, 13 ,15 ,11, 12};
        int[] merge = merge(ints1, ints2);
        System.out.println(Arrays.toString(merge));
//        int[] array = {1, 0, - 1, 4, 2, 6, 5, 3, 8, 7, 9, 12, 11};
//        int[] result = mergeSorting(array);
//        System.out.println(Arrays.toString(result));
    }

    public static int[] mergeSorting(int[] ints) {
        int len = ints.length;
        if (len <= 1)
            return ints;
        int[] ints1 = new int[len / 2];
        for (int i = 0; i < (len / 2); i++) {
            ints1[i] = ints[i];
        }
        int[] ints2 = new int[len - len / 2];
        for (int i = len / 2, j = 0; i < len; i++, j++) {
            ints2[j] = ints[i];
        }
        return merge(mergeSorting(ints1), mergeSorting(ints2));
    }

    public static int[] merge(int[] ints1, int[] ints2) {
        int len1 = ints1.length;
        int len2 = ints2.length;

        if (len1 == 0)
            return ints2;

        if (len2 == 0)
            return ints1;

        int id1 = 0, id2 = 0;
        int[] result = new int[len1 + len2];
        for (int i = 0; i < result.length; i++) {
            if (id1 == len1) {
                for(int j = id2; j < len2; j++)
                    result[i] = ints2[j];
                break;
            }
            else if (id2 == len2) {
                for(int j = id1; j < len1; j++)
                    result[i] = ints1[j];
                break;
            }
            if (ints1[id1] <= ints2[id2])
                result[i] = ints1[id1++];
            else
                result[i] = ints2[id2++];
        }
        return result;
    }
}
