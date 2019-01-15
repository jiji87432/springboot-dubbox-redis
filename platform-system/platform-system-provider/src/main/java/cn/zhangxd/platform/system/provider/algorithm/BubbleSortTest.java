package cn.zhangxd.platform.system.provider.algorithm;

/**
 * @author zhangyongji
 * @since 2018/8/19.
 */
public class BubbleSortTest {

    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 2, 3, 4, 5, 6, 7};
        insertSort(arr, arr.length);
    }

    public static void bubbleSort(int[] arr) {
        System.out.println("排序前数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        boolean isSorted = true;
        int sortBoder = arr.length - 1;
        int lastExchangeIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < sortBoder; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted = false;
                    lastExchangeIndex = j;
                }
            }
            sortBoder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
        }
        System.out.println();
        System.out.println("排序后的数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void insertSort(int[] arr, int n) {
        System.out.println("排序前数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n; i++) {
            int insertValue = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > insertValue) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = insertValue;
        }

        System.out.println();
        System.out.println("排序后的数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public void selectSort(int[] arr, int n) {
        if (n <= 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

    }
}
