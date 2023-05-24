import java.util.function.BiFunction;

public class GCDExample {
    public static void main(String[] args) {
        int a = 36;
        int b = 48;

        BiFunction<Integer, Integer, Integer> gcdFunction = (x, y) -> {
            while (y != 0) {
                int remainder = x % y;
                x = y;
                y = remainder;
            }
            return x;
        };
        int gcd = gcdFunction.apply(a, b);

        System.out.println("НОД чисел " + a + " и " + b + " = " + gcd);
    }
}
