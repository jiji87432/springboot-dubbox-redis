package com.algo;

/**
 * @author zhangyongji
 * @since 2019-08-12.
 * <p>
 * https://time.geekbang.org/column/article/41913
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {9, 2, 6, 3, 5, 7, 10, 11};
        merge_sort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void merge_sort(int[] arr, int left, int right) {
        // 终止条件
        if (left >= right) {
            return;
        }
        // 取中间值
        int mid = (left + right) / 2;
        //排序左边
        merge_sort(arr, left, mid);
        //排序右边
        merge_sort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
//        while (i <= mid) {
////            temp[k++] = arr[i++];
////        }
////        while (j <= right) {
////            temp[k++] = arr[j++];
////        }

        int start = i, end = mid;
        if (j <= right) {
            start = j;
            end = right;
        }
        while (start <= end) {
            temp[k++] = arr[start++];
        }

        for (int m = 0; m < temp.length; m++) {
            arr[left + m] = temp[m];
        }
    }
}
