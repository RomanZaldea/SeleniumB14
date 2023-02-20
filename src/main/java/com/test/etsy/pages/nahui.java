package com.test.etsy.pages;

import java.util.HashMap;
import java.util.Map;

public class nahui {
    public static void main(String[] args) {
        String str = "ddiigg7716";
        Map<Character, Integer> count = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            if (!count.containsKey(str.charAt(i))) {
                count.put(str.charAt(i), 1);
            } else if (count.containsKey(str.charAt(i))) {
                count.put(str.charAt(i), count.get(str.charAt(i)) + 1);
            }
        }

        System.out.println(count);
    }


    public static class nahui2 {
        public static void main(String[] args) {
            String str = "I love Java";
            String str2 = "";

            String[] words = str.split(" ");

            for (String word : words) {
                String everyWordReversed = "";
                for (int i = word.length() - 1; i >= 0; i--) {
                    everyWordReversed = everyWordReversed + word.charAt(i);
                }
                str2 = str2 + " " + everyWordReversed;
            }

            System.out.println(str2);
        }
    }

    public static class nahui3 {
        public static void main(String[] args) {
            Map<Character, Integer> map = new HashMap<>();
            int count = 1;
            for (int i = 'a'; i < 'z' + 1; i++) {
                char ch = (char) i;
                map.put(ch, count);
                count++;
            }
            for (Map.Entry<Character, Integer> pair : map.entrySet()) {
                System.out.println(pair.getKey() + ", " + pair.getValue());
            }
        }
    }

    public static class nahui4 {
        public static void main(String[] args) {
            int n = 15;

            for (int i = 0; i <= n; i++) {

                for (int j = 1; j <= n - i; j++) {
                    System.out.print(" ");
                }
                for (int k = 0; k <= i; k++) {
                    System.out.print("**");
                }
                System.out.println("");
            }
        }
    }
}
