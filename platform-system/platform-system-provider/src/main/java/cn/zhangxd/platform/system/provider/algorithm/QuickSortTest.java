package cn.zhangxd.platform.system.provider.algorithm;

import java.util.Arrays;

/**
 * @author zhangyongji
 * @since 2018/8/19.
 */
public class QuickSortTest {

    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19};
//        sortTest(arr, 0, arr.length - 1);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }

        Arrays.sort(arr);
//        Collections.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void sortTest(int[] arr, int startIndex, int endIndex) {

        if (startIndex > endIndex) {
            return;
        }

        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;

        while (left < right) {
            while (pivot <= arr[right] && left < right) {
                right--;
            }
            while (pivot >= arr[left] && left < right) {
                left++;
            }
            if (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        int temp = arr[left];
        arr[left] = arr[startIndex];
        arr[startIndex] = temp;

        sortTest(arr, startIndex, left - 1);
        sortTest(arr, left + 1, endIndex);

    }
}
