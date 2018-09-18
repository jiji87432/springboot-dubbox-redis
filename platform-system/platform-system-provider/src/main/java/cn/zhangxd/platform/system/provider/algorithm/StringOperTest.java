package cn.zhangxd.platform.system.provider.algorithm;

/**
 * @author zhangyongji
 * @since 2018/9/5.
 */
public class StringOperTest {

    public static void main(String[] args) {
        String str = "dcba";
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }
    }

    public static StringBuffer buffer(String s) {
        StringBuffer sb = new StringBuffer();
        sb.append(s);
        return sb.reverse();
    }
}
