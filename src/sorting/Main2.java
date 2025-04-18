package sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива!");
        int len = scanner.nextInt();
        System.out.println("Введите минимальное и максимальное значение элемента!");
        int min = scanner.nextInt();
        int max = scanner.nextInt();
        int p = max - min + 1;
        Random random = new Random();
        int[] ints1 = new int[len];
        for (int i = 0; i < len; i++) {
            ints1[i] = random.nextInt(min, max + 1);
        }
        System.out.println("Исходный первый массив: " + Arrays.toString(ints1));
        int[] cntOfElements = countOfElements(ints1, min, max, p);
        int[] result1 = countsSorting(cntOfElements, len, p);
        System.out.println("Отсортированный первый массив: " + Arrays.toString(result1));

        int[] ints2 = new int[len];
        for (int i = 0; i < len; i++) {
            ints2[i] = random.nextInt(min, max + 1);
        }
        System.out.println("Исходный второй массив: " + Arrays.toString(ints2));
        int[] result2 = selectionSort(ints2, len);
        System.out.println("Отсортированный второй массив: " + Arrays.toString(result2));

        int[] ints3 = new int[len];
        for (int i = 0; i < len; i++) {
            ints3[i] = random.nextInt(min, max + 1);
        }
        System.out.println("Исходный второй массив: " + Arrays.toString(ints3));
        int[] result3 = bubbleSort(ints3, len);
        System.out.println("Отсортированный третий массив: " + Arrays.toString(result3));
    }

    public static int[] bubbleSort(int[] ints, int len) {
        for (int i = len - 1; i >= 0; i--) {
            boolean isSwapped = false;
            for (int j = 0; j < i; j++) {
                if (ints[j] > ints[j + 1]) {
                    ints[j] ^= ints[j + 1];
                    ints[j + 1] ^= ints[j];
                    ints[j] ^= ints[j + 1];
                    isSwapped = true;
                }
            }
            if (!isSwapped) break;
        }
        return ints;
    }

    public static int[] selectionSort(int[] ints, int len) {
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (ints[i] > ints[j]) {
                    ints[i] ^= ints[j];
                    ints[j] ^= ints[i];
                    ints[i] ^= ints[j];
                }
            }
        }
        return ints;
    }

    public static int[] countsSorting(int[] cntOfElements, int len, int p) {
        int[] sortedArray = new int[len];
        for (int i = 0, cur = 0; i < p; i++) {
            for (int j = 0; j < cntOfElements[i]; j++, cur++) {
                sortedArray[cur] = i;
            }
        }
        return sortedArray;
    }

    public static int[] countOfElements(int[] ints, int min, int max, int p) {
        int[] cntOfElements = new int[p];
        for (int i = 0; i < ints.length; i++) {
            cntOfElements[ints[i]]++;
        }
        return cntOfElements;
    }
}
