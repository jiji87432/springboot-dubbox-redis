package cn.zhangxd.platform.system.provider.javabasetype;

/**
 * @author zhangyongji
 * @since 2018/8/19.
 */
public class IntegerTest {

    public static void main(String[] args) {
//        int z = 127;
//        Integer a = 127;
//        Integer b = Integer.valueOf(127);
//        Integer f = new Integer(127);
//        Integer g = new Integer(127);
//
//        int y = 128;
//        Integer c = 128;
//        Integer d = Integer.valueOf(128);
//        Integer e = new Integer(128);
//        Integer h = new Integer(128);
//
//        System.out.println("z==a结果：" + (z == a));
//        System.out.println("z==b结果：" + (z == b));
//        System.out.println("z==f结果：" + (z == f));
//        System.out.println("a==b结果：" + (a == b));
//        System.out.println("a==f结果：" + (a == f));
//        System.out.println("f==g结果：" + (f == g));
//
//        System.out.println("y==c结果：" + (y == c));
//        System.out.println("y==d结果：" + (y == d));
//        System.out.println("y==e结果：" + (y == e));
//        System.out.println("c==d结果：" + (c == d));
//        System.out.println("c==e结果：" + (c == e));
//        System.out.println("e==h结果：" + (e == h));

        Integer number = 10;//自动装箱
        int number2 = 10;
        Integer number3 = 10;
        System.out.println(number == number2);//自动拆箱
        System.out.println(number + number3);//自动拆箱
        System.out.println(number.equals(number2));//自动装箱

    }
}
