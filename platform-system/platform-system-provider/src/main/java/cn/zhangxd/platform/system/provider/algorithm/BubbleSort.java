package cn.zhangxd.platform.system.provider.algorithm;

/*
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 2, 3, 4, 5, 6, 7};
//        bubbleSortOne(arr);
//        bubbleSortTow(arr);
        bubbleSortThree(arr);
    }

    public static void bubbleSortOne(int[] arr) {
        int count = 0;
        int temp = 0;
        System.out.println("版本一排序前数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        //外层循环控制排序趟数
        for (int i = 0; i < arr.length - 1; i++) {
            //内层循环控制每一趟排序多少次
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
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

    public static void bubbleSortTow(int[] arr) {
        System.out.println();
        System.out.println("版本二排序前数组为：");
        int count = 0;
        int temp = 0;
        for (int num : arr) {
            System.out.print(num + " ");
        }

        //外层循环控制排序趟数
        for (int i = 0; i < arr.length - 1; i++) {
            //有序标记
            boolean isSorted = true;
            //内层循环控制每一趟排序多少次
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
            count++;
        }
        System.out.println();
        System.out.println("排数趟数：" + count);
        System.out.println("版本二排序后的数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    public static void bubbleSortThree(int[] arr) {
        System.out.println();
        System.out.println("版本三排序前数组为：");
        int count = 0;
        int temp = 0;
        for (int num : arr) {
            System.out.print(num + " ");
        }
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;
        //无序数列的边界，每次比较只需要比到这里为止
        int sortBoder = arr.length - 1;
        //外层循环控制排序趟数
        for (int i = 0; i < arr.length - 1; i++) {
            //有序标记
            boolean isSorted = true;

            //内层循环控制每一趟排序多少次
            for (int j = 0; j < sortBoder; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    //有元素交换，所以不是有序，标记变为false
                    isSorted = false;
                    //把无序数列的边界更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBoder = lastExchangeIndex;
            if (isSorted) {
                break;
            }
            count++;
        }
        System.out.println("排数趟数：" + count);
        System.out.println("版本三排序后的数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}