class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j, m, n);
                }
            }
        }
        
        return numIslands;
    }

    private void dfs(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == '0') {
            return;
        }

        // Step 4b: Sink the current part of the island
        grid[i][j] = '0';

        // Step 4c: Explore all 4 adjacent directions
        dfs(grid, i + 1, j, m, n); // Down
        dfs(grid, i - 1, j, m, n); // Up
        dfs(grid, i, j + 1, m, n); // Right
        dfs(grid, i, j - 1, m, n); // Left
    }
}