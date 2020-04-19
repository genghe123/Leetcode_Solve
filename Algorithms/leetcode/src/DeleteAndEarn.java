// https://leetcode.com/problems/delete-and-earn/description/

public class DeleteAndEarn {
    //todo comprehend
    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] values = new int[n];
        for (int num : nums) {
            values[num] += num;
        }

        int take = 0, skip = 0;
        for (int i = 0; i < n; i++) {
            int tmpTake = skip + values[i];
            int tmpSkip = Math.max(take, skip);
            take = tmpTake;
            skip = tmpSkip;
        }

        return Math.max(take, skip);
    }
}
