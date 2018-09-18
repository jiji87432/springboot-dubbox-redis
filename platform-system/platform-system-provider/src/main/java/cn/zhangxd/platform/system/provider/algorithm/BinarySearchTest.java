package cn.zhangxd.platform.system.provider.algorithm;

/**
 * @author zhangyongji
 * @since 2018/8/19.
 */
public class BinarySearchTest {

    public static void main(String[] args) {
        int[] arr = {6, 12, 33, 87, 90, 97, 108, 561};
        System.out.println("递归查找：" + binarySearch(arr, 87, 0, arr.length - 1));
        System.out.println("for查找：" + binarySearchTow(arr, 87));

        String s="jiji";
        s.equals("");
    }

    public static int binarySearch(int[] arr, int data, int low, int high) {
        if (low > high || data > arr[high] || data < arr[low]) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (data < arr[mid]) {
            return binarySearch(arr, data, 0, mid - 1);
        } else if (data > arr[mid]) {
            return binarySearch(arr, data, mid + 1, high);
        } else {
            return mid;
        }
    }

    private static int binarySearchTow(int[] arr, int data) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (data < arr[mid]) {
                high = mid - 1;
            } else if (data > arr[mid]) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
