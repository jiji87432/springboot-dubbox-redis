package cn.zhangxd.platform.system.provider.algorithm;

/**
 * @author zhangyongji
 * @since 2018/9/6.
 */
public class BubbleSortTest02 {
    public static void main(String[] args) {
        int[] arr = {8, 7, 4, 2, 1, 5};
        boolean flag = IsOrder(arr);
        System.out.println("排序后的数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("数组中是否有三个相邻的数连续：" + flag);
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

    private static boolean IsOrder(int[] arr) {
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int step = i + 2; step < arr.length; step += 2) {
                System.out.println("下标【" + i + "】" + arr[i] + "和" + "下标【" + step + "】" + arr[step] + "比较");
                System.out.println("arr[step] - arr[i] =" + (arr[step] - arr[i]));
                if (arr[step] - arr[i] == 2) {
                    if (arr[step] - arr[step - 1] == 1) {
                        return true;
                    }
                } else {
                    break;
                }
            }
        }
        return false;
    }
}
