package cn.zhangxd.platform.system.provider.algorithm;

/**
 * @author zhangyongji
 * @since 2018/8/17.
 */
public class CockTailSort {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6, 7, 8, 1};
//        sort(arr);
        sortTow(arr);
    }

    public static void sort(int[] arr) {
        System.out.println("版本一排序前数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        int temp = 0;
        int count = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            boolean isSorted = true;
            //奇数轮，从左向右比较和交换
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }

            isSorted = true;
            //偶数轮，从右向左比较和交换
            for (int j = arr.length - 1 - i; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
            count++;
        }

        System.out.println();
        System.out.println("排数趟数：" + count);
        System.out.println("版本一排序后的数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }


    public static void sortTow(int[] arr) {
        System.out.println("版本2排序前数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        int temp = 0;
        int count = 0;
        //记录右侧最后一次交换的位置
        int lastRightExchangeIndex = 0;
        //记录左侧最后一次交换的位置
        int lastLeftExchangeIndex = 0;
        //无序数列的右边界，每次比较只需要比到这里为止
        int rightSortBorder = arr.length - 1;
        //无序数列的左边界，每次比较只需要比到这里为止
        int leftSortBorder = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            boolean isSorted = true;
            //奇数轮，从左向右比较和交换
            for (int j = leftSortBorder; j < rightSortBorder; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                    lastRightExchangeIndex = j;
                }
            }
            rightSortBorder = lastRightExchangeIndex;
            if (isSorted) {
                break;
            }

            isSorted = true;
            //偶数轮，从右向左比较和交换
            for (int j = rightSortBorder; j > leftSortBorder; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                    lastLeftExchangeIndex = j;
                }
            }
            leftSortBorder = lastLeftExchangeIndex;
            if (isSorted) {
                break;
            }
            count++;
        }

        System.out.println();
        System.out.println("排数趟数：" + count);
        System.out.println("版本2排序后的数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
