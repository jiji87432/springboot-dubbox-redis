package cn.zhangxd.platform.system.provider.algorithm;

/**
 * @author zhangyongji
 * @since 2018/9/6.
 */
public class BubbleSortTest02 {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 2};
        sort(arr);
        System.out.println("排序后的数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void sort(int[] arr) {
        int sortBorder = arr.length - 1;
        int exchangeIndex = 0;
        boolean isSorted = true;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < sortBorder; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSorted = false;
                    exchangeIndex = j;
                }
            }
            sortBorder = exchangeIndex;
            if (isSorted) {
                break;
            }
        }
    }
}
