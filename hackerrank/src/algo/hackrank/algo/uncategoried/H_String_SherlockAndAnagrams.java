package algo.hackrank.algo.uncategoried;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by kenvi on 16/6/29.
 */
public class H_String_SherlockAndAnagrams {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int t = 0; t < T; t++) {

            String line = scanner.nextLine();

            int count = 0;
            String sub1, sub2;
            for (int len = 1; len < line.length() ; len++) {
                for (int i = 0; i < line.length() - len; i++) {
                    sub1 = line.substring(i, i + len);
                    for (int j = i + 1; j < line.length() - len + 1; j++) {
                        sub2 = line.substring(j, j + len);
                        boolean isAnagrams = isAnagrams(sub1, sub2) ;
//                        System.out.println(String.format("%s-%s:%s",sub1, sub2, isAnagrams));
                        if(isAnagrams) count++;
                    }
                }
            }
            System.out.println(count);

        }
    }

    public static boolean isAnagrams(String str1, String str2) {
        Map<Character, Integer> str1Cnt = new HashMap<>();
        Map<Character, Integer> str2Cnt = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            Integer v1 = str1Cnt.get(str1.charAt(i));
            if(v1 == null) {
                str1Cnt.put(str1.charAt(i), 1);
            }else {
                str1Cnt.put(str1.charAt(i), v1+1);
            }

            Integer v2 = str2Cnt.get(str2.charAt(i));
            if(v2 == null) {
                str2Cnt.put(str2.charAt(i), 1);
            }else {
                str2Cnt.put(str2.charAt(i), v2+1);
            }
        }

        if(str1Cnt.size() != str2Cnt.size()) return false;

        for (Map.Entry<Character,Integer> entry : str1Cnt.entrySet()) {
            Character key = entry.getKey();
            Integer v1 = entry.getValue();
            Integer v2 = str2Cnt.get(key);
            if(v2 == null || v1.intValue() != v2.intValue()) return false;
        }
        return true;
    }


}
