import java.util.*;
import java.lang.*;

public class array2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        fun(nums, n);
        StringBuilder sb = new StringBuilder();
        for (Integer e : nums) {
            sb.append(e).append(" ");
        }
        if (sb.length()>=1){
            sb.deleteCharAt(sb.length()-1);
        }
        System.out.println(sb.toString());
    }

    private static void fun(int[] nums, int n) {
        Arrays.sort(nums);
    }
}
