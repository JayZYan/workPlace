package LC;

import java.util.ArrayList;
import java.util.List;

public class LC0067_Add_Binary {
    public String addBinary(String a, String b) {
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while (aIndex >= 0 || bIndex >= 0) {
            int sum = carry;
            if (aIndex >= 0) {
                sum += a.charAt(aIndex--) - '0';
            }
            if (bIndex >= 0) {
                sum += b.charAt(bIndex--) - '0';
            }
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();


    }
    public static void main(String[] args) {
        String a = "11";
        String b = "11";
        LC0067_Add_Binary test = new LC0067_Add_Binary();
        System.out.println(test.addBinary(a, b));
        List<Integer> list = new ArrayList<>();
    }
}
