package com.algo;

/**
 * @author zhangyongji
 * @since 2019-05-21.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};

//        quickSort(arr, 0, arr.length - 1);
        quickSortTow(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void quickSort(int[] arr, int start, int end) {
        if (null == arr || arr.length <= 0) {
            return;
        }
        if (start > end) {
            return;
        }

        int pivote = arr[start];
        int left = start;
        int right = end;

        while (left < right) {
            // 先从右边开始找
            while (left < right && arr[right] >= pivote) {
                right--;
            }

            // 再从左边开始找
            while (left < right && arr[left] <= pivote) {
                left++;
            }

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        int temp = arr[right];
        arr[right] = arr[start];
        arr[start] = temp;

        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);
    }


    private static void quickSortTow(int[] arr, int start, int end) {
        if (null == arr || arr.length <= 0) {
            return;
        }
        if (start > end) {
            return;
        }

        int midIndex = partitionTow(arr, start, end);
        quickSort(arr, start, midIndex - 1);
        quickSort(arr, midIndex + 1, end);
    }


    private static int getMidIndex(int[] arr, int start, int end) {
        int pivot = arr[start];
        int left = start;
        int right = end;

        while (left < right) {
            // 先从右边开始找
            while (left < right && arr[right] >= pivot) {
                right--;
            }

            // 再从左边开始找
            while (left < right && arr[left] <= pivot) {
                left++;
            }

            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        int temp = arr[left];
        arr[left] = arr[start];
        arr[start] = temp;
//        System.out.println("pivot=" + pivot);
//        System.out.println("i=" + left);
        return left;
    }


    private static int partition(int[] a, int startIndex, int endIndex) {
        int pivot = a[endIndex];
        int i = startIndex;
        for (int j = startIndex; j < endIndex; ++j) {
//            System.out.println("a[j]=" + a[j]);
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        int tmp = a[i];
        a[i] = a[endIndex];
        a[endIndex] = tmp;
//        System.out.println("pivot=" + pivot);
//        System.out.println("i=" + i);
        return i;
    }

    private static int partitionTow(int[] a, int startIndex, int endIndex) {
        int pivot = a[endIndex];
        int i = startIndex;
        for (int j = startIndex; j < endIndex; j++) {
            if (a[j] < pivot) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
            }
        }
        int tmp = a[i];
        a[i] = a[endIndex];
        a[endIndex] = tmp;

        return i;
    }

}
