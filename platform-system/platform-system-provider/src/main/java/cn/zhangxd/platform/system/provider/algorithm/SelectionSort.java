package cn.zhangxd.platform.system.provider.algorithm;

/**
 * @author zhangyongji
 * @since 2018/8/20.
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 2, 3, 4, 5, 6, 7};
        System.out.println("排序前数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        selectionSort(arr);
        System.out.println();
        System.out.println("排序后数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }

    }

    private static int[] selectionSort(int[] arr) {

        if (arr.length == 0) {
            return arr;
        }

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
}
