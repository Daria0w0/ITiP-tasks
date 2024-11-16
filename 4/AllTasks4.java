//https://github.com/Daria0w0/ITiP-tasks

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllTasks4 {
    public static void main(String[] args) {
        System.out.println("Task 1: " + nonRepeat("aaaabbbbc"));  //Task 1

        System.out.println("\n");                   //Task 2
        System.out.println("Task 2: " + bruteForce(2, 6));
        System.out.println("Task 2: " + bruteForce(2, 2));
        System.out.println("Task 2: " + bruteForce(5, 3));

        System.out.println("\n");                   //Task 3
        int[] numbers = {0, 31, 28, 10, 29};
        String key = "MKIIT";
        System.out.println("Task 3: " + encode(numbers, key));
        System.out.println("Task 3: " + Arrays.toString(decode("MTUCI", key)));

        System.out.println("\n");                   //Task 4
        System.out.println("Task 4: " + split("((())())(()(()()))"));

        System.out.println("\n");                   //Task 5
        System.out.println("Task 5: " + shortHand("abbccc"));

        System.out.println("\n");                   //Task 6
        System.out.println("Task 6: " + convertToRome(1234));

        System.err.println("\n");                   //Task 7
        System.out.println("Task 7: " + uniqueSubstring("31312131"));

        System.out.println("\n"); 
        int[][] labyrinth1 = {                       //Task 8
            {1, 3, 1},
            {1, -1, 1},
            {4, 2, 1}
        };

        int[][] labyrinth2 = {
            {2, -7, 3},
            {-4, -1, 8},
            {4, 5, 9}
        };

        System.out.println("Task 8: " + labirint(labyrinth1));
        System.out.println("Task 8: " + labirint(labyrinth2));

        System.out.println("\n");                   //Task 9
        System.out.println("Task 9: " + numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println("Task 9: " + numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));
    
        System.out.println("\n");                   //Task 10
        System.out.println("Task 10: " + fibString("CCCABDD"));
        System.out.println("Task 10: " + fibString("ABCDDDDD") );
    }

    public static String nonRepeat(String s1) {                 //Task 1
        String a = "";
        for (int i = 0; i< s1.length(); i++) {
            String symb = s1.charAt(i) + "";
            int k = s1.length() - s1.replace(symb, "").length();
            if (k <= 3) {
                a += symb;
            }
        }
        if (a.equals(s1)) {
            return a;
        } else {
            return nonRepeat(a);
        }
    }

    public static List<String> bruteForce(int n, int k) {               //Task 2
        List<String> result = new ArrayList<>();
        generateCombinations("", n, k, result);
        return result;
    }

    private static void generateCombinations(String prefix, int n, int k, List<String> result) {
        if (prefix.length() == n) {
            result.add(prefix); 
            return; 
        }
        for (int i = 0; i < k; i++) {
            if (!prefix.contains(String.valueOf(i))) {
                generateCombinations(prefix + i, n, k, result);
            }
        }
    }    

    public static int[] decode(String str, String key) { // Task 3.1 
        int[] o = new int[str.length()]; 
        for (int i = 0; i < str.length(); i++) { 
            int sym_s = str.charAt(i); 
            int sym_key = key.charAt(i); 
            o[i] = sym_s ^ sym_key; 
        } 
        return o; 
    } 
 
    public static String encode(int[] l, String key) { // Task 3.2 
        String o = ""; 
        for (int i = 0; i < l.length; i++) { 
            int sym_l = l[i]; 
            int sym_key = key.charAt(i); 
            o += (char) (sym_l ^ sym_key); 
        } 
        return o; 
    }
    
    public static List<String> split(String str) {        //Task 4
        int balance = 0;
        String s = "";
        List<String> clusters = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                balance++;
                s += str.charAt(i);
            } else if (str.charAt(i) == ')') {
                balance--;
                s += str.charAt(i);
            }
            if (balance == 0) {
                clusters.add(s);
                s = "";
            }
        }
        return clusters;

    }

    public static String shortHand(String str) {                 //Task 5
        int count = 1;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= str.length() ; i++) {
            if (i < str.length() && str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                result.append(str.charAt(i - 1));
                if (count > 1) {
                    result.append("*").append(count);
                }
                count = 1;
            }
        }
        return result.toString();
    } 

    public static String convertToRome(int a) {                   //Task 6
        String[] thousands = {"", "M", "MM", "MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return thousands[a / 1000] + hundreds[(a % 1000) / 100] + tens[(a % 100) / 10] + units[a % 10];
    }

    public static String uniqueSubstring(String s) { // Task 7 
        String s_even = ""; // чёт 
        String s_odd = ""; // нечёт 
        for (int i = 0; i < s.length(); i += 2) { 
            s_even += s.charAt(i); 
            s_odd += s.charAt(i + 1); 
        } 
 
        int max_even = 0; 
        String maxB_even = ""; 
        for (int i = 0; i < s_even.length(); i++) { 
            int k = s_even.length() - s_even.replace(s_even.charAt(i) + "", "").length(); 
            if (k > max_even) { 
                max_even = k; 
                maxB_even = s_even.charAt(i) + ""; 
            } 
        } 
        int first_max_even = s_even.indexOf(maxB_even); 
 
        int max_odd = 0; 
        String maxB_odd = ""; 
        for (int i = 0; i < s_odd.length(); i++) { 
            int k = s_odd.length() - s_odd.replace(s_odd.charAt(i) + "", "").length(); 
            if (k > max_odd) { 
                max_odd = k; 
                maxB_odd = s_odd.charAt(i) + ""; 
            } 
        } 
        int first_max_odd = s_odd.indexOf(maxB_odd); 
 
        if (max_even > max_odd) { 
            return "чёт"; 
        } 
        if (max_even < max_odd) { 
            return "нечёт"; 
        } else { 
            if (first_max_even < first_max_odd) { 
                return "чёт"; 
            } else { 
                return "нечёт"; 
            } 
        } 
    }
    
    public static List<String> labirint(int[][] matrix) {               //Task 8
        int n = matrix.length;
        int[][] dp = new int[n][n];
        String[][] path = new String[n][n];

        // Инициализация dp и path
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                path[i][j] = "";
            }
        }

        // Начальная точка
        if (matrix[n - 1][n - 1] >= 0) {
            dp[n - 1][n - 1] = matrix[n - 1][n - 1];
            path[n - 1][n - 1] = String.valueOf(matrix[n - 1][n - 1]);
        }

        // Заполнение dp и path
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] < 0) continue; // Стена

                if (i < n - 1 && dp[i + 1][j] != Integer.MAX_VALUE) {
                    int cost = dp[i + 1][j] + matrix[i][j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        path[i][j] = path[i + 1][j] + "-" + matrix[i][j];
                    }
                }

                if (j < n - 1 && dp[i][j + 1] != Integer.MAX_VALUE) {
                    int cost = dp[i][j + 1] + matrix[i][j];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        path[i][j] = path[i][j + 1] + "-" + matrix[i][j];
                    }
                }
            }
        }

        // Проверка результата
        if (dp[0][0] == Integer.MAX_VALUE) {
            List<String> result = new ArrayList<>();
            result.add("Прохода нет");
            return result;
        } else {
            List<String> result = new ArrayList<>();
            result.add(path[0][0]);
            result.add(String.valueOf(dp[0][0]));
            return result;
        }
    }

    public static String numericOrder(String str) {                        //Task 9
        StringBuilder result = new StringBuilder();

        String[] words = str.split(" ");
        Map<Integer, String> wordMap = new HashMap<>();
        for (String word : words) {
            int index = Integer.parseInt(word.replaceAll("[^0-9]", ""));
            String cleanWord = word.replaceAll("[0-9]", "");
            wordMap.put(index, cleanWord);
        }
        List<Integer> sortKey = new ArrayList<>(wordMap.keySet());
        Collections.sort(sortKey);

        for (int key : sortKey) {
            result.append(wordMap.get(key)).append(" ");
        }

        return result.toString().trim();
    }

    public static boolean fibString(String str) {                           //Task 10
        int maxCount = 0;
        for (int i = 0; i < str.length(); i++) {
            String symb = str.charAt(i) + "";
            int k = str.length() - str.replace(symb, "").length();
            if (k > 1) {
                maxCount = Math.max(maxCount, k);
            }
        }
        return isFibonacci(maxCount);
    }

    private static boolean isFibonacci(int n) {
        int a = 0, b = 1;
        while (b < n) {
            int temp = b;
            b += a;
            a = temp;
        }
        return b == n;
    }
    
}
