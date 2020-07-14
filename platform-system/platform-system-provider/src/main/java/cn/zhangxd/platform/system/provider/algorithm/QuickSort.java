package cn.zhangxd.platform.system.provider.algorithm;

/**
 * @author zhangyongji
 * @since 2018/2/7.
 * <p>
 * http://blog.csdn.net/as02446418/article/details/47395867
 */
public class QuickSort {

    public static void quickSort(int[] arr, int startIndex, int endIndex) {

        if (startIndex > endIndex) {
            return;
        }
        int left = startIndex;
        int right = endIndex;
        //temp就是基准位
        int pivot = arr[startIndex];

        while (left < right) {
            //先看右边，依次往左递减
            while (pivot <= arr[right] && left < right) {
                right--;
            }
            //再看左边，依次往右递增
            while (pivot >= arr[left] && left < right) {
                left++;
            }
            //如果满足条件则交换
            if (left < right) {
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }

        }
        //最后将基准为与left和right相等位置的数字交换
        int temp = arr[left];
        arr[left] = arr[startIndex];
        arr[startIndex] = temp;

        //递归调用左半数组
        quickSort(arr, startIndex, left - 1);
        //递归调用右半数组
        quickSort(arr, left + 1, endIndex);

    }

    public static int partition(int[] arr, int startIndex, int endIndex) {
        // 取第一个位置的元素作为基准元素
        int pivot = arr[startIndex];
        // 坑的位置，初始等于pivot的位置
        int index = startIndex;
        int left = startIndex;
        int right = endIndex;

        //大循环在左右指针重合或者交错时结
        while (right >= left) {
            //right指针从右向左进行比较
            while (right >= left) {
                if (arr[right] < pivot) {
                    arr[left] = arr[right];
                    index = right;
                    left++;
                    break;
                }
                right--;
            }
            //left指针从左向右进行比较
            while (right >= left) {
                if (arr[left] > pivot) {
                    arr[right] = arr[left];
                    index = left;
                    right--;
                    break;
                }
                left++;
            }
        }
        arr[index] = pivot;
        return index;
    }

    public static void quickTow(int[] arr, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return;
        }
        int pivotIndex = partition(arr, startIndex, endIndex);
        quickTow(arr, startIndex, pivotIndex - 1);
        quickTow(arr, pivotIndex + 1, endIndex);
    }

    public static void main(String[] args) {
        int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        quickSort(arr, 0, arr.length - 1);
//        quickTow(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
