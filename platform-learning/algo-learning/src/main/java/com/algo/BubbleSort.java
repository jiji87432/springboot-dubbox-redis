package com.algo;

/**
 * @author zhangyongji
 * @since 2019-05-17.
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {8, 7, 4, 2, 1, 5};
        sort(arr);
        System.out.println("排序后的数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    /**
     * do
     * swapped = false
     * for i = 1 to indexOfLastUnsortedElement-1
     * if leftElement > rightElement
     * swap(leftElement, rightElement)
     * swapped = true
     * while swapped
     *
     * @param arr
     */

    public static void sort(int[] arr) {
        if (null != arr && arr.length > 0) {
            // 有序区域边界
            int indexOfLastSortedElement = arr.length - 1;
            // 无序区域交换下标
            int indexOfLastUnsortedElement = 0;
            boolean isSorted = true;
            int cycNum = 0;
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < indexOfLastSortedElement; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                        isSorted = false;
                        indexOfLastUnsortedElement = j;
                    }
                }
                ++cycNum;
                indexOfLastSortedElement = indexOfLastUnsortedElement;
                if (isSorted) {
                    break;
                }
            }
            System.out.println(cycNum);
        } else {
            System.out.println("input error");
        }
    }
}
