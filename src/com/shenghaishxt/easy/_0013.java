package com.shenghaishxt.easy;

import java.util.HashMap;

public class _0013 {
    // 一次判断两个字母，遍历一遍即可
    private int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);

        int i = 0, res =0;
        while (i < s.length()) {
            if (i+2 <= s.length() && map.containsKey(s.substring(i, i+2))) {
                res += map.get(s.substring(i, i+2));
                System.out.println(res);
                i += 2;
            }
            else if (map.containsKey(s.substring(i, i+1))) {
                res += map.get(s.substring(i, i+1));
                i += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _0013 Sol = new _0013();
        System.out.println(Sol.romanToInt("LVIII"));
    }
}
