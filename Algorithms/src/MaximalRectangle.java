// https://leetcode.com/problems/maximal-rectangle/description/

import java.util.Stack;

public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int row = matrix.length;
        int col = matrix[0].length;

        int[] h = new int[col + 1];
        h[col] = 0;
        int max = 0;

        for (int i = 0; i < row; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < col + 1; j++) {
                h[j] = (j < col && matrix[i][j] == '1') ? h[j] + 1 : 0;

            }
        }

        //todo
        return 0;
    }
}
