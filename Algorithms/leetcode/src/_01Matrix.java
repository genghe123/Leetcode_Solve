import java.util.LinkedList;
import java.util.Queue;

public class _01Matrix {
    public int[][] updateMatrix1(int[][] matrix) {
        if (matrix == null) return null;

        int row = matrix.length;
        if (row == 0) return matrix;
        int col = matrix[0].length;
        if (col == 0) return matrix;

        int[][] dist = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dist[i][j] = Integer.MAX_VALUE - 10000; // minus a number to avoid unsafe operation (out of bounds)
            }
        }

        // First pass: check for left and top
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                    continue;
                }
                if (i > 0) dist[i][j] = Math.min(dist[i][j], dist[i - 1][j] + 1);
                if (j > 0) dist[i][j] = Math.min(dist[i][j], dist[i][j - 1] + 1);
            }
        }

        // Second pass: check for bottom and right
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                if (i < row - 1) dist[i][j] = Math.min(dist[i][j], dist[i + 1][j] + 1);
                if (j < col - 1) dist[i][j] = Math.min(dist[i][j], dist[i][j + 1] + 1);
            }
        }
        return dist;
    }

    public int[][] updateMatrix2(int[][] matrix) {
        if (matrix == null) return null;

        int row = matrix.length;
        if (row == 0) return matrix;
        int col = matrix[0].length;
        if (col == 0) return matrix;

        int[][] dist = new int[row][col];
        Queue<int[]> queue = new LinkedList<>();

        // First run: put all 0 elements in queue in order to BFS
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] pair = queue.poll();
            for (int i = 0; i < 4; i++) {
                int new_r = pair[0] + dir[i][0], new_c = pair[1] + dir[i][1];
                if (new_r >= 0 && new_c >= 0 && new_r < row && new_c < col) {
                    if (dist[new_r][new_c] > dist[pair[0]][pair[1]] + 1) {
                        dist[new_r][new_c] = dist[pair[0]][pair[1]] + 1;
                        queue.offer(new int[]{new_r, new_c});
                    }
                }
            }
        }
        return dist;
    }
}
