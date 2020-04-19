// https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking

public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int[] array) {
        int start = 0, end = array.length - 1;
        if (end == -1) {
            return 0;
        }

        while (start < end) {
            int mid = start + ((end - start) >> 1);
            if (array[mid] > array[end]) {
                start = mid + 1;
            } else if (array[mid] < array[start]) {
                end = mid;
            } else {
                end--;
            }
        }
        return array[end];
    }
    
    public static void main(String[] args) {
        int[] array = new int[] { 1,1,1,0,1};
        var sol = new MinNumberInRotateArray();
        int resp = sol.minNumberInRotateArray(array);
        System.out.println(resp);
    }
}