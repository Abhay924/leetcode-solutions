class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];
        backtrack(0, n, board, cols, diag1, diag2, ans);
        return ans;
    }

    private void backtrack(int row, int n, char[][] board, boolean[] cols,
                           boolean[] diag1, boolean[] diag2, List<List<String>> ans) {
        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (char[] r : board) temp.add(new String(r));
            ans.add(temp);
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n;
            int d2 = row + col;
            if (cols[col] || diag1[d1] || diag2[d2]) continue;
            cols[col] = diag1[d1] = diag2[d2] = true;
            board[row][col] = 'Q';
            backtrack(row + 1, n, board, cols, diag1, diag2, ans);
            board[row][col] = '.';
            cols[col] = diag1[d1] = diag2[d2] = false;
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna