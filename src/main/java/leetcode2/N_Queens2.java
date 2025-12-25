package leetcode2;

public class N_Queens2 {
    public int totalNQueens(int n) {
        return solve(n, 0, new boolean[n], new boolean[2 * n], new boolean[2 * n]);
    }

    private int solve(int n, int row, boolean[] cols, boolean[] diag1, boolean[] diag2) {
        if (row == n) return 1;

        int count = 0;
        for (int col = 0; col < n; col++) {
            int d1 = row - col + n;
            int d2 = row + col;

            if (cols[col] || diag1[d1] || diag2[d2]) continue;

            cols[col] = diag1[d1] = diag2[d2] = true;
            count += solve(n, row + 1, cols, diag1, diag2);
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
        return count;


    }
}
