package cn.zhangxd.platform.system.provider.conllection;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangyongji
 * @since 2018/8/8.
 */
public class CountStringAndSort {

    public static Map<Character, Integer> getMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            Integer count = map.get(character);
            map.put(character, count == null ? 1 : count + 1);
        }
        return map;
    }

    public void getStringNum(String s, String partern) {
        String[] array = s.split(partern);
        if (array != null) {
            for (int i = 0; i < array.length; i++) {
                System.out.println(array[i]);
            }
            System.out.println(array.length - 1);

        }
//        Map<String, Integer> map = new HashMap<String, Integer>();
//        for (int j = 0; j < words.length; j++) {
//
//            Integer count = map.get(words[j]);
//
//            if (count == null) {
//                map.put(words[j], 1);
//            } else {
//                map.put(words[j], ++count);
//            }
//        }
//
//        for (Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + entry.getValue());
//        }

    }

    public static int counter(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "AADDDDAADDAADDA";
//        System.out.println(getMap(str));
//        System.out.println(counter(str, 'D'));
        CountStringAndSort countStringAndSort = new CountStringAndSort();
        countStringAndSort.getStringNum(str, "DD");
    }

}
