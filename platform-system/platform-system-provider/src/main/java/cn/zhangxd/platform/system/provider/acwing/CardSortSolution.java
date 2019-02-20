package cn.zhangxd.platform.system.provider.acwing;

import java.util.Arrays;

/**
 * @author zhangyongji
 * @since 2019-02-12.
 * <p>
 * <p>
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * <p>
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，大小王可以看做任意数字。
 * <p>
 * 为了方便，大小王均以0来表示，并且假设这副牌中大小王均有两张
 * <p>
 * refrence URL: https://www.nowcoder.com/questionTerminal/762836f4d43d43ca9deb273b3de8e1f4
 * refrence URL: http://wiki.jikexueyuan.com/project/for-offer/question-forty-four.html
 */
public class CardSortSolution {
    public static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5) {
            return false;
        }
        //先排序，否则计算间隔的时候可能会出现负值，比较麻烦
        Arrays.sort(numbers);
        int totalGap = 0;
        //计算大小王的数量
        int countZero = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                countZero++;
                continue;
            }
            //计算两数之间的间隔
            if (i < numbers.length - 1) {
                int gap = numbers[i + 1] - numbers[i] - 1;
                //如果出现对子，如2 2，则gap为-1，直接返回false
                if (gap < 0) {
                    return false;
                }
                totalGap += gap;
            }
        }
        //所有数间隔大于王数量，就返回false
        if (totalGap > countZero) {
            return false;
        }
        return true;
    }

    public static boolean isCOntinous02(int[] numbers) {

        if (numbers == null || numbers.length <= 4) {
            return false;
        }
        Arrays.sort(numbers);
        int count = 0;
        for (int i : numbers) {
            if (i == 0) {
                count++;
            }
        }
        //不含0，即不包含大小王
        if (count == 0) {
            if (isSequence(numbers)) {
                return true;
            } else {
                return false;
            }
        }
        //包含大小王
        else {
            if (count == 4) {
                return true;
            }
            int sum = 0;
            //计算间隔数
            for (int i = count + 1; i < numbers.length; i++) {
                int gap = numbers[i] - numbers[i - 1] - 1;
                if (gap < 0) {
                    return false;
                }
                sum += gap;
            }
            if (sum > count) {
                return false;
            }
            return true;
        }
    }

    private static boolean isSequence(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] - numbers[i - 1] != 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] numbers1 = {1, 3, 2, 5, 4};
        System.out.println("numbers1=" + isContinuous(numbers1));
        int[] numbers2 = {1, 3, 2, 6, 4};
        System.out.println("numbers2=" + isContinuous(numbers2));
        int[] numbers3 = {0, 3, 2, 6, 4};
        System.out.println("numbers3=" + isContinuous(numbers3));
        int[] numbers4 = {0, 3, 1, 6, 4};
        System.out.println("numbers4=" + isContinuous(numbers4));
        int[] numbers5 = {1, 3, 0, 5, 0};
        System.out.println("numbers5=" + isContinuous(numbers5));
        int[] numbers6 = {1, 3, 0, 7, 0};
        System.out.println("numbers6=" + isContinuous(numbers6));
        int[] numbers7 = {1, 0, 0, 5, 0};
        System.out.println("numbers7=" + isContinuous(numbers7));
        int[] numbers8 = {1, 0, 0, 7, 0};
        System.out.println("numbers8=" + isContinuous(numbers8));
        int[] numbers9 = {3, 0, 0, 0, 0};
        System.out.println("numbers9=" + isContinuous(numbers9));
        int[] numbers10 = {0, 0, 0, 0, 0};
        System.out.println("numbers10=" + isContinuous(numbers10));
        int[] numbers11 = {1, 0, 0, 1, 0};
        System.out.println("numbers11=" + isContinuous(numbers11));
        int[] numbers12 = {1, 11, 0, 12, 0};
        System.out.println("numbers12=" + isContinuous(numbers12));
    }
}
