package cn.zhangxd.platform.system.provider.algorithm;

/**
 * @author zhangyongji
 * @since 2018/8/20.
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {9, 3, 8, 2, 87, 4, 5, 6, 7};
        System.out.println("排序前数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
//        insertSort(arr);
//        ShellSort(arr);
        insertSortTow(arr);
        System.out.println();
        System.out.println("排序后数组为：");
        for (int num : arr) {
            System.out.print(num + " ");
        }

    }

    private static void insertSortTow(int[] arr) {
        int j;
        for (int p = 1; p < arr.length; p++) {
            int temp = arr[p];
            for (j = p; j > 0 && temp < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    private static void insertSort(int[] arr) {
        int length = arr.length;
        int insertNum;
        for (int i = 1; i < length; i++) {
            int j = i - 1;
            insertNum = arr[i];
            while (j >= 0 && arr[j] > insertNum) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = insertNum;
        }
    }

    private static void ShellSort(int[] a) {
        int len = a.length;//单独把数组长度拿出来，提高效率
        while (len != 0) {
            len = len / 2;
            for (int i = 0; i < len; i++) {//分组
                for (int j = i + len; j < a.length; j += len) {//元素从第二个开始
                    int k = j - len;//k为有序序列最后一位的位数
                    int temp = a[j];//要插入的元素
                    while (k >= 0 && temp < a[k]) {//从后往前遍历
                        a[k + len] = a[k];
                        k -= len;//向后移动len位
                    }
                    a[k + len] = temp;
                }
            }
        }
    }
}
