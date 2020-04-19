// https://leetcode.com/problems/majority-element/description/

public class MajorityElement {

    /*

    // HashMap
    // Time complexity : O(n)
    // Space complexity : O(n)

    public int majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!counts.containsKey(num)) counts.put(num, 1);
            else counts.put(num, counts.get(num) + 1);
        }

        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue())
                majorityEntry = entry;
        }
        return majorityEntry.getKey();
    }
     */


    /*

    // Sorting
    // Time complexity : O(nlgn)
    // Space complexity : O(1) or O(n)

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
     */


    /*
    // Randomization Accepted?
    // Because more than ⌊n/2⌋ array indices are occupied by the majority element, a random array index is likely to contain the majority element.
    // we can just select a random index, check whether its value is the majority element, return if it is, and repeat if it is not.
    // The algorithm is verifiably correct because we ensure that the randomly chosen value is the majority element before ever returning.
    // Time complexity : O(∞)

    private int randRange(Random rand, int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    private int countOccurences(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num)
                count++;
        }
        return count;
    }

    public int majorityElement(int[] nums) {
        Random rand = new Random();
        int majorityCount = nums.length / 2;
        while (true) {
            int candidate = nums[randRange(rand, 0, nums.length)];
            if (countOccurences(nums, candidate) > majorityCount)
                return candidate;
        }
    }
     */


    /*
    // Divide and Conquer
    // If we know the majority element in the left and right halves of an array,
    // we can determine which is the global majority element in linear time.
    // Here, we apply a classical divide & conquer approach that recurses on the left and right
    // halves of an array until an answer can be trivially achieved for a length-1 array.
    // Note that because actually passing copies of subarrays costs time and space,
    // we instead pass lo and hi indices that describe the relevant slice of the overall array.
    // In this case, the majority element for a length-1 slice is trivially its only element, so the recursion stops there.
    // If the current slice is longer than length-1, we must combine the answers for the slice's left and right halves.
    // If they agree on the majority element, then the majority element for the overall slice is obviously the same1.
    // If they disagree, only one of them can be "right", so we need to count the occurrences of the left and right majority
    // elements to determine which subslice's answer is globally correct. The overall answer for the array is thus the majority element between indices 0 and nn.

    // Time complexity : O(nlgn)
    // Space complexity : O(lgn)

    private int countInRange(int[] nums, int num, int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            if (nums[i] == num) count++;
        }
        return count;
    }

    private int majorityElementRec(int[] nums, int low, int high) {
        // base case; the only element in an array of size 1 is the majority element.
        if (low == high) return nums[low];

        // recurse on left and right halves of this slice.
        int mid = (high - low) / 2 + low;
        int left = majorityElementRec(nums, low, mid);
        int right = majorityElementRec(nums, mid + 1, high);

        // if the two halves agree on the majority element, return it.
        if (left == right) return left;

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, low, high);
        int rightCount = countInRange(nums, right, low, high);

        return leftCount > rightCount ? left : right;
    }

    public int majorityElement(int[] nums) {
        return majorityElementRec(nums, 0, nums.length - 1);
    }
     */


    // Boyer-Moore Voting Algorithm
    // Essentially, what Boyer-Moore does is look for a suffix sufsuf of nums where suf[0] is the majority element in that suffix.
    // To do this, we maintain a count, which is incremented whenever we see an instance of our current candidate for majority
    // element and decremented whenever we see anything else. Whenever count equals 0, we effectively forget about everything
    // in nums up to the current index and consider the current number as the candidate for majority element.
    // Therefore, given that it is impossible (in both cases) to discard more majority elements than minority elements,
    // we are safe in discarding the prefix and attempting to recursively solve the majority element problem for the suffix.
    // Eventually, a suffix will be found for which count does not hit 0, and the majority element of that suffix will necessarily
    // be the same as the majority element of the overall array.

    // Mention that the majority element in an array is more than ⌊n/2⌋, if there 's no majority element, this will return
    // the element appears most in last halves.

    // Time complexity : O(n)
    // Space complexity : O(1)

    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0)
                candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

}
