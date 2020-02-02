import java.util.Arrays;

/**
 * 描述
 * Given a number represented as an array of digits, plus one to the number.
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        return add(digits, 1);
    }

    private int[] add(int[] digits, int i) {
        int carry = i;
        for (int j = digits.length - 1; j >= 0; j--) {
            digits[j] += carry;
            carry = digits[j] / 10;
            digits[j] %= 10;
        }
        if (carry > 0) {
            int newArray[] = new int[digits.length + 1];
            newArray[0] = carry;
            System.arraycopy(digits, 0, newArray, 1, digits.length);
            return newArray;
        } else return digits;
    }

    public static void main(String[] args) {
        int digits[] = new int[]{9};
        int[] ints = new PlusOne().plusOne(digits);
        System.out.println(Arrays.toString(ints));
    }
}
