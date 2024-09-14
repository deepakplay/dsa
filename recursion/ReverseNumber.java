package recursion;

public class ReverseNumber {

    static int reverse(int var, int reversed) {
        if (var == 0)
            return reversed;

        int digit = var % 10;
        return reverse(var / 10, digit + reversed * 10);
    }

    public static void main(String[] args) {
        int var = 12345;
        int rev = reverse(var, 0);
        System.out.println("Reversed number: " + rev);
    }
}