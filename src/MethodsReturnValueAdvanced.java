import java.util.*;

public class MethodsReturnValueAdvanced {

    // Returns an array
    static int[] fibonacciSequence(int count) {
        int[] fib = new int[count];
        fib[0] = 0; if (count > 1) fib[1] = 1;
        for (int i = 2; i < count; i++) fib[i] = fib[i-1] + fib[i-2];
        return fib;
    }

    // Returns a String[]
    static String[] splitIntoWords(String sentence) {
        return sentence.trim().split("\\s+");
    }

    // Returns a Map (histogram)
    static Map<Character,Integer> charFrequency(String s) {
        Map<Character,Integer> map = new TreeMap<>();
        for (char c : s.toCharArray()) map.merge(c, 1, Integer::sum);
        return map;
    }

    // Chain of return values
    static double circleArea(double r)       { return Math.PI * r * r; }
    static double cylinderVolume(double r, double h) { return circleArea(r) * h; }
    static double cylinderSurface(double r, double h) {
        return 2 * circleArea(r) + 2 * Math.PI * r * h;
    }

    static int romanToInt(String s) {
        Map<Character,Integer> map = Map.of('I',1,'V',5,'X',10,'L',50,'C',100,'D',500,'M',1000);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = map.get(s.charAt(i));
            int nxt = i+1 < s.length() ? map.get(s.charAt(i+1)) : 0;
            res += val < nxt ? -val : val;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("=== Fibonacci ===");
        System.out.println(Arrays.toString(fibonacciSequence(15)));

        System.out.println("\n=== Cylinder Calculator ===");
        double r=5, h=10;
        System.out.printf("r=%.1f h=%.1f%n", r, h);
        System.out.printf("Volume : %.2f%n", cylinderVolume(r, h));
        System.out.printf("Surface: %.2f%n", cylinderSurface(r, h));

        System.out.println("\n=== Char Frequency ===");
        charFrequency("hello world").forEach((c,n) -> System.out.printf("'%c': %d%n", c, n));

        System.out.println("\n=== Roman to Int ===");
        String[] romans = {"III","IV","IX","LVIII","MCMXCIV","MMXXIV"};
        for (String r2 : romans) System.out.printf("%-10s = %d%n", r2, romanToInt(r2));
    }
}
